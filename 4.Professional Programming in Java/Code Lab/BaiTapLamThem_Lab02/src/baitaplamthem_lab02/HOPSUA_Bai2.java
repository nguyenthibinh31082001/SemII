/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplamthem_lab02;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class HOPSUA_Bai2 {
    private String nhanHieu;//- Nhãn hiệu (chuỗi tối đa 20 ký tự), 
    private float trongLuong;//- Trọng lượng (kiểu số thực), 
    private LocalDate hanSd;//- hạn sử dụng (kiểu dữ liệu ngày). 

    public HOPSUA_Bai2() {
    }

    public HOPSUA_Bai2(String nhanHieu, float trongLuong, LocalDate hanSd) {
        this.nhanHieu = nhanHieu;
        this.trongLuong = trongLuong;
        this.hanSd = hanSd;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public float getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(float trongLuong) {
        this.trongLuong = trongLuong;
    }

    public LocalDate getHanSd() {
        return hanSd;
    }

    public void setHanSd(LocalDate hanSd) {
        this.hanSd = hanSd;
    }
    String regExpNhanHieu = "^[a-zA-Z0-9 ]{1,20}$";
    public void input(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\tNhập nhãn hiệu:");
            this.nhanHieu = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpNhanHieu);
            Matcher matcher = pattern.matcher(nhanHieu);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tNhãn hiệu tối đa 20 ký tự!");
            }
        } while (true);
        
        while (true) {
            try {
                System.out.printf("\tNhập trọng lượng:");
                this.trongLuong = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.printf("\tNhập hạn sử dụng:");
        this.hanSd = string2LocalDate(sc);
     }
    public LocalDate string2LocalDate(Scanner sc){
        LocalDate ld = null;
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
//            e.printStackTrace();
               System.err.println("\tNgày không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại ngày(dd/MM/yyyy): ");
               sc.nextLine();

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    
    public void display() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.nhanHieu));
        builder.append("|\t\t");
        builder.append(String.format("%8s", this.trongLuong));
        builder.append("|\t");
        builder.append(String.format("%10s", hanSd.format(dateTimeFormatter)));
        builder.append("|\t");
        
        System.out.print(builder.toString());
    }
    public int Year(){
        return hanSd.getYear();
        
    }
}
