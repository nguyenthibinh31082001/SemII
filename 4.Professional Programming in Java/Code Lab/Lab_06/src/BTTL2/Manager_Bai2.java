/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL2;

import BTTL1.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Manager_Bai2 {
    private Connection conn;
    
    ArrayList<GiaoDich>lstNhanVien = new ArrayList<>();
    
    public Manager_Bai2() {
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối tới CSDL thành công!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    
    public static void main(String[] args) {
        Manager_Bai2 bai2 = new Manager_Bai2();
        
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.println("1. Danh sách danh mục và danh sách giao dịch.");
            System.out.println("2. Nhập giao dịch.");
            System.out.println("3. Sửa giao dịch");
            System.out.println("4. Xóa giao dịch");
            System.out.println("5. Thống kê chi tiêu theo danh mục.");
            System.out.println("6. Thoát chương trình.");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Danh sách danh mục: ");
                    bai2.DsDanhMuc();
                    System.out.println("Danh sách giao dịch: ");
                    bai2.DsGiaoDich();
                    
                    break;
                case 2:
                    bai2.inputGD();
                    break;
                case 3:
                    bai2.updateMaGD();
                    break;
                case 4:
                    bai2.deleteMaGD();
                    break;
                case 5:
                    bai2.thongkeDM();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-6!!!");
            }
        }while(true);
        
    }
    public void DsDanhMuc() {
        Connection conn = null;
        try {
            conn = Connect.getConnection();

            String sql = "SELECT * FROM tblDanhMuc";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            System.out.printf("%s %10s\n","MaDM", "TenDM");
            while (rs.next()) {
                DanhMuc d = new DanhMuc(rs.getInt("MaDM"),
                rs.getString("TenDM"));
                d.display();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println("Lỗi kết nối CSDL");
                }
            }
        }
    }
    private void DsGiaoDich() {
         Connection conn = null;

        try {
            conn = Connect.getConnection();

            String sql = "SELECT * FROM tblGiaoDich";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("\tMã GD: " + rs.getInt("MaGD"));
                System.out.println("\tTên GD: " + rs.getNString("TenGD"));
                System.out.println("\tNgày GD: " + rs.getDate("NgayGD"));
                System.out.println("\tMã DM: " + rs.getInt("MaDM"));
                System.out.println("\tSố Tiền: " + rs.getInt("SoTien"));
                System.out.println("\n");
            }

        } catch (SQLException e) {
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
//    public void DsGiaoDich() {
//        Connection conn = null;
//        try {
//            conn = Connect.getConnection();
//
//            String sql = "SELECT * FROM tblGiaoDich";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            System.out.printf("%s %10s %10s %10s %10s\n","MaGD", "TenGD","NgayGD","MaDM","SoTien");
//            while (rs.next()) {
//                Scanner sc = new Scanner(System.in);
//                GiaoDich g = new GiaoDich(
//                        rs.getInt("MaGD"),
//                        rs.getString("TenGD"),
////                        rs.getDate("NgayGD"),
//                        LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                        pst.setDate(2, Date.valueOf(ld));
//                        rs.getString("MaDM"),
//                        rs.getString("SoTien")
//                        );
//                        g.display();
//            }
//        } catch (SQLException e) {
//            e.getStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    System.err.println("Lỗi kết nối CSDL");
//                }
//            }
//        }
//    }
    public void inputGD() {
        Connection conn = null;
        try {
            conn = Connect.getConnection();

            String sql = "INSERT INTO tblGiaoDich(TenGD,NgayGD,MaDM,SoTien) VALUES(?,?,?,?)";
            Scanner sc = new Scanner(System.in);
            PreparedStatement pst = conn.prepareStatement(sql);
            System.out.println("Nhập thông tin giao dịch:");
            System.out.print("\tNhập tên giao dịch:");
            pst.setNString(1, sc.nextLine());
            System.out.print("\tNhập ngày giao dịch:");
            LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            pst.setDate(2, Date.valueOf(ld));
            System.out.print("\tNhập mã danh mục:");
            pst.setNString(3, sc.nextLine());
            System.out.print("\tNhập số tiền:");
            pst.setFloat(4, sc.nextFloat());
            
            int result = pst.executeUpdate();
            if (result > 0) {
                System.err.println("Thêm mới dữ liệu thành công!!!");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println("Lỗi kết nối CSDL!!");
                }
            }
        }
    }
    public void updateMaGD() {
        Connection conn = null;
        try {
            Scanner sc = new Scanner(System.in);
            conn = Connect.getConnection();
            String sql = "UPDATE tblGiaoDich SET TenGD=?,NgayGD=?,MaDM=?,SoTien=? WHERE MaGD=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            
            System.out.printf("\tNhập tên giao dịch: ");
            pst.setNString(1, sc.nextLine());
            System.out.printf("\tNhập ngày giao dịch: ");
            LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            pst.setDate(2, Date.valueOf(ld));
            System.out.printf("\tNhập mã danh mục: ");
            pst.setInt(3, sc.nextInt());
            System.out.printf("\tNhập số tiền: ");
            pst.setFloat(4, sc.nextFloat());
            System.out.printf("\tNhập mã giao dịch cần sửa: ");
            pst.setInt(5, sc.nextInt());
            
            int result = pst.executeUpdate();
            if (result > 0) {
                System.err.println("Sửa dữ liệu thành công");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
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
    public void deleteMaGD() {
        try {
            String sql = "DELETE FROM tblGiaoDich WHERE MaGD = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhập mã giao dịch cần xóa: ");
            pst.setInt(1, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.err.println("Xóa dữ liệu thành công!!!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    private void thongkeDM() {
        
    }
}
