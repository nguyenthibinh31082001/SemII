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
public class Bai1 {
    String HoTen;
    int NamSinh;
    float Luong;
    int GioiTinh;

    public Bai1() {
    }

    public Bai1(String HoTen, int NamSinh, float Luong, int GioiTinh) {
        this.HoTen = HoTen;
        this.NamSinh = NamSinh;
        this.Luong = Luong;
        this.GioiTinh = GioiTinh;
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

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
        
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên nhân viên: ");
        HoTen = input.nextLine();
        while(HoTen.length()>30){
            System.out.println("Họ tên không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập tên nhân viên: ");
            HoTen = input.nextLine();
        }
        while (true) {
            try {
                System.out.printf("\tNhập năm sinh: ");
                NamSinh = input.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập lương: ");
                Luong = input.nextFloat(); 
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số thực:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        } 
        System.out.printf("\tNhập giới tính(0. Nữ, 1.Nam): ");
        GioiTinh = input.nextInt(); 
        while((GioiTinh != 0) && (GioiTinh != 1)){
            System.out.println("Nữ nhập (0), Nam nhập (1)!");
            System.out.printf("\tNhập giới tính(0. Nữ, 1.Nam): ");
            GioiTinh = input.nextInt();
        }
    } 
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(HoTen);
        buider.append("|\t|");
        buider.append(NamSinh);
        buider.append("|\t|");
        buider.append(Luong);
        buider.append("|\t|");
        buider.append(GioiTinh);
        
        System.out.print(buider.toString());
    }
}
