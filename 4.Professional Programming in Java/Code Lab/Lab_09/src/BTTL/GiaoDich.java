/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class GiaoDich {
    private int MaDg;
    private String TenDg;
    private String LoaiDg;
    private LocalTime GioDg;
    private LocalDate NgayDg;
    private String MoTa;

    public GiaoDich() {
    }

    public GiaoDich(int MaDg, String TenDg, String LoaiDg, LocalTime GioDg, LocalDate NgayDg, String MoTa) {
        this.MaDg = MaDg;
        this.TenDg = TenDg;
        this.LoaiDg = LoaiDg;
        this.GioDg = GioDg;
        this.NgayDg = NgayDg;
        this.MoTa = MoTa;
    }

    public int getMaDg() {
        return MaDg;
    }

    public void setMaDg(int MaDg) {
        this.MaDg = MaDg;
    }

    public String getTenDg() {
        return TenDg;
    }

    public void setTenDg(String TenDg) {
        this.TenDg = TenDg;
    }

    public String getLoaiDg() {
        return LoaiDg;
    }

    public void setLoaiDg(String LoaiDg) {
        this.LoaiDg = LoaiDg;
    }

    public LocalTime getGioDg() {
        return GioDg;
    }

    public void setGioDg(LocalTime GioDg) {
        this.GioDg = GioDg;
    }

    public LocalDate getNgayDg() {
        return NgayDg;
    }

    public void setNgayDg(LocalDate NgayDg) {
        this.NgayDg = NgayDg;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.print("\tNhập tên giao dịch:");
        this.TenDg = s.nextLine();
        while(true){
            if(this.TenDg.length() > 0){
                  break;
              }else{
                  System.err.println("\tTên giao dịch không được để trống!!!");  
                  System.out.printf("\tNhập lại tên giao dịch: ");
                  TenDg = s.nextLine();
              }
        }
        System.out.print("\tNhập loại giao dịch:");
        this.LoaiDg = s.nextLine();
        while(true){
            if(this.LoaiDg.length() > 0){
                  break;
              }else{
                  System.err.println("\tLoại giao dịch không được để trống!!!");  
                  System.out.printf("\tNhập lại loại giao dịch: ");
                  LoaiDg = s.nextLine();
              }
        }
        while (true) {   
            System.out.print("\tNhập giờ giao dịch:");
            try {
                this.GioDg = LocalTime.parse(s.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
                
                break;
            } catch (Exception e) {
                System.err.println("\tGiờ không hợp lệ (HH:mm)!!!");
            }
        }
        while (true) {   
            System.out.print("\tNhập ngày giao dịch:");
            try {
                this.NgayDg = LocalDate.parse(s.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                
                break;
            } catch (Exception e) {
                System.err.println("\tNgày không hợp lệ (dd/MM/yyyy)!!!");
            }
        }
        System.out.print("\tNhập mô tả:");
        this.MoTa = s.nextLine();
        while(true){
            if(this.MoTa.length() > 0){
                  break;
              }else{
                  System.err.println("\tMô tả không được để trống!!!");  
                  System.out.printf("\tNhập lại mô tả: ");
                  MoTa = s.nextLine();
              }
        }
    }
    public void output(){
        System.out.printf("%-5d %-15s %-15s %-20s %-15s %-13s\n",
        this.MaDg,this.TenDg, this.LoaiDg, this.GioDg, this.NgayDg, 
        this.MoTa);
    }
//    public void output1(ETranslator eTran) {
//        System.out.printf("%-5d %-15s %-15s %-20s %-15s %-13s\n",
//            this.MaDg,
//            this.TenDg, 
//            this.LoaiDg, 
//            this.GioDg,
//            eTran.getDateformat(this.NgayDg),
//            this.MoTa); 
//    }
}
