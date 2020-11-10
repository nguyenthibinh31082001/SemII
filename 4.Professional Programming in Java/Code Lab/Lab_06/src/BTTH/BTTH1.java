/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BTTH1 {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=lab_06","sa","123456789");
            if(con!=null)
            System.out.println("Kết nối tới CSDL thành công!");
            else
            System.out.println("Không kết nối vào CSDL được");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BTTH1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(BTTH1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
