/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private int MaNV; // Mã nv
    private String HoTen; // Tên nv
    private int NamSinh; // năm sinh
    private String PhongBan; // phòng ban
    private String Email; // email

    public NhanVien() {
    }

    public NhanVien(int MaNV, String HoTen, int NamSinh, String PhongBan, String Email) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NamSinh = NamSinh;
        this.PhongBan = PhongBan;
        this.Email = Email;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String PhongBan) {
        this.PhongBan = PhongBan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
//        System.out.printf("\tNhập mã nhân viên: ");
//        this.MaNV = s.nextInt();
        System.out.printf("\tNhập tên nhân viên: ");
        this.HoTen = s.nextLine();
        System.out.printf("\tNhập năm sinh: ");
        this.NamSinh = s.nextInt();
        s.nextLine(); // clear
        System.out.printf("\tNhập phòng ban: ");
        this.PhongBan = s.nextLine();
        System.out.printf("\tNhập email: ");
        this.Email = s.nextLine();
    }
    
    public void display() {
        System.out.printf("%d %13s %15d %15s %20s\n",
        this.MaNV, this.HoTen, this.NamSinh, this.PhongBan, this.Email);
    }
}
