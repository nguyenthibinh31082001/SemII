/*
╔═══╗╔═══╗╔═╗╔═╗╔══╗╔═╗─╔╗╔══╗╔═══╗     ╔═══╗╔═══╗╔╗─╔╗     ╔╗──╔╗╔═╗─╔╗
╚╗╔╗║║╔═╗║║║╚╝║║╚╣─╝║║╚╗║║╚╣─╝║╔═╗║     ║╔══╝╚╗╔╗║║║─║║     ║╚╗╔╝║║║╚╗║║
─║║║║║║─║║║╔╗╔╗║─║║─║╔╗╚╝║─║║─║║─╚╝     ║╚══╗─║║║║║║─║║     ╚╗║║╔╝║╔╗╚╝║
─║║║║║║─║║║║║║║║─║║─║║╚╗║║─║║─║║─╔╗     ║╔══╝─║║║║║║─║║     ─║╚╝║─║║╚╗║║
╔╝╚╝║║╚═╝║║║║║║║╔╣─╗║║─║║║╔╣─╗║╚═╝║     ║╚══╗╔╝╚╝║║╚═╝║     ─╚╗╔╝─║║─║║║
╚═══╝╚═══╝╚╝╚╝╚╝╚══╝╚╝─╚═╝╚══╝╚═══╝     ╚═══╝╚═══╝╚═══╝     ──╚╝──╚╝─╚═╝
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Minh Tuan
 */
public class DbUtil {

    private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=ProductManagement";
    private static String USER="sa";
    private static String PASSWORD="abc@123";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi kết nối CSDL" + e.getMessage());
        }
        return conn;
    }
}
