/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ManagerProduct {

    private Connection conn;
    ArrayList<Product> lstProduct = new ArrayList<>();
    
    public ManagerProduct() {
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối thành công!!!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }

    public static void main(String[] args) {
        ManagerProduct product = new ManagerProduct();
        Product p = new Product();
        
        while (true) {
            System.out.println("\t.: MENU :.");
            System.out.println("1. Hiển thị danh sách sản phẩm ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Sửa ");
            System.out.println("4. Xóa ");
            System.out.println("5. Đếm số lượng theo năm nhập từ bàn phím ");
            System.out.println("6. Tìm sản phẩm theo danh mục.  ");
            System.out.println("7. Sắp xếp giảm dần dần theo ngày nhập");
            System.out.println("8. Thoát");

            Scanner s = new Scanner(System.in);
            try {
                System.out.printf("Mời chọn từ 1 -> 8: ");
                int choose = s.nextInt();
                
                switch (choose) {
                    case 1:
                        product.HienThiSP();
                        break;
                    case 2:
                        p.input();
                        product.nhap(p);
                        break;
                    case 3:
                        p.input();
                        product.updateSP(p);
                        break;
                    case 4:
                        product.deleteSP();
                        break;
                    case 5:
                        product.CountDate();
                        break;
                    case 6:
                        product.SearchCatelogId();
                        break;
                    case 7:
                        product.SortNgayNhap();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-8!!!");
                }
            } catch (Exception e) {
                System.err.println("Vui lòng nhập từ 1-8!!!");
                s.nextLine();
            }
            
        }
    }
    public void nhap(Product p) {
        try {
            String sql = "INSERT INTO ProductLab7_1(CatelogId, ProductName, Content, "
                    + "ContentDetail, PriceInput, PriceOutput, "
                    + "Created, Views, BuyItem, Status )VALUES\n"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            Scanner s = new Scanner(System.in);
            ps.setInt(1, p.getCatelogId());
            ps.setNString(2, p.getProductName());
            ps.setNString(3, p.getContent());
            ps.setNString(4, p.getContentDetail());
            ps.setFloat(5, p.getPriceInput());
            ps.setFloat(6, p.getPriceOutput());
            ps.setDate(7, Date.valueOf(p.getCreated()));
            ps.setInt(8, p.getViews());
            ps.setInt(9, p.getBuyItem());
            ps.setBoolean(10, p.isStatus());
            
            int row = ps.executeUpdate();
            if (row > 0) {
                System.err.println("Thêm dữ liệu thành công!!!");
            } else {
                System.err.println("Lỗi, thêm thất bại!!!");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void HienThiSP() {
        try {
            Product p = new Product();
            String sql = "SELECT * FROM ProductLab7_1";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.println("                                                "
                            + "..........: Danh sách sản phẩm :..........");
            System.out.printf("%2s %10s %15s %10s %17s %15s %10s %10s %10s %10s %10s\n",
                    "ProductId", "CatelogId", "ProductName","Content","ContentDetail",
                    "PriceInput","PriceOutput","Created","Views","BuyItem","Status");
            while (rs.next()) {
                System.out.printf("%-10d %-13d %-14s %-11s %-18s %-10s %-14s %-13s %-8s %-10s %-12s\n",
                                rs.getInt("ProductId"),
                                rs.getInt("CatelogId"),
                                rs.getString("ProductName"),
                                rs.getString("Content"),
                                rs.getString("ContentDetail"),
                                rs.getFloat("PriceInput"),
                                rs.getFloat("PriceOutput"),
                                rs.getDate("Created"),
                                rs.getInt("Views"),
                                rs.getInt("BuyItem"),
                                rs.getString("Status")
                                );
            }
            System.out.println("------------------------------------------------"
                            + "-------------------------------------------------"
                            + "----------------------------------------");
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void updateSP(Product p) {
        try {
            System.out.printf("Nhập mã sản phẩm cần sửa: ");
            Scanner s = new Scanner(System.in);
            int code = s.nextInt();
            String sql = "UPDATE ProductLab7_1\n"
                    + "SET CatelogId = ?, \n"
                    + "ProductName = ?, \n"
                    + "Content = ?, \n"
                    + "ContentDetail = ?, \n"
                    + "PriceInput = ?, \n"
                    + "PriceOutput = ?, \n"
                    + "Created = ?, \n"
                    + "Views = ?, \n"
                    + "BuyItem = ?, \n"
                    + "Status = ? \n"
                    + "WHERE ProductId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getCatelogId());
            ps.setNString(2, p.getProductName());
            ps.setNString(3, p.getContent());
            ps.setNString(4, p.getContentDetail());
            ps.setFloat(5, p.getPriceInput());
            ps.setFloat(6, p.getPriceOutput());
            ps.setDate(7, Date.valueOf(p.getCreated()));
            ps.setInt(8, p.getViews());
            ps.setInt(9, p.getBuyItem());
            ps.setBoolean(10, p.isStatus());
            ps.setInt(11, code);
            
            int row = ps.executeUpdate();
            if (row > 0) {
                System.err.println("Cập nhật hàng thành công!!!");
            } else {
                System.err.println("Lỗi, cập nhật không thành công!!!");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void deleteSP() {
        try {
            String sql = "DELETE FROM ProductLab7_1 WHERE ProductId = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhập mã sản phẩm cần xóa: ");
            pst.setInt(1, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.err.println("Xóa dữ liệu thành công!!!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }    
    public void SearchCatelogId(){
        try {
            String sql = "SELECT * FROM ProductLab7_1 WHERE CatelogId LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            Scanner sc  = new Scanner(System.in);
            System.out.printf("Nhập mã danh mục cần tìm: ");
            int CatelogId = sc.nextInt();
            
            pst.setNString(1, "%"+ CatelogId+ "%");
            
            ResultSet rs = pst.executeQuery();
            System.out.println("                                         "
                            + "..........: Danh sách sản phẩm tìm theo danh mục :..........");
            System.out.printf("%2s %10s %15s %10s %17s %15s %10s %10s %10s %10s %10s\n",
                    "ProductId", "CatelogId", "ProductName","Content","ContentDetail",
                    "PriceInput","PriceOutput","Created","Views","BuyItem","Status");
            while (rs.next()) {
                System.out.printf("%-10d %-13d %-14s %-11s %-18s %-10s %-14s %-13s %-8s %-10s %-12s\n",
                                rs.getInt("ProductId"),
                                rs.getInt("CatelogId"),
                                rs.getString("ProductName"),
                                rs.getString("Content"),
                                rs.getString("ContentDetail"),
                                rs.getFloat("PriceInput"),
                                rs.getFloat("PriceOutput"),
                                rs.getDate("Created"),
                                rs.getInt("Views"),
                                rs.getInt("BuyItem"),
                                rs.getString("Status")
                                );
            }
            System.out.println("------------------------------------------------"
                            + "-------------------------------------------------"
                            + "-----------------------------------------");
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
    public void SortNgayNhap(){
        try {
            String sql = "SELECT * FROM ProductLab7_1 order by Created DESC";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.println("                                         "
                            + "..........: Danh sách sản phẩm giảm dần theo ngày nhập :..........");
            System.out.printf("%2s %10s %15s %10s %17s %15s %10s %10s %10s %10s %10s\n",
                    "ProductId", "CatelogId", "ProductName","Content","ContentDetail",
                    "PriceInput","PriceOutput","Created","Views","BuyItem","Status");
            while (rs.next()) {
                System.out.printf("%-10d %-13d %-14s %-11s %-18s %-10s %-14s %-13s %-8s %-10s %-12s\n",
                                rs.getInt("ProductId"),
                                rs.getInt("CatelogId"),
                                rs.getString("ProductName"),
                                rs.getString("Content"),
                                rs.getString("ContentDetail"),
                                rs.getFloat("PriceInput"),
                                rs.getFloat("PriceOutput"),
                                rs.getDate("Created"),
                                rs.getInt("Views"),
                                rs.getInt("BuyItem"),
                                rs.getString("Status")
                                );
            }
            System.out.println("------------------------------------------------"
                            + "-------------------------------------------------"
                            + "-----------------------------------------");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CountDate(){
        try {
            Scanner s = new Scanner(System.in);
            CallableStatement cs = Connect.getConnection().prepareCall("{call proc_product_count_date(?)}");
            System.out.printf("Nhập năm: ");
            int year = s.nextInt();
            cs.setInt(1, year);
            ResultSet rs = cs.executeQuery();
            System.out.println("Số sản phẩm: "+rs);
        } catch (SQLException e) {
            System.out.println("Lỗi: "+e.getMessage());
        }
    }
}
