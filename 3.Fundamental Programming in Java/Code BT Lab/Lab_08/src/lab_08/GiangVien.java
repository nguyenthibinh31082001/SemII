/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_08;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class GiangVien {
    private String TenGiangVien; 
    private String DiaChi; 
    private String SĐT; 
    private float GioDay; 

    public GiangVien() {
    }

    public GiangVien(String TenGiangVien, String DiaChi, String SĐT, float GioDay) {
        this.TenGiangVien = TenGiangVien;
        this.DiaChi = DiaChi;
        this.SĐT = SĐT;
        this.GioDay = GioDay;
    }

    public String getTenGiangVien() {
        return TenGiangVien;
    }

    public void setTenGiangVien(String TenGiangVien) {
        this.TenGiangVien = TenGiangVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSĐT() {
        return SĐT;
    }

    public void setSĐT(String SĐT) {
        this.SĐT = SĐT;
    }

    public float getGioDay() {
        return GioDay;
    }

    public void setGioDay(float GioDay) {
        this.GioDay = GioDay;
    }

        
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên giảng viên:");
        TenGiangVien = input.nextLine();
        System.out.printf("\tNhập địa chỉ:");
        DiaChi = input.nextLine();
        System.out.printf("\tNhập số điện thoại:");
        SĐT = input.nextLine();
        System.out.printf("\tNhập số giờ dạy:");
        GioDay = input.nextFloat();
    }
//    public void display(){
//        System.out.println("\tTên giảng viên: "+TenGiangVien);
//        System.out.println("\tĐịa chỉ: "+DiaChi);
//        System.out.println("\tSố điện thoại: "+SĐT);
//        System.out.println("\tSố giờ dạy: "+GioDay);
//    }
    public void display(){
        StringBuilder buider = new StringBuilder();
        buider.append("|");
        buider.append(TenGiangVien);
        buider.append("|\t|");
        buider.append(DiaChi);
        buider.append("|\t|");
        buider.append(SĐT);
        buider.append("|\t|");
        buider.append(GioDay);
        
        System.out.print(buider.toString());
    }
}
