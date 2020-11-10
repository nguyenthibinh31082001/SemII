/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Movie {
    private String ten;//- Tên phim: chuỗi tối đa 20 ký tự.
    private  int gia;//- Giá tiền: kiểu số nguyên 4 byte.
    private LocalTime xuatChieu;//- Xuất chiếu: kiểu thời gian (THOIGIAN).
    private LocalDate ngayXem;//- Ngày xem: kiểu dữ liệu ngày (NGAY).

    public Movie() {
    }

    public Movie(String ten, int gia, LocalTime xuatChieu, LocalDate ngayXem) {
        this.ten = ten;
        this.gia = gia;
        this.xuatChieu = xuatChieu;
        this.ngayXem = ngayXem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public LocalTime getXuatChieu() {
        return xuatChieu;
    }

    public void setXuatChieu(LocalTime xuatChieu) {
        this.xuatChieu = xuatChieu;
    }

    public LocalDate getNgayXem() {
        return ngayXem;
    }

    public void setNgayXem(LocalDate ngayXem) {
        this.ngayXem = ngayXem;
    }
    
    String regExpTen = "^[a-zA-Z0-9 ]{1,20}$";
//    String regExpGia = "^[0-9]{-2.147,2.147}$";
    public void input(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\tNhập tên phim:");
            this.ten = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpTen);
            Matcher matcher = pattern.matcher(ten);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tTên phim chỉ tối đa 20 ký tự!!!");
            }
        } while (true);
        while (true) {
            try {
                do {
                    System.out.printf("\tNhập giá tiền:");
                    this.gia = sc.nextInt();
                    if (this.gia <= (byte)4) {
                        break;
                    } else {
                        System.err.println("\tGiá tiền phải đủ 4 byte!!!");
                    }
                } while (true); 
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.printf("\tNhập thời gian xuất chiếu:");
        xuatChieu = string2LocalTime(sc);     
        System.out.printf("\tNhập ngày xem:");
        ngayXem = string2LocalDate(sc);
        
     }
    public LocalTime string2LocalTime(Scanner sc){
        LocalTime ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            ld = LocalTime.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
//            e.printStackTrace();
               System.err.println("\tThời gian xuất chiếu không hợp lệ (hh:mm)");
               System.out.printf("\tNhập lại thời gian xuất chiếu(hh:mm): ");
               sc.nextLine();
//               string2LocalTime(sc);

        }catch(Exception e) {
            e.printStackTrace();
        }
        return ld;
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
               string2LocalDate(sc);

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }

    @Override
    public String toString() {
        return "ten=" + ten + ", gia=" + gia + ", xuatChieu=" + xuatChieu + ", ngayXem=" + ngayXem;
    }
    
}
