
package classes;

import Forms.sheduler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Notification{
  int id;
  String rdate;
  String rtime;
  String eventid;

  public Notification(){}
  public Notification(int id,String rdate, String rtime, String eventid) {
      this.id=id;
      this.rdate=rdate;
      this.rtime=rtime;
      this.eventid=eventid;
    }
  public Notification(String rdate, String rtime, String eventid) {
      this.id=0;
      this.rdate=rdate;
      this.rtime=rtime;
      this.eventid=eventid; 
  }
  
  public  Connection getConnection()    {
        String url="jdbc:mysql://localhost/sheduler";                            
        String userid="root";   
        String password="1212";
        try {
            Connection connect = DriverManager.getConnection(url,userid,password);
            return connect;
        
        }   
        catch (SQLException ex) {
            Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
  public void DeleteNotification(Object id){
      String queryDelete ="delete FROM notifications "+ "where rid ="+id;

            try {
                Connection con = getConnection();
                Statement st = con.createStatement();
                st.executeUpdate(queryDelete);
                } catch (SQLException ex) {
                Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
  public void AddNotification(String rdate, String rtime, Object eventid){
  Connection con = getConnection();
  String queryInsert ="insert into notifications (rdate,rtime,eventid)"
                      +"values ('" +rdate+"','"+rtime+":00',"+eventid+")";
            try {
                Statement st = con.createStatement();
                st.executeUpdate(queryInsert);}
            catch (SQLException ex) {
                Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
  public ArrayList<Notification> getNotificationsList(String day) throws SQLException    {
        ArrayList<Notification> NotificationsList = new ArrayList<Notification>();
        Connection con = getConnection();
        String queryNotifications ="SELECT * FROM notifications where rdate>=' "+day+"'";
        Statement st;
        ResultSet rs;
        try {
            st=con.createStatement();
            rs=st.executeQuery(queryNotifications);
            Notification Notifications1;
            while (rs.next())
            {
                Notifications1= new Notification(rs.getInt("rid"),rs.getString("rdate"), rs.getString("rtime"), rs.getString("eventid"));
                NotificationsList.add(Notifications1);
            }
                
        }
        catch(SQLException e){return null;}
            
        return NotificationsList;
      
   }
  public void Ring(Object id){
      Connection con = getConnection();
      int a =0;
      String MyMessage = "";
      String queryNotifications =
              "SELECT events.rtype, events.rplace, events.rtime "
              + "FROM sheduler.events,sheduler.notifications\n" 
              + "where events.rid=notifications.eventid and notifications.rid="+id;
       try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(queryNotifications);
            while (rs.next()){
            MyMessage= rs.getString("rtype")+" "+rs.getString("rplace")+" "+rs.getString("rtime"); 
            } }
        catch(SQLException e){}
        Thread t = new Thread((Runnable) new Sound());
        t.start();
        do{
            a= JOptionPane.showConfirmDialog(null,MyMessage, "EVENT!!!", JOptionPane.YES_NO_OPTION);  
        }while (a !=JOptionPane.YES_OPTION);
    t.stop();        
  }
  
  public int getId(){return id;}
  public String getDate(){return rdate;}
  public String getTime(){return rtime;}
  public String geteventid(){return eventid;}

}
