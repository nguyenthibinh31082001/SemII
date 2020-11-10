/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL1;

import BTTH.BTTH1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class NhanVien_BTTL1 {
    private Connection conn;
    
    ArrayList<NhanVien> lstNhanVien = new ArrayList<>();
    
    public NhanVien_BTTL1() {
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối tới CSDL thành công!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    
    public static void main(String[] args) {
        NhanVien_BTTL1 nhanVien_BTTL1 = new NhanVien_BTTL1();
        
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập dữ liệu nhân viên\n");
            System.out.printf("\t2. Hiển thị danh sách nhân viên\n");
            System.out.printf("\t3. Tìm kiếm nhân viên theo email\n");
            System.out.printf("\t4. Tìm kiếm nhân viên theo tên\n");
            System.out.printf("\t5. Sửa thông tin nhân viên theo mã nhân viên\n");
            System.out.printf("\t6. Xóa thông tin nhân viên theo mã nhân viên.\n");
            System.out.printf("\t7. Thoát chương trình\n");
            
            System.out.printf("Chọn chức năng 1-7: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    NhanVien nv = new NhanVien();
                    nv.input();
                    nhanVien_BTTL1.nhap(nv);
                    break;
                case 2:
                    nhanVien_BTTL1.hienthi();
                    break;
                case 3:
                    nhanVien_BTTL1.searchEmail();
                    break;
                case 4:
                    nhanVien_BTTL1.searchName();
                    break;
                case 5:
                    nhanVien_BTTL1.updateMaNV();
                    break;
                case 6:
                    nhanVien_BTTL1.deleteMaNV();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-7!!!");
            }
        }while(true);
        
    }
    public void nhap(NhanVien Nv) {
        try {
            String sql = "INSERT INTO tblNhanVien(HoTen, NamSinh, PhongBan, Email) VALUES\n"
        + "(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Nv.getHoTen());
            ps.setInt(2, Nv.getNamSinh());
            ps.setString(3, Nv.getPhongBan());
            ps.setString(4, Nv.getEmail());
            
            int row = ps.executeUpdate(); // Trả về số dòng dữ liệu được thêm
            if (row > 0) {
            System.err.println("Thêm dữ liệu thành công!!!");
            } else {
            System.err.println("Lỗi, thêm thất bại!!!");
            }
        } catch (SQLException ex) {
//            ex.printStackTrace();
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void hienthi() {
        try {
            String sql = "SELECT * FROM tblNhanVien";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.printf("%s %10s %15s %15s %20s\n",
            "MaNV", "HoTen", "NamSinh", "PhongBan", "Email");
            while (rs.next()) {
                NhanVien p = new NhanVien(rs.getInt("MaNV"),
                rs.getString("HoTen"), rs.getInt("NamSinh"), rs.getString("PhongBan"),
                rs.getString("Email"));
                p.display();
            }
            System.out.println("-----------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void searchEmail() {
//        try {
//            String sql = "SELECT * FROM tblNhanVien WHERE Email LIKE ?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            Scanner sc  = new Scanner(System.in);
//            System.out.printf("Nhập email cần tìm: ");
//            String Email = sc.nextLine();
//            
//            pst.setNString(1, "'%"+ Email + "%'");
//            System.out.printf("%s %10s %15s %15s %20s\n",
//            "MaNV", "HoTen", "NamSinh", "PhongBan", "Email");
//            ResultSet rs = pst.executeQuery();
//            
//            while(rs.next()){
//                NhanVien p = new NhanVien(rs.getInt("MaNV"),
//                rs.getString("HoTen"), rs.getInt("NamSinh"), rs.getString("PhongBan"),
//                rs.getString("Email"));
//                p.display();
////                System.out.println("Mã: " + rs.getInt("MaNV"));
////                System.out.println("Họ tên: " + rs.getNString("HoTen"));
////                System.out.println("Năm sinh: " + rs.getInt("NamSinh"));
////                System.out.println("Phòng ban: " + rs.getNString("PhongBan"));
////                System.out.println("Email: " + rs.getNString("Email"));
//            }
//        } catch (SQLException ex) {
//            System.err.println("Lỗi: " + ex.getMessage());
//        }
        
        try {
            String sql = "SELECT * FROM tblNhanVien WHERE Email LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            Scanner sc  = new Scanner(System.in);
            System.out.printf("Nhập email cần tìm: ");
            String Email = sc.nextLine();
            
            pst.setNString(1, "%"+ Email+ "%");
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Mã: " + rs.getInt("MaNV"));
                System.out.println("Họ tên: " + rs.getNString("HoTen"));
                System.out.println("Năm sinh: " + rs.getInt("NamSinh"));
                System.out.println("Phòng ban: " + rs.getNString("PhongBan"));
                System.out.println("Email: " + rs.getNString("Email"));
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
    public void searchName() {
        try {
            String sql = "SELECT * FROM tblNhanVien WHERE HoTen LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            Scanner sc  = new Scanner(System.in);
            System.out.printf("Nhập tên cần tìm: ");
            String name = sc.nextLine();
            
            pst.setNString(1, "%"+ name+ "%");
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Mã: " + rs.getInt("MaNV"));
                System.out.println("Họ tên: " + rs.getNString("HoTen"));
                System.out.println("Năm sinh: " + rs.getInt("NamSinh"));
                System.out.println("Phòng ban: " + rs.getNString("PhongBan"));
                System.out.println("Email: " + rs.getNString("Email"));
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
    public void updateMaNV() {
//        try { //Cách 1:
//            Scanner sc = new Scanner(System.in);
//            conn = Connect.getConnection();
//            // Khai báo câu lệnh SQL
//            String sql = "UPDATE tblNhanVien SET HoTen=?,NamSinh=?,PhongBan=?,Email=? WHERE MaNV=?";
//
//            PreparedStatement pst = conn.prepareStatement(sql);
//            System.out.printf("\tNhập tên nhân viên: ");
//            pst.setNString(1, sc.nextLine());
//            System.out.printf("\tNhập năm sinh: ");
//            pst.setInt(2, sc.nextInt());
//            sc.nextLine(); // clear
//            System.out.printf("\tNhập phòng ban: ");
//            pst.setNString(3, sc.nextLine());
//            System.out.printf("\tNhập email: ");
//            pst.setNString(4, sc.nextLine());
//            System.out.println("");
//            System.out.printf("Nhập mã nhân viên cần sửa: ");
//            pst.setInt(5, sc.nextInt());
//
//            int result = pst.executeUpdate();
//            if (result > 0) {
//                System.err.println("Sửa dữ liệu thành công!!!");
//            }
//        } catch (SQLException ex) {
//            System.err.println("Lỗi: " + ex.getMessage());
//        }
        //Cách 2:
        try {
            System.out.printf("Nhập mã nhân viên cần sửa: ");
            Scanner s = new Scanner(System.in);
            int code = s.nextInt();
            s.nextLine();
            System.out.printf("\tNhập tên nhân viên: ");
            String name = s.nextLine();
            System.out.printf("\tNhập năm sinh: ");
            int namsinh = s.nextInt();
            s.nextLine(); // clear
            System.out.printf("\tNhập phòng ban: ");
            String phongban = s.nextLine();
            System.out.printf("\tNhập email: ");
            String email = s.nextLine();
            
            String sql = "UPDATE tblNhanVien SET HoTen=?,NamSinh=?,PhongBan=?,Email=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, namsinh);
            ps.setString(3, phongban);
            ps.setString(4, email);
            ps.setInt(5, code);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.err.println("Sửa thông tin nhân viên thành công!");
            } else {
                System.err.println("Lỗi, sửa không thành công");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void deleteMaNV() {
        try {
            String sql = "DELETE FROM tblNhanVien WHERE MaNV = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhập mã nhân viên cần xóa: ");
            pst.setInt(1, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.err.println("Xóa dữ liệu thành công!!!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }

    }
}
