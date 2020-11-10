/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthem_lab9;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai3 {
    String NhanHieu;
    float TrongLuong;
    Date HSD;

    public Bai3() {
    }

    public Bai3(String NhanHieu, float TrongLuong, Date HSD) {
        this.NhanHieu = NhanHieu;
        this.TrongLuong = TrongLuong;
        this.HSD = HSD;
    }

    public String getNhanHieu() {
        return NhanHieu;
    }

    public void setNhanHieu(String NhanHieu) {
        this.NhanHieu = NhanHieu;
    }

    public float getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(float TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }
    
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập nhãn hiệu: ");
        NhanHieu = input.nextLine();
        System.out.printf("\tNhập trọng lượng: ");
        TrongLuong = input.nextFloat();
        System.out.printf("\tNhập hạn sử dụng: ");
//        HSD = input.nextDay(); 
    } 
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(NhanHieu);
        buider.append("|\t|");
        buider.append(TrongLuong);
        buider.append("|\t|");
        buider.append(HSD);
        
        System.out.print(buider.toString());
    }
}
