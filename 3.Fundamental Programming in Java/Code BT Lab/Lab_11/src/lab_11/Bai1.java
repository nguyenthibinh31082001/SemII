/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 implements Comparable<Bai1>{

    private String hoTen;//họ tên (30 ký tự),
    private LocalDate ngaySinh;//ngày sinh (kiểu ngày),
    private float luong;//lương (số thực),
    private int gioiTinh;//giới tính (0. Nữ, 1. Nam).
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
//    public void input(){
//        
//        Scanner sc = new Scanner(System.in);
//        Bai1 nv = new Bai1();
//        System.out.printf("\tNhập tên nhân viên: ");
//        nv.setHoTen(sc.nextLine());
//        while(nv.getHoTen().length()>30){
//            System.err.println("\tHọ tên không được vượt quá 30 ký tự!");
//            System.out.printf("\tNhập tên nhân viên: ");
//            nv.setHoTen(sc.nextLine());
//        }
//        System.out.printf("\tNhập ngày sinh: ");
//        nv.setNgaySinh(string2LocalDate(sc));
//        while (true) {
//            try {
//                System.out.printf("\tNhập lương: "); 
//                nv.setLuong(sc.nextFloat());
//                break;
//            } catch (Exception ex) {
//                System.err.println("\tYêu cầu nhập số thực:");
//                System.out.println(""+ex.getLocalizedMessage());
//                  sc.nextLine();
//            }
//        } 
//        System.out.printf("\tNhập giới tính(0. Nữ, 1.Nam): ");
//        nv.setGioiTinh(sc.nextInt());
//        while((nv.getGioiTinh() != 0) && (nv.getGioiTinh() != 1)){
//            System.err.println("\tNữ nhập (0), Nam nhập (1)!");
//            System.out.printf("\tNhập giới tính(0. Nữ, 1.Nam): ");
//            nv.setGioiTinh(sc.nextInt());
//        }
////        lstnhanvien.add(nv);
//    }
//    public LocalDate string2LocalDate(Scanner sc){
//        LocalDate ld = null;
//        try{
////            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
//        }catch(DateTimeParseException e){
////            e.printStackTrace();
//               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        
//        return ld;
//    }
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(hoTen);
        buider.append("|\t|");
        buider.append(ngaySinh);
        buider.append("|\t|");
        buider.append(luong);
        buider.append("|\t|");
        buider.append(this.gioiTinh == 0 ? "Nữ" : "Nam");
        
        System.out.print(buider.toString());
    }
    
    @Override
    public String toString() {
        System.out.println("Danh sách nhân viên: ");
        System.out.println("\tHọ tên: "+hoTen);
        System.out.println("\tNgày sinh: "+ngaySinh);
        System.out.println("\tLương: "+luong);
        System.out.println("\tGiới tính: "+gioiTinh);
        return "Bai1{" + "hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", luong=" + luong + ", gioiTinh=" + gioiTinh + '}';
        
    }

    @Override
    public int compareTo(Bai1 o) {
        return this.ngaySinh.getYear()-o.ngaySinh.getYear();
    }
}
