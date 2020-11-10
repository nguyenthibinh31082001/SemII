/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthem_lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Run_Bai1 {
    List<Bai1> lstnhanvien = new ArrayList<>();

    public Run_Bai1() {
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
                    input(sc);
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
    public void input(Scanner sc){
        System.out.print("Nhập số lượng nhân viên:");
        int n = sc.nextInt();
        Bai1 nhanvien;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Nhân viên %d: \n",i+1);
            nhanvien = new Bai1();
            nhanvien.input();
            lstnhanvien.add(nhanvien);
        }
    }
    
    public void display( List<Bai1> lst ){
        System.out.println("Tên\t  |   Năm sinh\t  |   Lương\t  |   Giới tính\t ");
        for(Bai1 f : lst){
            f.display();
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public void YearOld(Scanner sc){
        System.out.print("Nhập năm hiện tại:");
        int nam = sc.nextInt();
        Bai1 nhanvien;
        System.out.println("Các nhân viên trên 40 tuổi:");
        System.out.println("Tên\t  |   Năm sinh\t  |   Lương\t  |   Giới tính\t ");
        for(int i = 0 ; i< lstnhanvien.size(); i++){
            nhanvien = lstnhanvien.get(i);
            int tuoi =nam - nhanvien.getNamSinh();
//            System.out.println("Tuổi: "+tuoi);
            if(tuoi > 40){
                nhanvien.display();
                System.out.println(" ");
            }
        }
//        Bai1 b1 = new Bai1();
//        if(nam <= b1.NamSinh){
//            System.out.println("Không tìm thấy nhân viên nào trên 40 tuổi ");
//        }
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
        System.out.println(" ");
        System.out.println("Tổng số nhân viên lương hơn 1000000 là: "+count);
        
    }
    public void SortDescending(){
    Collections.sort(lstnhanvien, new Comparator<Bai1>() {
            @Override
            public int compare(Bai1 o1, Bai1 o2) {
                if (o1.NamSinh < o2.NamSinh) {
                    return 1;
                } else {
                    if (o1.NamSinh == o2.NamSinh) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("Danh sách sắp xếp năm sinh giảm dần là: ");
    System.out.println("Tên\t  |   Năm sinh\t  |   Lương\t  |   Giới tính\t ");
        for (int i = 0; i < lstnhanvien.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstnhanvien.get(i).display();
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        Run_Bai1 app = new Run_Bai1();
        app.run();
    }
}
