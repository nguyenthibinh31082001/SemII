/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_03;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai1_XeMay {
    String ten;
    String nhaSanXuat;
    int soLuongBanhXe;

    public Bai1_XeMay() {
    }

    public Bai1_XeMay(String ten, String nhaSanXuat, int soLuongBanhXe) {
        this.ten = ten;
        this.nhaSanXuat = nhaSanXuat;
        this.soLuongBanhXe = soLuongBanhXe;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getSoLuongBanhXe() {
        return soLuongBanhXe;
    }

    public void setSoLuongBanhXe(int soLuongBanhXe) {
        this.soLuongBanhXe = soLuongBanhXe;
    }
        
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin xe:");
        System.out.printf("Nhập tên:");
        this.ten = sc.nextLine();
        System.out.printf("Nhập nhà sản xuất:");
        this.nhaSanXuat = sc.nextLine();
        System.out.printf("Nhập số lượng bánh xe:");
        this.soLuongBanhXe = sc.nextInt();
        System.out.println("Cảm ơn!");
        
    }
    public String display(){
        return "Bai1_XeMay{" + "ten=" + ten + ", nhaSanXuat=" + nhaSanXuat + ", soLuongBanhXe=" + soLuongBanhXe + '}';
    }   
    
}
