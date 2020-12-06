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
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 {
//    https://en.wikipedia.org/wiki/Country_codes:_R
    private Connection conn;
    ArrayList<GiaoDich> lstProduct = new ArrayList<>();
    ETranslator eTran;
    public Bai1(ETranslator et) {
        this.eTran = et;
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối thành công!!!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    private void nhap() {
        GiaoDich gd = new GiaoDich();
        gd.input();
        Bai1 bai1 = new Bai1(eTran);
        bai1.Created(gd);
    }
    private void hienthi() {
        Bai1 bai1 = new Bai1(eTran);
        bai1.Delete(0);
    }
    private void capNhat() {
        GiaoDich gd = new GiaoDich();
        gd.input();
        Bai1 bai1 = new Bai1(eTran);
        bai1.Update(gd);
    }
    private void xoa() {
        Bai1 bai1 = new Bai1(eTran);
        bai1.Delete(0);
    }
    private void doiNgonNgu() {
        System.out.println(eTran.getText(ELanguage.clanguage) + ":");
        System.out.println("1. English");
        System.out.println("2. Japanese");
        System.out.println("3. Tiếng Việt");
        Scanner s = new Scanner(System.in);
        System.out.printf("Mời chọn ngôn ngữ 1-3: ");
        int c = s.nextInt();
        switch (c) {
            case 1:
                eTran.setLocale(ELanguage.US);
                break;
            case 2:
                eTran.setLocale(ELanguage.JAPAN);
                break;
            case 3:
                eTran.setLocale(ELanguage.VIET_NAM);
                break;
        }
    }
    private int showMenu() {
        System.out.println("\t.: " + eTran.getText(ELanguage.menu) + " :.");
        System.out.println("1. " + eTran.getText(ELanguage.importc));
        System.out.println("2. " + eTran.getText(ELanguage.display));
        System.out.println("4. " + eTran.getText(ELanguage.update));
        System.out.println("3. " + eTran.getText(ELanguage.delete));
        System.out.println("3. " + eTran.getText(ELanguage.search));
        System.out.println("3. " + eTran.getText(ELanguage.transactiondate));
        System.out.println("5. " + eTran.getText(ELanguage.change));
        System.out.println("6. " + eTran.getText(ELanguage.exit));
        System.out.println(eTran.getText(ELanguage.plzchoose));
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    public static void main(String[] args) {
        
//        while (true) {
//            System.out.println("\t.: Mục lục :.");
//            System.out.println("1. Nhập giao dịch");
//            System.out.println("2. Danh sách giao dịch");
//            System.out.println("3. Sửa giao dịch");
//            System.out.println("4. Xóa giao dịch");
//            System.out.println("5. Tìm kiếm giao dịch ");
//            System.out.println("6. Giao dịch trong ngày ");
//            System.out.println("7. Đổi ngôn ngữ ");
//            System.out.println("8. Thoát");
//
//            Scanner s = new Scanner(System.in);
//            try {
//                System.out.printf("Mời chọn từ 1 -> 8: ");
//                int choose = s.nextInt();
//                
//                switch (choose) {
//                    case 1:
//                        
//                        
//                        break;
//                    case 2:
//                        bai1.getAll().forEach(o -> o.output());
//                        break;
//                    case 3:
//                        gd.input();
//                        bai1.Update(gd);
//                        break;
//                    case 4:
//                        bai1.Delete(choose);
//                        break;
//                    case 5:
//                        bai1.searchByName();
//                        break;
//                    case 6:
//                        
//                        break;
//                    case 7:
//                        
//                        break;
//                    case 8:
//                        System.exit(0);
//                        break;
//                    default:
//                        System.err.println("Vui lòng nhập từ 1-8!!!");
//                }
//            } catch (Exception e) {
//                System.err.println("Vui lòng nhập từ 1-8!!!");
//                s.nextLine();
//            }
//            
//        }
    }
    public List<GiaoDich> getAll(){
        List<GiaoDich> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_giaodich_GetAll}");
            ResultSet rs = cs.executeQuery();
            System.out.println("                     .....:Danh sách giao dịch:.....");
            System.out.printf("%2s %10s %14s %13s %23s %13s\n",
                    "Ma", "Ten", "Loai","Gio","Ngay","Mo Ta");
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
                    "Ma", "Ten", "Loai","Gio","Ngay","Mo Ta");
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
