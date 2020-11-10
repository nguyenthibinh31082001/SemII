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
public class Run_Bai3 {
    List<Bai3> lstHopSua = new ArrayList<>();

    public Run_Bai3() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập thông tin\n");
            System.out.printf("2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("3. Đếm số lượng hộp sữa sản xuất trước năm 2003\n");
            System.out.printf("4. Tìm hộp sữa mới nhất trong danh sách\n");
            System.out.printf("5. Sắp xếp các hộp sữa tăng dần theo hạn sử dụng.\n");
            System.out.printf("6. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
//                    display(lstHocSinh);
//                    System.out.println("Sửa:");
//                    edit();
                    break;
                case 3:
//                    ToanLietKe(sc);
                    break;
                case 4:
//                    Count(sc);s
                    break;
                case 5:
//                    SortDescending();
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
        System.out.print("Nhập số lượng hộp sữa:");
        int n = sc.nextInt();
        Bai3 hopsua;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Hộp sữa thứ %d: \n",i+1);
            hopsua = new Bai3();
            hopsua.input();
            lstHopSua.add(hopsua);
        }
    }
    public void display( List<Bai3> lst ){
        System.out.println("Nhãn hiệu\t|  Trọng lượng\t|  HSD\t");
        for(Bai3 f : lst){
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
//    public void ToanLietKe(Scanner sc){
//        List<Bai2> lst = new ArrayList<>();
//        for(Bai2 f : lstHocSinh){
//             if(f.getToan() < 5){
//                lst.add(f);
//            }
//        }
//        System.out.println("Các học sinh có điểm toán nhỏ hơn 5:");
//        display(lst);
//        System.out.println(" ");
//    }
//    public void Count(Scanner sc){
//        int count = 0;
//        List<Bai2> lst = new ArrayList<>();
//        for(Bai2 f : lstHocSinh){
//             if((f.getToan() > 8) && (f.getVan() > 8)){
//                 count++;
//                lst.add(f);
//            }
//        }
//        System.out.println("Các học sinh có điểm toán văn lớn hơn 8:");
//        display(lst);
//        System.out.println(" ");
//        System.out.println("Tổng số học sinh có điểm toán văn lớn hơn 8 là: "+count);
//    }
//
//    public void SortDescending(){
//    Collections.sort(lstHocSinh, new Comparator<Bai2>() {
//            @Override
//            public int compare(Bai2 o1, Bai2 o2) {
//                if (o1.TrungBinh < o2.TrungBinh) {
//                    return 1;
//                } else {
//                    if (o1.TrungBinh == o2.TrungBinh) {
//                        return 0;
//                    } else {
//                        return -1;
//                    }
//                }
//            }
//        });
//    System.out.println("Danh sách trung bình giảm dần là: ");
//    System.out.println("Tên\t|  Điểm toán\t|  Điểm văn\t|  Trung bình\t ");
//        for (int i = 0; i < lstHocSinh.size(); i++) {
////            System.out.println("Khu vực: " + lstCountry.get(i).area);
//            lstHocSinh.get(i).display();
//            System.out.println(" ");
//        }  
//    }
    public static void main(String[] args) {
        Run_Bai3 app = new Run_Bai3();
        app.run();
    }
}
