/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplamthem_lab02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Bai_1 {

    private String ten;//- Tên phim: chuỗi tối đa 20 ký tự.
    private  int gia;//- Giá tiền: kiểu số nguyên 4 byte.
    private LocalTime xuatChieu;//- Xuất chiếu: kiểu thời gian (THOIGIAN).
    private LocalDate ngayXem;//- Ngày xem: kiểu dữ liệu ngày (NGAY).

    public Bai_1() {
    }

    public Bai_1(String ten, int gia, LocalTime xuatChieu, LocalDate ngayXem) {
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
    public void display() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.ten));
        builder.append("|\t");
        builder.append(String.format("%8s", this.gia));
        builder.append("|\t");
        builder.append(String.format("%10s",this.xuatChieu));
        builder.append("|\t");
        builder.append(String.format("%10s", ngayXem.format(dateTimeFormatter)));
        builder.append("|\t");
        
        System.out.print(builder.toString());
    }
    //        LocalTime localTime = LocalTime.now();
//        System.out.println(localTime.getHour()+":"+localTime.getMinute());
//    public static void main(String[] args) {
//        Set<Bai_1> xemPhim = new HashSet<Bai_1>();
//        
//        Scanner sc = new Scanner(System.in);
//        System.out.printf("Nhập số lượng vé xem phim: ");
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Vé %d: \n",i+1);
//            Bai_1 bai_1 = new Bai_1();
//            bai_1.input();
//            xemPhim.add(bai_1);
//        }
//
//        System.out.println("Danh sách vừa nhập là: ");
//        System.out.println("Tên\tGía tiền\tXuất chiếu\tNgày xem");
//        System.out.println(xemPhim);
//    }
}
