/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class City implements Comparable<City>{
    private String ten;//- tên tỉnh (tối đa 30 ký tự), 
    private float dienTich;//- diện tích (kiểu số thực), 
    private long danSo;//- dân số (số nguyên dài). 

    public City() {
    }

    public City(String ten, float dienTich, long danSo) {
        this.ten = ten;
        this.dienTich = dienTich;
        this.danSo = danSo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public long getDanSo() {
        return danSo;
    }

    public void setDanSo(long danSo) {
        this.danSo = danSo;
    }
    
    String regExpTen = "^[a-zA-Z0-9 ]{1,30}$";

    public void input() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\tNhập tên tỉnh:");
            this.ten = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpTen);
            Matcher matcher = pattern.matcher(ten);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tTên tỉnh chỉ tối đa 30 ký tự!");
            }
        } while (true);
        while (true) {
            try {
                System.out.printf("\tNhập diện tích tỉnh: ");
                this.dienTich = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập dân số tỉnh: ");
                this.danSo = sc.nextLong();
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số nguyên dài!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format("%2s",this.ten));
        builder.append("|\t");
        builder.append(String.format("%10s", this.dienTich));
        builder.append("|\t");
        builder.append(String.format("%8s",this.danSo));
        builder.append("|\t");
        
        System.out.print(builder.toString());
        return super.toString();
//        return "ten=" + ten + ", dienTich=" + dienTich + ", danSo=" + danSo + ", regExpTen=" + regExpTen;
    }

    @Override
    public int compareTo(City o) {
        return (int) getDienTich();
    }
    
}
