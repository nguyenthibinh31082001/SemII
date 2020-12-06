/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shoes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ShoesManager {
    private Connection conn;
    ArrayList<Shoes> lstShoes = new ArrayList<>();
    public ShoesManager() {
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối thành công!!!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    public static void main(String[] args) {
        ShoesManager manager = new ShoesManager();
        
        
        while (true) {
            System.out.println("\t.: MENU :.");
            System.out.println("1. Thêm giầy mới");
            System.out.println("2. Hiển thị tất cả");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm giầy");
            System.out.println("6. Ghi dữ liệu ra file");
            System.out.println("7. Import dữ liệu");
            System.out.println("8. Thoát");

            Scanner s = new Scanner(System.in);
            try {
                System.out.printf("Mời chọn từ 1 -> 8: ");
                int choose = s.nextInt();
                switch (choose) {
                    case 1:
                        manager.create();
                        break;
                    case 2:
                        manager.getAllShoes();
                        break;
                    case 3:
                        Shoes sh = new Shoes();
                        sh.input();
                        manager.Update(sh);
                        break;
                    case 4:
                        manager.Delete(choose);
                        break;
                    case 5:
                        manager.getShoesByName();
                        break;
                    case 6:
                        manager.writeData();
//                        manager.readFile();
                        break;
                    case 7:
                        manager.importData();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-8!!!");
                }
//                break;
            } catch (Exception e) {
                System.err.println("Vui lòng nhập từ 1-8!!!");
                  s.nextLine();
            }
        }
    }
    public void getAllShoes() {
        lstShoes.removeAll(lstShoes);
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllShoes}");
            ResultSet rs = cs.executeQuery();
            System.out.println("                    .....:Danh sách giày:.....");
            System.out.printf("%2s %8s %20s %14s %25s\n",
                    "Id", "Name", "Price","Year","Description");
            while (rs.next()) {
                Shoes s = new Shoes(
                        rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getFloat("price"),
                        rs.getInt("year"), 
                        rs.getString("description"));
                lstShoes.add(s);
                s.output();
            }
            if (lstShoes.size() == 0) {
                System.err.println("KHÔNG TÌM THẤY DỮ LIỆU");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void getShoesByName() {
        lstShoes.removeAll(lstShoes);
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getShoesByName(?)}");
            System.out.printf("Nhập tên sản phẩm cần tìm: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            System.out.println("                  .....:Danh sách giày " +name+ " tìm thấy:.....");
            System.out.printf("%2s %8s %20s %14s %25s\n",
                    "Id", "Name", "Price","Year","Description");
            while (rs.next()) {
                Shoes s = new Shoes(
                        rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getFloat("price"),
                        rs.getInt("year"), 
                        rs.getString("description"));
                lstShoes.add(s);
                s.output();
            }
            if (lstShoes.size() == 0) {
                System.err.println("KHÔNG TÌM THẤY DỮ LIỆU");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void create() {
        try {
            Shoes s = new Shoes();
            s.input();
            CallableStatement cs = conn.prepareCall("{CALL proc_addShoes(?,?,?,?,?)}");
            cs.setString(1, s.getName());
            cs.setFloat(2, s.getPrice());
            cs.setInt(3, s.getYear());
            cs.setString(4, s.getDescription());
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.executeUpdate();
            
            String result = cs.getString(5);
            System.err.println("Thêm dữ liệu thành công!!!" + result);
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void Update(Shoes shoes){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_Update(?,?,?,?,?)}");
            Scanner s = new Scanner(System.in);
            // Dang ky tham so dau vao
            System.out.printf("Nhập mã giày cần sửa: ");
            int code = s.nextInt();
            cs.setInt(1, code);
            cs.setNString(2, shoes.getName());
            cs.setFloat(3, shoes.getPrice());
            cs.setInt(4, shoes.getYear());
            cs.setNString(5, shoes.getDescription());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Cập nhật thành công!!!");
            }else {
                System.err.println("Lỗi, cập nhật không thành công!!!");
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    public void Delete(int id){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_Delete(?)}");
            Scanner s = new Scanner(System.in);
            System.out.printf("Nhập mã giày cần xóa: ");
            cs.setInt(1, s.nextInt());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Xóa dữ liệu thành công!!!");
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    public void importShoes(Shoes s) {
        try {
            String sql = "{CALL proc_addShoes(?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, s.getName());
            cs.setFloat(2, s.getPrice());
            cs.setInt(3, s.getYear());
            cs.setString(4, s.getDescription());
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.executeUpdate();
            
            String result = cs.getString(5);
            System.out.println("Thêm dữ liệu: " + result);
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    private void writeData() {
        FileOutputStream fos = null;
        try {
            String filePath = "shoes.txt";
            fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ShoesManager sm = new ShoesManager();
            sm.getAllShoes(); 
            oos.writeObject(sm.lstShoes);
            oos.flush();
            oos.close();
            fos.close();
            System.err.println("Ghi dữ liệu thành công!!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void readFile(){
        List<Shoes> lst = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("shoes.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                
                ){
            String str;
            while( (str= br.readLine()) !=null){
                String fileds[] = str.split(",");
                Shoes c = new Shoes();
                    c.setName(fileds[0].split("=")[1]);
                    c.setPrice(Float.parseFloat(fileds[1].split("=")[1]));
                    c.setYear(Integer.parseInt(fileds[2].split("=")[1]));
                    c.setDescription(fileds[3].split("=")[1]);
                lst.add(c);
            }
            System.err.println("Dữ liệu đọc từ file shoes.db là: ");
            lst.forEach(o -> System.out.println(o.toString()));
            System.out.println("");
            
        } catch (Exception e) {
        }
    }
    private void importData() {
        FileInputStream fis = null;
        try {
            String filePath = "data.txt";
            fis = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
            String row[] = line.split(",");
            Shoes s = new Shoes(
                    row[0], 
                    Float.parseFloat(row[1]),
                    Integer.parseInt(row[2]), 
                    row[3]);
            ShoesManager sm = new ShoesManager();
            sm.importShoes(s);
            }
            System.err.println("Import dữ liệu thành công!!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
