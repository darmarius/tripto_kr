
package classes;

import java.util.*;
import java.sql.*;

public class connector
{    
    public static void main(String[] args) 
    {
        String url="jdbc:mysql://localhost/sheduler";                               // Setup Connection URL
        String userid="root";                                                   // Default username is root
        String password="1212";                                                     // Default Password is empty string
        
        try
        {
            Scanner sc = new Scanner(System.in);                                // For reading console input
            
            System.out.println("\n Enter name : ");
            String name = sc.next();
            
            String query = " insert into dummy values('"+name+"')";             // Create query string to insert name into table
            
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            
            Connection con = DriverManager.getConnection(url,userid,password);  // Connect to Database using credentials
            
            Statement stmt = con.createStatement();                             // Create statement
            
            stmt.executeUpdate(query);                                          // Execute Query
            
            con.close();                                                        // Close the open connection
            
            System.out.println("\n Data Inserted !");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("\n Error : "+e);
        } catch (SQLException e) {
            System.out.println("\n Error : "+e);
        }   
    }
}
