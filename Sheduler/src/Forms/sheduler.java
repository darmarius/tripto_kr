package Forms;
import classes.EVENTS;
import classes.Notification;
import classes.Notyfire;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class sheduler extends javax.swing.JFrame {
    
    String choosenday;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dateTimeFormat;
    Notification Noty = new Notification();
    EVENTS Event = new EVENTS();
      
    
    public sheduler() throws SQLException, InterruptedException, FileNotFoundException, IOException {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        choosenday=dateFormat.format(new java.util.Date());
        initComponents();
        showEvents();
        Thread t = (new Thread((Runnable) new Notyfire()));
        t.start();
        
    }
      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sheduler");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        dateChooserPanel1.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserPanel1.setLocale(new java.util.Locale("en", "", ""));
    dateChooserPanel1.setShowOneMonth(true);
    dateChooserPanel1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dateChooserPanel1OnSelectionChange(evt);
        }
    });

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "ID", "Date", "Time", "Type", "Place"
        }
    ));
    jScrollPane2.setViewportView(jTable2);

    jMenu1.setText("Add");
    jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            AddEventButton(evt);
        }
    });
    jMenuBar1.add(jMenu1);

    jMenu2.setText("Remove");
    jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            DeleteEvent(evt);
        }
    });
    jMenuBar1.add(jMenu2);

    jMenu3.setText("Notifications");
    jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            AddNotificationsButton(evt);
        }
    });
    jMenuBar1.add(jMenu3);

    setJMenuBar(jMenuBar1);

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(dateChooserPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 567, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 567, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(dateChooserPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(12, 12, 12))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showEvents() throws SQLException{
       ArrayList<EVENTS> list = Event.getEventsList(choosenday);
       DefaultTableModel mod = (DefaultTableModel) jTable2.getModel();
       for( int i = mod.getRowCount() - 1; i >= 0; i-- ) {
        mod.removeRow(i);}
       Object[] row = new Object[5];
       for (int i = 0 ; i<list.size(); i++)
       {
           row[0]=list.get(i).getId();
           row[1]=list.get(i).getDate();
           row[2]=list.get(i).getTime();
           row[3]=list.get(i).getType();
           row[4]=list.get(i).getPlace();
           mod.addRow(row);
       }}
      
    private void dateChooserPanel1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnSelectionChange
        choosenday= dateFormat.format(dateChooserPanel1.getSelectedDate().getTime());
        try {
            showEvents();
        } catch (SQLException ex) {
            Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanel1OnSelectionChange

    private void DeleteEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteEvent
        int selected = jTable2.getSelectedRow();
        int sure = JOptionPane.showConfirmDialog(null, "You are sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (sure  == JOptionPane.YES_OPTION){
                    Event.DeleteEvent(jTable2.getModel().getValueAt(selected,0));
                    try {
                showEvents();
            } catch (SQLException ex) {
                Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    }//GEN-LAST:event_DeleteEvent

    private void AddEventButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEventButton
           AddForm AddForm1 = new AddForm();
           this.enable(false);
           AddForm1.show();          
    }//GEN-LAST:event_AddEventButton

    private void AddNotificationsButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNotificationsButton
        try {
            Notifications notyForm = new Notifications();
            this.enable(false);
            notyForm.show();
        } catch (SQLException ex) {
            Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddNotificationsButton
    
    public void Notify() throws SQLException, InterruptedException{
    
    while (true){
    String CurrTime = dateTimeFormat.format(new java.util.Date());
    String CurrDate = dateFormat.format(new java.util.Date());
    ArrayList<Notification> list = Noty.getNotificationsList(CurrDate);
    for (int i = 0;i<list.size();i++){     
     String datetimenotify =list.get(i).getDate()+" "+list.get(i).getTime();
     datetimenotify = datetimenotify.substring(0, datetimenotify.length()-3);
     if (CurrTime == null ? datetimenotify == null : CurrTime.equals(datetimenotify)){
         Noty.Ring(list.get(i).getId());
         Noty.DeleteNotification(list.get(i).getId());
     }
        
    }
    Thread.sleep(60000);
    }
    } 
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new sheduler().setVisible(true);

                } catch (SQLException ex) {
                   Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InterruptedException ex) {
                    Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(sheduler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    
}
