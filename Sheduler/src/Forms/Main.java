package Forms;
import classes.EVENTS;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Main extends javax.swing.JFrame {
    
    String choosenday;
    SimpleDateFormat dateFormat;
    String url="jdbc:mysql://localhost/sheduler";                            
    String userid="root";   
    String password="1212";  
    
    public Main() throws SQLException {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        choosenday=dateFormat.format(new java.util.Date());
        System.out.println(choosenday);
        initComponents();
        showEvents();
    }
   
    
    public Connection getConnection()    {
        try {
            Connection connect = DriverManager.getConnection(url,userid,password);
            return connect;
        
        }   
        catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    public ArrayList<EVENTS> getEventsList() throws SQLException    {
        ArrayList<EVENTS> EventsList = new ArrayList<EVENTS>();
        Connection con = getConnection();
        String queryEVENTS ="SELECT * FROM events where rdate=' "+choosenday+"'";
        Statement st;
        ResultSet rs;
        try {
            st=con.createStatement();
            rs=st.executeQuery(queryEVENTS);
            EVENTS event1;
            while (rs.next())
            {
                event1= new EVENTS(rs.getInt("rid"),rs.getString("rdate"),rs.getString("rtime"),
                        rs.getString("rtype"),rs.getString("rplace"),rs.getBoolean("rnotify"));
                EventsList.add(event1);
            }
                
        }
        catch(SQLException e){return null;}
            
        return EventsList;
      
   }
  
    /**
     *
     * @throws SQLException
     */
    public void showEvents() throws SQLException{
       ArrayList<EVENTS> list = getEventsList();
       DefaultTableModel mod = (DefaultTableModel) jTable2.getModel();
       for( int i = mod.getRowCount() - 1; i >= 0; i-- ) {
        mod.removeRow(i);}
       Object[] row = new Object[4];
       for (int i = 0 ; i<list.size(); i++)
       {
           row[0]=list.get(i).getDate();
           row[1]=list.get(i).getTime();
           row[2]=list.get(i).getType();
           row[3]=list.get(i).getPlace();
           mod.addRow(row);
       }
       
           
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
            "Date", "Time", "Type", "Place"
        }
    ));
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTable2);

    jMenu1.setText("Add");
    jMenuBar1.add(jMenu1);

    jMenu2.setText("Remove");
    jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            DeleteEvent(evt);
        }
    });
    jMenuBar1.add(jMenu2);

    jMenu3.setText("Change");
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
            .add(dateChooserPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .add(18, 18, 18)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooserPanel1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnSelectionChange
        choosenday= dateFormat.format(dateChooserPanel1.getSelectedDate().getTime());
         System.out.println(choosenday);
        try {
            showEvents();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dateChooserPanel1OnSelectionChange

    private void DeleteEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteEvent
        int selected = jTable2.getSelectedRow();
        int sure = JOptionPane.showConfirmDialog(null, "You are sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (sure  == JOptionPane.YES_OPTION){
                    Connection con = getConnection();
                    String queryDelete ="delete FROM events "
                            + "where rdate = '"+(String) jTable2.getModel().getValueAt(selected,0)+"' "
                            + " and rtime= '"+(String) jTable2.getModel().getValueAt(selected,1)+"' "
                            + " and rtype= '"+(String) jTable2.getModel().getValueAt(selected,2)+"' "
                            + " and rplace= '"+(String) jTable2.getModel().getValueAt(selected,3)+"' ";
 
            try {
                Statement st = con.createStatement();
                st.executeUpdate(queryDelete);
                 showEvents();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    }//GEN-LAST:event_DeleteEvent

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
     
    }//GEN-LAST:event_jTable2MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
