/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1_Lab4 {
    private String maHĐ;
    private String ngaylapHĐ;
    private String tenKH;
    private String diachiKH;
    private int SoLuong;
    private float GiaBan;
    private float TongTienHang;
    private float TienKM;
    private float TongTienTT;

    public Bai1_Lab4() {
    }

    public Bai1_Lab4(String maHĐ, String ngaylapHĐ, String tenKH, String diachiKH, int SoLuong, float GiaBan, float TongTienHang, float TienKM, float TongTienTT) {
        this.maHĐ = maHĐ;
        this.ngaylapHĐ = ngaylapHĐ;
        this.tenKH = tenKH;
        this.diachiKH = diachiKH;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.TongTienHang = TongTienHang;
        this.TienKM = TienKM;
        this.TongTienTT = TongTienTT;
    }

    public String getMaHĐ() {
        return maHĐ;
    }

    public void setMaHĐ(String maHĐ) {
        this.maHĐ = maHĐ;
    }

    public String getNgaylapHĐ() {
        return ngaylapHĐ;
    }

    public void setNgaylapHĐ(String ngaylapHĐ) {
        this.ngaylapHĐ = ngaylapHĐ;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiachiKH() {
        return diachiKH;
    }

    public void setDiachiKH(String diachiKH) {
        this.diachiKH = diachiKH;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public float getTongTienHang() {
        return TongTienHang;
    }

    public void setTongTienHang(float TongTienHang) {
        this.TongTienHang = TongTienHang;
    }

    public float getTienKM() {
        return TienKM;
        
    }

    public void setTienKM(float TienKM) {
//        if(SoLuong >= 10){
//            this.TienKM = (GiaBan / 100) * 10;
//        }else if(SoLuong >= 100){
//            this.TienKM = (TongTienHang / 100) * 20; 
//        }else{
//            this.TienKM = 0;
//        }
        this.TienKM = TienKM;
    }

    public float getTongTienTT() {
        return TongTienTT;
    }

    public void setTongTienTT(float TongTienTT) {
        this.TongTienTT = TongTienTT;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập mã hóa đơn:");
        maHĐ = sc.nextLine();
        System.out.printf("Nhập ngày lập hóa đơn:");
        ngaylapHĐ = sc.nextLine();
        System.out.printf("Nhập tên khách hàng:");
        tenKH = sc.nextLine();
        System.out.printf("Nhập địa chỉ giao hàng:");
        diachiKH = sc.nextLine();
        System.out.printf("Nhập số lượng hàng:");
        SoLuong = sc.nextInt();
        System.out.printf("Nhập giá 1 chiếc bánh:");
        GiaBan = sc.nextFloat();
        
    }
    
    public void display(){
        TongTienHang = GiaBan * SoLuong;
        if(SoLuong >= 10 && SoLuong < 100){
            this.TienKM = ((GiaBan / 100) * 10) * SoLuong;
        }else if(SoLuong >= 100){
            this.TienKM = (TongTienHang / 100) * 20; 
        }else{
            this.TienKM = 0;
        }
        TongTienTT = TongTienHang - TienKM;
        System.out.println("Hóa đơn bánh mỳ:");
        System.out.println("\tMã hóa đơn:"+maHĐ);
        System.out.println("\tNgày lập hóa đơn:"+ngaylapHĐ);
        System.out.println("\tTên khách hàng:"+tenKH);
        System.out.println("\tĐịa chỉ giao hàng:"+diachiKH);
        System.out.println("\tSố lượng:"+SoLuong);
        System.out.println("\tGiá 1 chiếc bánh:"+GiaBan);
        System.out.println("\tTổng tiền hàng:"+TongTienHang);
        System.out.println("\tTiền khuyến mãi:"+TienKM);
        System.out.println("\tTổng tiền phải thanh toán:"+TongTienTT);
    }
}
