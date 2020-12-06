/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Signleton_Connect_Bai1 {
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=lab_06";
    private final String USERNAME = "sa";
    private final String PASSWORD = "123456789";

    static Signleton_Connect_Bai1 _instance;
    Connection connection;

    private Signleton_Connect_Bai1() throws SQLException{
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.err.println("Kết nối tới CSDL thành công!!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Lỗi kết nối CSDL " +e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Signleton_Connect_Bai1 getInstance() throws SQLException{

        if(_instance == null) {
            _instance = new Signleton_Connect_Bai1();
        }else if(_instance.getConnection().isClosed()) {
            _instance = new Signleton_Connect_Bai1();
        }
        return _instance;

    }
    public static void main(String[] args) {
    try {
        Signleton_Connect_Bai1 dbConnection = Signleton_Connect_Bai1.getInstance();
    } catch (Exception e) {

    }

    }
}
