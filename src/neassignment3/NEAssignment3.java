/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neassignment3;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nate c0711874
 */
public class NEAssignment3 {

    
    public static void main(String[] args) {
       
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the customer id:");
            int customerId = keyboard.nextInt();
        
        String sqla = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE customerid = ?";
        String sqlb = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        
        try {
           Class.forName("org.apache.derby.jdbc.ClientDriver");     
           String jdbc = "jdbc:derby://localhost:1527/sample";
           
           Connection conn = DriverManager.getConnection(jdbc, "app", "app");
           PreparedStatement statement = conn.prepareStatement(sqla);
           
           
           ResultSet rs1 = statement.executeQuery();
           
           while (rs1.next()) {
               int id = rs1.getInt("CUSTOMER_ID");
               System.out.print("CUSTOMER_ID: " + id);
           
           }

           conn.close();
           
        }
          catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NEAssignment3.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
    }
    
}
