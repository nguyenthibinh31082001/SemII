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
public class BTTH2 {
    private String maSP;
    private String tenSP;
    private String nhaSX;
    private int namSX;
    private float giaBan;

    public BTTH2() {
    }

    public BTTH2(String maSP, String tenSP, String nhaSX, int namSX, float giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhaSX = nhaSX;
        this.namSX = namSX;
        this.giaBan = giaBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập mã sản phẩm:");
        maSP = sc.nextLine();
        System.out.printf("Nhập tên sản phẩm:");
        tenSP = sc.nextLine();
        System.out.printf("Nhập tên nhà sản xuất:");
        nhaSX = sc.nextLine();
        System.out.printf("Nhập năm sản xuất:");
        namSX = Integer.parseInt(sc.nextLine());
        System.out.printf("Nhập giá bán:");
        giaBan = Float.parseFloat(sc.nextLine());
    }
    
    public void display(){
        System.out.println("Sản phẩm:");
        System.out.println("\tMã sản phẩm:"+maSP);
        System.out.println("\tTên sản phẩm:"+tenSP);
        System.out.println("\tNhà sản xuất:"+nhaSX);
        System.out.println("\tNăm sản xuất:"+namSX);
        System.out.println("\tGiá bán:"+giaBan);
    }
}
