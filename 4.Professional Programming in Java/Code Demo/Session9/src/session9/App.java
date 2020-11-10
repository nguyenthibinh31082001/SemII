/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        App app = new App();
        
        while(true){
            System.out.println("================MENU=======================");
            System.out.println("1. Danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Chỉnh sửa"); 
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm theo họ tên");
            System.out.println("6. Tạo bảng khách hàng");
            System.out.println("7. Thoát");
            
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1: 
                    app.display();
                    break;
                case 2: 
                    app.create();
                    break;
                case 3: 
                    app.update();
                    break;
                case 4: 
                    app.delete();
                    break;
                case 5: 
                    app.search();
                    break;
                case 6: 
                    app.createTable();
                    break;
                case 7: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn phải chọn chức năng: 1->7");
                    break;
            }
        }
        
    }

    public void createTable() {
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "CREATE TABLE Customer("
                    + "id INT PRIMARY KEY IDENTITY(1,1), "
                    + "fullname NVARCHAR(30) NOT NULL, "
                    + "address NVARCHAR(255), "
                    + "birthday DATE, "
                    + "gender bit "
                    + ")";

            Statement st = conn.createStatement();
            int result = st.executeUpdate(sql);
            if (result > 0) {
                System.out.println("Tạo bảng thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }

    }

    public void create() {
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "INSERT INTO Customer(fullname,address,birthday,gender) VALUES(?,?,?,?)";

            Scanner sc = new Scanner(System.in);

            PreparedStatement pst = conn.prepareStatement(sql);
            System.out.println("Họ tên");
            pst.setNString(1, sc.nextLine());
            System.out.println("Địa chỉ");
            pst.setNString(2, sc.nextLine());
            System.out.println("Ngày sinh");
            LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            pst.setDate(3, Date.valueOf(ld));
            System.out.println("Gioi tinh: ");
            pst.setBoolean(4, sc.nextBoolean());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Thêm mới dữ liệu thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }

    }

    public void update() {
        Connection conn = null;
        try {
            Scanner sc = new Scanner(System.in);
            conn = DbUtil.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "UPDATE TABLE Customer SET fullname=?,address=?,birthday=?,gender=? WHERE id=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            System.out.println("Họ tên");
            pst.setNString(1, sc.nextLine());
            System.out.println("Địa chỉ");
            pst.setNString(2, sc.nextLine());
            System.out.println("Ngày sinh");
            LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            pst.setDate(3, Date.valueOf(ld));
            System.out.println("Gioi tinh: ");
            pst.setBoolean(4, sc.nextBoolean());
            System.out.println("Mã khách hàng cần sửa: ");
            pst.setInt(5, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Sửa dữ liệu thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }

    }

    public void delete() {
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "DELETE FROM Customer WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            pst.setInt(1, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Xóa dữ liệu thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }

    }

    public void search() {
        Connection conn = null;
        
        try {
            conn = DbUtil.getConnection();
            
            String sql = "SELECT * FROM Customer WHERE fullname LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            Scanner sc  = new Scanner(System.in);
            System.out.println("Họ tên cần tìm: ");
            String fullname = sc.nextLine();
            
            pst.setNString(1, "'%"+ fullname+ "%'");
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Mã: " + rs.getInt("id"));
                System.out.println("Họ tên: " + rs.getNString("fullname"));
                System.out.println("Địa chỉ: " + rs.getNString("address"));
                System.out.println("Ngày sinh: " + rs.getDate("birthday"));
                System.out.println("Giới tính: " + (rs.getBoolean("gender") ? "Nam": "Nữ"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }
    }
    
    

    public void display() {
        Connection conn = null;
        
        try {
            conn = DbUtil.getConnection();
            
            String sql = "SELECT * FROM Customer";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Mã: " + rs.getInt("id"));
                System.out.println("Họ tên: " + rs.getNString("fullname"));
                System.out.println("Địa chỉ: " + rs.getNString("address"));
                System.out.println("Ngày sinh: " + rs.getDate("birthday"));
                System.out.println("Giới tính: " + (rs.getBoolean("gender") ? "Nam": "Nữ"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }
    }
}
