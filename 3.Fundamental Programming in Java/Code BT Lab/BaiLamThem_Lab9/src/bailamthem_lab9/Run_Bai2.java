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
public class Run_Bai2 {
    List<Bai2> lstHocSinh = new ArrayList<>();

    public Run_Bai2() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập thông tin\n");
            System.out.printf("2. Hiển thị thông tin vừa nhập(Thêm, Sửa, Xóa).\n");
            System.out.printf("3. Liệt kê các học sinh có điểm toán nhỏ hơn 5 \n");
            System.out.printf("4. Đếm số lượng học sinh có điểm toán và điểm văn lớn hơn 8 điểm\n");
            System.out.printf("5. Viết hàm sắp xếp các học sinh giảm dần theo điểm trung bình.\n");
            System.out.printf("6. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstHocSinh);
//                    System.out.println("Sửa:");
//                    edit();
                    break;
                case 3:
                    ToanLietKe(sc);
                    break;
                case 4:
                    Count(sc);
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
        System.out.print("Nhập số lượng học sinh:");
        int n = sc.nextInt();
        Bai2 hocsinh;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Học sinh %d: \n",i+1);
            hocsinh = new Bai2();
            hocsinh.input();
            lstHocSinh.add(hocsinh);
        }
    }
    public void display( List<Bai2> lst ){
        System.out.println("Tên\t|  Điểm toán\t|  Điểm văn\t|  Trung bình\t ");
        for(Bai2 f : lst){
            f.display();
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    
//    public void edit() {
//        boolean isExisted = false;
////        int size = lstHocSinh.size();
//         Bai2 hocsinh;
//        for (int i = 0; i < lstHocSinh.size(); i++) {
//            hocsinh = lstHocSinh.get(i);
//            if (hocsinh.getHoTen() == hocsinh.HoTen) {
//                isExisted = true;
//                hocsinh.getHoTen();
//                hocsinh.getToan();
//                hocsinh.getVan();
//                break;
//            }
//        }
//        studentDao = new StudentDao();
//        if (!isExisted) {
//            System.out.printf("id = %d not existed.\n");
//        } else {
//            studentDao.write(lstHocSinh);
//        }
//    }
    public void ToanLietKe(Scanner sc){
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstHocSinh){
             if(f.getToan() < 5){
                lst.add(f);
            }
        }
        System.out.println("Các học sinh có điểm toán nhỏ hơn 5:");
        display(lst);
        System.out.println(" ");
    }
    public void Count(Scanner sc){
        int count = 0;
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstHocSinh){
             if((f.getToan() > 8) && (f.getVan() > 8)){
                 count++;
                lst.add(f);
            }
        }
        System.out.println("Các học sinh có điểm toán văn lớn hơn 8:");
        display(lst);
        System.out.println(" ");
        System.out.println("Tổng số học sinh có điểm toán văn lớn hơn 8 là: "+count);
    }

    public void SortDescending(){
    Collections.sort(lstHocSinh, new Comparator<Bai2>() {
            @Override
            public int compare(Bai2 o1, Bai2 o2) {
                if (o1.TrungBinh < o2.TrungBinh) {
                    return 1;
                } else {
                    if (o1.TrungBinh == o2.TrungBinh) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("Danh sách trung bình giảm dần là: ");
    System.out.println("Tên\t|  Điểm toán\t|  Điểm văn\t|  Trung bình\t ");
        for (int i = 0; i < lstHocSinh.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstHocSinh.get(i).display();
            System.out.println(" ");
        }  
    }
    public static void main(String[] args) {
        Run_Bai2 app = new Run_Bai2();
        app.run();
    }
}
