/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;


public class  Notyfire implements Runnable {
    
    String choosenday;
    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateTimeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Notification Noty = new Notification();
    EVENTS Event = new EVENTS();
    


public Notyfire () throws SQLException, InterruptedException {
    
    
    } 

    @Override
    public void run() {
        while (true){
            try {
                String CurrTime = dateTimeFormat.format(new java.util.Date());
                String CurrDate = dateFormat.format(new java.util.Date());
                ArrayList<Notification> list = Noty.getNotificationsList(CurrDate);
                for (int i = 0;i<list.size();i++){
                    String datetimenotify =list.get(i).getDate()+" "+list.get(i).getTime();
                    datetimenotify = datetimenotify.substring(0, datetimenotify.length()-3);
                    if (CurrTime == null ? datetimenotify == null : CurrTime.equals(datetimenotify)){
                        Noty.Ring(list.get(i).getId());
                        //  Noty.DeleteNotification(list.get(i).getId());
                    }
                    
                }
                Thread.sleep(60000);
            } catch (SQLException ex) {
                Logger.getLogger(Notyfire.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Notyfire.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
}

        