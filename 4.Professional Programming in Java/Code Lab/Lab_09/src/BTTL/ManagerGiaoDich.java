/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ManagerGiaoDich {
    private Connection conn;
    ArrayList<GiaoDich> lstProduct = new ArrayList<>();
    ETranslator eTran;
    public ManagerGiaoDich(ETranslator et) {
        this.eTran = et;
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối thành công!!!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    
    public List<GiaoDich> getAll(){
        List<GiaoDich> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_giaodich_GetAll}");
            ResultSet rs = cs.executeQuery();
            System.out.println("                     .....:Danh sách giao dịch:.....");
//            System.out.printf("%2s %10s %14s %13s %23s %13s\n",
//                    "Ma", "Ten", "Loai","Gio","Ngay","Mo Ta");
            System.out.printf("%2s %10s %14s %13s %23s %13s\n",
                eTran.getText(ELanguage.ma), 
                eTran.getText(ELanguage.ten),
                eTran.getText(ELanguage.loai),
                eTran.getText(ELanguage.gio), 
                eTran.getText(ELanguage.ngay),
                eTran.getText(ELanguage.mota));
            while(rs.next()){
                lst.add(new GiaoDich(
                    rs.getInt("MaDg"), 
                    rs.getNString("TenDg"), 
                    rs.getNString("LoaiDg"), 
                    rs.getTime("GioDg").toLocalTime(), 
                    rs.getDate("NgayDg").toLocalDate(), 
                    rs.getNString("MoTa")));
            }
            
        } catch (Exception e) {
            
        }
         
        return lst;
    }
    public void Created(GiaoDich gd){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_giaodich_Insert(?,?,?,?,?,?)}");
            // Dang ky tham so dau vao
            cs.setNString(1, gd.getTenDg());
            cs.setNString(2, gd.getLoaiDg());
            cs.setTime(3, Time.valueOf(gd.getGioDg()));
            cs.setDate(4, Date.valueOf(gd.getNgayDg()));
            cs.setNString(5, gd.getMoTa());
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
    public void Update(GiaoDich gd){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_giaodich_Update(?,?,?,?,?,?)}");
            Scanner s = new Scanner(System.in);
            // Dang ky tham so dau vao
            System.out.printf("Nhập mã giao dịch cần sửa: ");
            int code = s.nextInt();
            cs.setInt(1, code);
            cs.setNString(2, gd.getTenDg());
            cs.setNString(3, gd.getLoaiDg());
            cs.setTime(4, Time.valueOf(gd.getGioDg()));
            cs.setDate(5, Date.valueOf(gd.getNgayDg()));
            cs.setNString(6, gd.getMoTa());
            
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
    public void Delete(int MaDg){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_giaodich_Delete(?)}");
            // Dang ky tham so dau vao
            Scanner s = new Scanner(System.in);
            System.out.printf("Nhập mã giao dịch cần xóa: ");
            cs.setInt(1, s.nextInt());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Xóa dữ liệu thành công!!!");
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    public List<GiaoDich> searchByName(){
        List<GiaoDich> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_giaodich_SearchByName(?)}");
            System.out.printf("Nhập tên giao dịch cần tìm: ");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            cs.setNString(1, name);
            ResultSet rs = cs.executeQuery();
            System.out.println("                 .....:Danh sách giao dịch tìm theo tên:.....");
            System.out.printf("%2s %10s %14s %13s %23s %13s\n",
                        eTran.getText(ELanguage.ma), 
                        eTran.getText(ELanguage.ten),
                        eTran.getText(ELanguage.loai),
                        eTran.getText(ELanguage.gio), 
                        eTran.getText(ELanguage.ngay),
                        eTran.getText(ELanguage.mota));
            while(rs.next()){
                GiaoDich gd = new GiaoDich();
                gd.setMaDg(rs.getInt("MaDg"));
                gd.setTenDg(rs.getNString("TenDg"));
                gd.setLoaiDg(rs.getNString("LoaiDg"));
                gd.setGioDg(rs.getTime("GioDg").toLocalTime());
                gd.setNgayDg(rs.getDate("NgayDg").toLocalDate());
                gd.setMoTa(rs.getNString("MoTa"));
                gd.output();
               
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lst;
    }
//    public void GiaoDichDate(){
//        try {
//            Scanner s = new Scanner(System.in);
//            CallableStatement cs = Connect.getConnection().prepareCall("{call proc_product_count_date(?)}");
//            System.out.printf("Nhập năm: ");
//            int year = s.nextInt();
//            cs.setInt(1, year);
//            ResultSet rs = cs.executeQuery();
//            System.out.println("Số sản phẩm: "+rs);
//        } catch (SQLException e) {
//            System.out.println("Lỗi: "+e.getMessage());
//        }
//    }
}
