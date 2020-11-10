/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai3_Lab4 {
    String ten;
    String nhaSanXuat;
    int soLuongBanhXe;

    public Bai3_Lab4() {
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
        System.out.printf("Nhập tên:");
        ten = sc.nextLine();
        System.out.printf("Nhập nhà sản xuất:");
        nhaSanXuat = sc.nextLine();
        System.out.printf("Nhập số lượng bánh xe:");
        soLuongBanhXe = sc.nextInt();
        
    }
    public void display(){
        System.out.println("Xe Máy:");
        System.out.println("\tTên:"+ten);
        System.out.println("\tNhà sản xuất:"+nhaSanXuat);
        System.out.println("\tSố lượng bánh xe:"+soLuongBanhXe);
    }
}
