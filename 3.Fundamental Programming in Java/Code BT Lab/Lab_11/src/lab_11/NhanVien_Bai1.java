/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NhanVien_Bai1 {
    List<Bai1> lstnhanvien = new ArrayList<>();
    
    public NhanVien_Bai1() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập thông tin n nhân viên\n");
            System.out.printf("2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("3. Liệt kê các nhân viên trên 40 tuổi\n");
            System.out.printf("4. Đếm số lượng nhân viên có lương lớn hơn 1.000.000 đồng \n");
            System.out.printf("5. Viết hàm sắp xếp các nhân viên giảm dần theo năm \n");
            System.out.printf("6. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 1:
                    input();
                    break;
                case 2:
                    display(lstnhanvien);
                    break;
                case 3:
                    YearOld(sc);
                    break;
                case 4:
                    CountNhanVien(sc);
                    break;
                case 5:
                    System.out.println("Danh sách nhân viên năm sinh tăng dần là: ");
                    SortAscending();
                    System.out.println("Danh sách nhân viên năm sinh giảm dần là: ");
                    SortDescending();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-6!!!");
            }
        }while(true);
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên:");
        int n = sc.nextInt();
        Bai1 nhanvien;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Nhân viên %d: \n",i+1);
            Bai1 nv = new Bai1();
            sc.nextLine();
            System.out.printf("\tNhập tên nhân viên: ");
            nv.setHoTen(sc.nextLine());
            while(nv.getHoTen().length()>30){
                System.err.println("\tHọ tên không được vượt quá 30 ký tự!");
                System.out.printf("\tNhập tên nhân viên: ");
                nv.setHoTen(sc.nextLine());
            }
            System.out.printf("\tNhập ngày sinh: ");
            nv.setNgaySinh(string2LocalDate(sc));
            while (true) {
                try {
                    System.out.printf("\tNhập lương: "); 
                    nv.setLuong(sc.nextFloat());
                    break;
                } catch (Exception ex) {
                    System.err.println("\tYêu cầu nhập số thực:");
//                    System.out.println(""+ex.getLocalizedMessage());
                    sc.nextLine();
                }
            } 
            System.out.printf("\tNhập giới tính(0. Nữ, 1.Nam): ");
            nv.setGioiTinh(sc.nextInt());
            while((nv.getGioiTinh() != 0) && (nv.getGioiTinh() != 1)){
                System.err.println("\tNữ nhập (0), Nam nhập (1)!");
                System.out.printf("\tNhập giới tính(0. Nữ, 1.Nam): ");
                nv.setGioiTinh(sc.nextInt());
            }
            lstnhanvien.add(nv);
//            nhanvien = new Bai1();
//            nhanvien.input();
//            lstnhanvien.add(nhanvien);
        }
    }
    public void display(List<Bai1> lst){
        System.out.println("Tên\t  |   Ngày sinh\t  |   Lương\t  |   Giới tính\t ");
        for(Bai1 f : lst){
            f.display();
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public LocalDate string2LocalDate(Scanner sc){
        LocalDate ld = null;
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
//            e.printStackTrace();
               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại ngày sinh(dd/MM/yyyy): ");
               sc.nextLine();

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    
    public void YearOld(Scanner sc){
        Bai1 nhanvien;
        System.out.println("Các nhân viên trên 40 tuổi:");
        System.out.println("Tên\t  |   Năm sinh\t  |   Lương\t  |   Giới tính\t ");
        for(int i = 0 ; i< lstnhanvien.size(); i++){
            nhanvien = lstnhanvien.get(i);
            LocalDate ngaySinhNv = nhanvien.getNgaySinh();
            LocalDate DayNow = LocalDate.now();
            long years = ChronoUnit.YEARS.between(ngaySinhNv, DayNow);
//            System.out.println(years);
            if(years > 40){
                nhanvien.display();
                System.out.println(" ");
            }
        }
        System.out.println(" ");
    }
    public void CountNhanVien(Scanner sc){
        int count = 0;
        List<Bai1> lst = new ArrayList<>();
        for(Bai1 f : lstnhanvien){
             if(f.getLuong() > 1000000){
                 count++;
                lst.add(f);
            }
        }
        System.out.println("Lương các nhân viên hơn 1000000: ");
        display(lst);
//        System.out.println(" ");
        System.out.println("Tổng số nhân viên lương hơn 1000000 là: "+count);
        
    }
    public void SortAscending(){
        Collections.sort(lstnhanvien,new Comparator<Bai1>() {
            @Override
            public int compare(Bai1 o1, Bai1 o2) {
                return o1.getNgaySinh().compareTo(o2.getNgaySinh());
            }
        });
        for(Bai1 nv : lstnhanvien){
            nv.display();
            System.out.println(" ");
        }
        System.out.println(" ");
//        lstnhanvien.sort(Comparator.comparing(staff -> staff.getNgaySinh().getYear()));
////        Collections.sort(lstnhanvien, Comparator.comparing(staff -> staff.getNgaySinh().getYear()));
//
//        lstnhanvien.forEach(staff -> System.out.println(staff.toString()));
    }
    public void SortDescending(){
        Collections.sort(lstnhanvien,new Comparator<Bai1>() {
            @Override
            public int compare(Bai1 o1, Bai1 o2) {
                return o2.getNgaySinh().compareTo(o1.getNgaySinh());
            }
        });
        for(Bai1 nv : lstnhanvien){
            nv.display();
            System.out.println(" ");
        }
        System.out.println(" ");
//        lstnhanvien.sort((Comparator.comparing(staff -> staff.getNgaySinh().getYear())).reversed());
//        Collections.sort(lstnhanvien, Comparator.comparing(staff -> staff.getNgaySinh().getYear()));
        
//        lstnhanvien.forEach(staff -> System.out.println(staff.toString()));
    }
     public static void main(String[] args) {
        NhanVien_Bai1 nhanVien_Bai1 = new NhanVien_Bai1();
        nhanVien_Bai1.run();
     }
}
