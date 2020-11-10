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
public class Bai4 {
    private String maPhong;
    private String tenPhong;
    float donGia;
    private int soLuong;
    private int tinhTrang;

    public Bai4() {
    }

    public Bai4(String maPhong, String tenPhong, float donGia, int soLuong, int tinhTrang) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã phòng: ");
        maPhong = input.nextLine();
        while(maPhong.length()>5){
            System.out.println("Mã phòng không được vượt quá 5 ký tự!");
            System.out.printf("\tNhập mã phòng: ");
            maPhong = input.nextLine();
        }
        System.out.printf("\tNhập tên phòng: ");
        tenPhong = input.nextLine();
        while(tenPhong.length()>30){
            System.out.println("Tên phòng không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập tên phòng: ");
            tenPhong = input.nextLine();
        }
        while (true) {
            try {
                System.out.printf("\tNhập đơn giá thuê: ");
                donGia = input.nextFloat();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số thực:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập số lượng giường: ");
                soLuong = input.nextInt(); 
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            } 
        }
        System.out.printf("\tNhập tình trạng phòng(0. Rảnh, 1.Bận): ");
        tinhTrang = input.nextInt(); 
        while((tinhTrang != 0) && (tinhTrang != 1)){
            System.out.println("Rảnh nhập (0), Bận nhập (1)!");
            System.out.printf("\tNhập tình trạng phòng(0. Rảnh, 1.Bận): ");
            tinhTrang = input.nextInt();
        }
    } 
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(maPhong);
        buider.append("|\t|");
        buider.append(tenPhong);
        buider.append("|\t|");
        buider.append(donGia);
        buider.append("|\t|");
        buider.append(soLuong);
        buider.append("|\t|");
        buider.append(tinhTrang);
        
        System.out.print(buider.toString());
    }
}
