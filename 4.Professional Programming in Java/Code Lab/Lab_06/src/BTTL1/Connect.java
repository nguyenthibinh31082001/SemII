/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL1;

import BTTH.BTTH1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Connect {
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=lab_06","sa","123456789");
//            if(con!=null)
//            System.err.println("Kết nối tới CSDL thành công!");
//            else
//            System.err.println("Không kết nối vào CSDL được");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BTTH1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(BTTH1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
