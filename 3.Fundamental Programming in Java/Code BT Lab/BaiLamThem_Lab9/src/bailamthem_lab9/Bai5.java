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
public class Bai5 {
    private String tenSach;
    private String tacGia;
    private int namXuatBan;

    public Bai5() {
    }

    public Bai5(String tenSach, String tacGia, int namXuatBan) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên sách: ");
        tenSach = input.nextLine();
        while(tenSach.length()>50){
            System.out.println("Tên không được vượt quá 50 ký tự!");
            System.out.printf("\tNhập tên sách: ");
            tenSach = input.nextLine();
        }
        System.out.printf("\tNhập tên tác giả: ");
        tacGia = input.nextLine();
        while(tacGia.length()>30){
            System.out.println("Tên tác giả không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập tên tác giả: ");
            tacGia = input.nextLine();
        }
        while (true) {
            try {
                System.out.printf("\tNhập năm xuất bản: ");
                namXuatBan = input.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
    } 
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(tenSach);
        buider.append("|\t|");
        buider.append(tacGia);
        buider.append("|\t|");
        buider.append(namXuatBan);
        
        System.out.print(buider.toString());
    }
    
}
