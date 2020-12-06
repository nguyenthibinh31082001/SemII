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

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh Tuan
 */
public class ProductManagement {

    public List<Product> getAll(){
        List<Product> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = DbUtil.getConnection().prepareCall("{CALL proc_product_GetAll}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                lst.add(new Product(rs.getInt("ProductId"), rs.getNString("ProductName"), rs.getFloat("Price"), rs.getNString("Producer"), rs.getDate("DateCreated").toLocalDate(), rs.getBoolean("Status")));
            }
            
        } catch (Exception e) {
        }
         
        return lst;
    }
    
    public Product getById(int ProductId){
        Product p = null;
        
        try {
            CallableStatement cs = DbUtil.getConnection().prepareCall("{CALL proc_product_GetById(?)}");
            cs.setInt(1, ProductId);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getNString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setProducer(rs.getNString("Producer"));
                p.setStatus(rs.getBoolean("Status"));
            }
            
        } catch (Exception e) {
        }
        
        return p;
    }
    
    public List<Product> searchByName(String name){
        List<Product> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = DbUtil.getConnection().prepareCall("{CALL proc_product_SearchByName(?)}");
            cs.setNString(1, name);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                lst.add(new Product(rs.getInt("ProductId"), rs.getNString("ProductName"), rs.getFloat("Price"), rs.getNString("Producer"), rs.getDate("DateCreated").toLocalDate(), rs.getBoolean("Status")));
            }
            
        } catch (Exception e) {
        }
         
        return lst;
    }
    
    public void Created(Product p){
        try {
            CallableStatement cs = DbUtil.getConnection().prepareCall("{CALL proc_product_Insert(?,?,?,?,?,?)}");
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
                System.out.println("Them thanh cong");
            }else{
                System.out.println(msg);
            }
            
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
    }
    
    
    public void Update(Product p){
        try {
            CallableStatement cs = DbUtil.getConnection().prepareCall("{CALL proc_product_Update(?,?,?,?,?,?)}");
            // Dang ky tham so dau vao
            cs.setInt(1, p.getProductId());
            cs.setNString(2, p.getProductName());
            cs.setFloat(3, p.getPrice());
            cs.setNString(4, p.getProducer());
            cs.setDate(5, Date.valueOf(p.getDateCreated()));
            cs.setBoolean(6, p.isStatus());
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.out.println("Sua thanh cong");
            }
            
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
    }
    
    public void Delete(int ProductId){
        try {
            CallableStatement cs = DbUtil.getConnection().prepareCall("{CALL proc_product_Delete(?)}");
            // Dang ky tham so dau vao
            cs.setInt(1, ProductId);
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.out.println("Xoa thanh cong");
            }
            
        } catch (Exception e) {
            System.out.println("Loi  " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        System.out.println("Danh sach san pham");
        productManagement.getAll().forEach(o -> o.display());
        
        Product p = new Product(0, "VIN ARIS", 5700, "VIN", LocalDate.now(), true);
//        productManagement.Created(p);

        p.setPrice(4700);
        p.setProductId(8);
        productManagement.Update(p);
        
    }
}
