/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import session10.DbUtil;

/**
 *
 * @author ADMIN
 */
public class ManagerProduct {
    private Connection conn;
    
    public ManagerProduct() {
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối thành công!!!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();
        Product p = new Product();
        
        while (true) {
            System.out.println("\t.: MENU :.");
            System.out.println("1. Hiển thị danh sách sản phẩm ");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Sửa ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm sản phẩm theo id ");
            System.out.println("6. Tìm sản phẩm theo tên.  ");
            System.out.println("7. Thoát");

            System.out.printf("Mời chọn từ 1 -> 7: ");
            Scanner s = new Scanner(System.in);
            int choose = s.nextInt();

            switch (choose) {
                case 1:
                    managerProduct.getAll().forEach(o -> o.display());
                    break;
                case 2:
                    p.input();
                    managerProduct.Created(p);
                    break;
                case 3:
                    p.input();
                    managerProduct.Update(p);
                    break;
                case 4:
                    managerProduct.Delete(choose);
                    break;
                case 5:
                    managerProduct.getById(choose);
                    break;
                case 6:
                    managerProduct.searchByName();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-7!!!");
            }
        }
    }
    public List<Product> getAll(){
        List<Product> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_GetAll}");
            ResultSet rs = cs.executeQuery();
            System.out.println("                     .....:Danh sách sản phẩm:.....");
            System.out.printf("%2s %13s %10s %13s %23s %10s\n",
                    "Id", "ProductName", "Price","Producer","DateCreated","Status");
            while(rs.next()){
                lst.add(new Product(
                    rs.getInt("ProductId"), 
                    rs.getNString("ProductName"), 
                    rs.getFloat("Price"), 
                    rs.getNString("Producer"), 
                    rs.getDate("DateCreated").toLocalDate(), 
                    rs.getBoolean("Status")));
            }
            
        } catch (Exception e) {
            
        }
         
        return lst;
    }
    
    public void Created(Product p){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Insert(?,?,?,?,?,?)}");
            // Dang ky tham so dau vao
            cs.setNString(1, p.getProductName());
            cs.setFloat(2, p.getPrice());
            cs.setNString(3, p.getProducer());
            cs.setDate(4, Date.valueOf(p.getDateCreated()));
            cs.setBoolean(5, p.isStatus());
            // Dang ky tham so dau ra
            cs.registerOutParameter("Msg", java.sql.Types.NVARCHAR);
            cs.executeUpdate();
            String msg = cs.getNString("Msg");
            if(msg.isEmpty()){
                System.err.println("Thêm dữ liệu thành công!!!");
            }else{
                System.err.println(msg);
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    
    public void Update(Product p){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Update(?,?,?,?,?,?)}");
            Scanner s = new Scanner(System.in);
            // Dang ky tham so dau vao
            System.out.printf("Nhập mã sản phẩm cần sửa: ");
            int code = s.nextInt();
            cs.setInt(1, code);
            cs.setNString(2, p.getProductName());
            cs.setFloat(3, p.getPrice());
            cs.setNString(4, p.getProducer());
            cs.setDate(5, Date.valueOf(p.getDateCreated()));
            cs.setBoolean(6, p.isStatus());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Cập nhật hàng thành công!!!");
            }else {
                System.err.println("Lỗi, cập nhật không thành công!!!");
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    
    public void Delete(int ProductId){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Delete(?)}");
            // Dang ky tham so dau vao
            Scanner s = new Scanner(System.in);
            System.out.printf("Nhập mã sản phẩm cần xóa: ");
            cs.setInt(1, s.nextInt());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Xóa dữ liệu thành công!!!");
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    
    public Product getById(int ProductId){
        Product p = null;
        
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_GetById(?)}");
            Scanner s = new Scanner(System.in);
            System.out.printf("Nhập mã sản phẩm cần tìm: ");
            int id = s.nextInt();
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            System.out.println("                  .....:Danh sách sản phẩm tìm theo id:.....");
            System.out.printf("%2s %13s %10s %13s %23s %10s\n",
                    "Id", "ProductName", "Price","Producer","DateCreated","Status");
            while(rs.next()){
                p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getNString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setDateCreated(rs.getDate("DateCreated").toLocalDate());
                p.setProducer(rs.getNString("Producer"));
                p.setStatus(rs.getBoolean("Status"));
                p.display();
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        
        return p;
    }
    
    public List<Product> searchByName(){
        List<Product> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_SearchByName(?)}");
            System.out.printf("Nhập tên sản phẩm cần tìm: ");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            cs.setNString(1, name);
            ResultSet rs = cs.executeQuery();
            System.out.println("                 .....:Danh sách sản phẩm tìm theo tên:.....");
            System.out.printf("%2s %13s %10s %13s %23s %10s\n",
                    "Id", "ProductName", "Price","Producer","DateCreated","Status");
            while(rs.next()){
//                lst.add(new Product(
//                    rs.getInt("ProductId"), 
//                    rs.getNString("ProductName"), 
//                    rs.getFloat("Price"), 
//                    rs.getNString("Producer"), 
//                    rs.getDate("DateCreated").toLocalDate(), 
//                    rs.getBoolean("Status")));
                Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getNString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setDateCreated(rs.getDate("DateCreated").toLocalDate());
                p.setProducer(rs.getNString("Producer"));
                p.setStatus(rs.getBoolean("Status"));
                p.display();
               
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lst;
    }
}
