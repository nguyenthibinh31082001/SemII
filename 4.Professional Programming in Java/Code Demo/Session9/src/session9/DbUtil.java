/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class DbUtil {
    // Khai bao driver ket noi loại cơ sở dữ liệu nào: Microsoft SQL Server || MySQL || Oracle ...
    static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // Khai báo chuỗi kết nối CSDL thông tin: địa chỉ cài đặt service sql : localhost <=> 127.0.0.1 <=> ip server: 210.245.38.40
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=TestJDBC";
    // Tên đăng nhập cơ sở dữ liệu
    static final String USERNAME = "sa";
    // Mật khẩu kết nối 
    static final String PASSWORD = "1234$";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Chưa có driver!");
        } catch (SQLException e){
            System.out.println("Lỗi kết nối CSDL: " + e.getMessage());
        }
        
        return conn;
    }
   
}
