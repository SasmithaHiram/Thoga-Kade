/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thogakade;

import java.sql.*;

/**
 *
 * @author sasmi
 */
public class ThogaKade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String SQL = "Insert into Customer values('C9999','Nirot','Panadura',50000)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "1234");
            Statement stm = connection.createStatement();
            stm.executeUpdate(SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
