
package classes;

import Forms.sheduler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EVENTS{
  int id;
  String rdate;
  String rtime;
  String type;
  String place;


    public EVENTS (){}
    public EVENTS(int id,String rdate, String rtime, String type, String place) {
      this.id=id;
      this.rdate=rdate;
      this.rtime=rtime;
      this.type=type;
      this.place=place;

  }
    public EVENTS(String rdate, String rtime, String type, String place) {
      this.id=0;
      this.rdate=rdate;
      this.rtime=rtime;
      this.type=type;
      this.place=place;

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
    public void DeleteEvent(Object id){
        String queryDelete ="delete FROM events "+ "where rid ="+id;

            try {
                Connection con = getConnection();
                Statement st = con.createStatement();
                st.executeUpdate(queryDelete);
                } catch (SQLException ex) {
                Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void AddEvent (String rdate, String rtime, String type, String place){
        Connection con = getConnection();
        String queryInsert ="insert into events (rdate,rtime,rtype,rplace)"
                            +"values ('" +rdate+"','"+rtime+":00','"+type+"','"+place+"') ";
            try {
                Statement st = con.createStatement();
                st.executeUpdate(queryInsert);}
            catch (SQLException ex) {
                Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    public ArrayList<EVENTS> getEventsList(String day) throws SQLException    {
        ArrayList<EVENTS> EventsList = new ArrayList<EVENTS>();
        Connection con = getConnection();
        String queryEVENTS ="SELECT * FROM events where rdate>=' "+day+"'";
        Statement st;
        ResultSet rs;
        try {
            st=con.createStatement();
            rs=st.executeQuery(queryEVENTS);
            EVENTS event1;
            while (rs.next())
            {
                event1= new EVENTS(rs.getInt("rid"),rs.getString("rdate"),rs.getString("rtime"),rs.getString("rtype"),rs.getString("rplace"));
                EventsList.add(event1);
            }
                
        }
        catch(SQLException e){return null;}
            
        return EventsList;
      
   }
    
  public int getId(){return id;}
  public String getDate(){return rdate;}
  public String getTime(){return rtime;}
  public String getType(){return type;}
  public String getPlace(){return place;}
  
}
