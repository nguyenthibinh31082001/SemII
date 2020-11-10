/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthem_lab9;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai2 {
    String HoTen;
    float Toan;
    float Van;
    float TrungBinh;

    public Bai2() {
    }

    public Bai2(String HoTen, float Toan, float Van, float TrungBinh) {
        this.HoTen = HoTen;
        this.Toan = Toan;
        this.Van = Van;
        this.TrungBinh = TrungBinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public float getToan() {
        return Toan;
    }

    public void setToan(float Toan) {
        this.Toan = Toan;
    }

    public float getVan() {
        return Van;
    }

    public void setVan(float Van) {
        this.Van = Van;
    }

    public float getTrungBinh() {
        TrungBinh = (Van+Toan)/2;
        return TrungBinh;
    }

    public void setTrungBinh(float TrungBinh) {
        this.TrungBinh = TrungBinh;
    }
    
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên học sinh: ");
        HoTen = input.nextLine();
        while(HoTen.length()>30){
            System.out.println("Họ tên không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập tên nhân viên: ");
            HoTen = input.nextLine();
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm toán: ");
                Toan = input.nextFloat();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm văn: ");
                Van = input.nextFloat(); 
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
//        System.out.printf("\tNhập điểm toán: ");
//        Toan = input.nextFloat();
//        System.out.printf("\tNhập điểm văn: ");
//        Van = input.nextFloat(); 
    } 
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(HoTen);
        buider.append("|\t|");
        buider.append(Toan);
        buider.append("|\t|");
        buider.append(Van);
        buider.append("|\t|");
        buider.append(getTrungBinh());
        
        System.out.print(buider.toString());
    }
}
