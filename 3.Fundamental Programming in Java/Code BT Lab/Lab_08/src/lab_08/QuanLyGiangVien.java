/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QuanLyGiangVien {
    
    List<GiangVien> lstGiangVien = new ArrayList<>();
    
    public void run(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập vào thông tin của giảng viên\n");
            System.out.printf("2. Xuất danh sách toàn bộ giảng viên\n");
            System.out.printf("3. Xuất danh sách giảng viên cơ hữu\n");
            System.out.printf("4. Xuất danh sách giảng viên thỉnh giảng\n");
            System.out.printf("5. Tính tổng số tiền lương của toàn bộ giảng viên\n");
            System.out.printf("6. Tìm giảng viên có tổng lương cao nhất.\n");
            System.out.printf("7. Thoát\n");
            System.out.printf("Chọn chức năng 1-7: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    display(true);
                    break;
                case 4:
                    display(false);
                    break;
                case 5:
                    totalSalary();
                    break;
                case 6:
                    
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-7!!!");
            }
        }while(true);
    }
    public void input(Scanner sc) {
        System.out.printf("Nhập giảng viên cơ hữu chọn (C), Nhập giảng viên thỉnh giảng (T): ");
        String str =  sc.nextLine();
         char c = ' ';
        if(str.length() >= 0){
             c = str.charAt(0);
        }
       
        System.out.printf("Số lượng giảng viên cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (c == 'C' || c == 'c') {
                GiangVienCoHuu gv = new GiangVienCoHuu();
                gv.input();
                lstGiangVien.add(gv);
                System.out.println(" ");
            } else if((c == 'T' || c == 't')){
                GiangVienThinhGiang gv = new GiangVienThinhGiang();
                gv.input();
                lstGiangVien.add(gv);
                System.out.println(" ");
            }
        }
    }
    public void display() {
        System.out.println("Tên\t Địa chỉ\t Điện thoại\t Số giờ\t ");
        for (int i = 0; i < lstGiangVien.size(); i++) {
            if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
                ((GiangVienCoHuu) lstGiangVien.get(i)).display();
            } else {
                ((GiangVienThinhGiang) lstGiangVien.get(i)).display();
            }
        }
    }
    public void display(boolean type) {
        System.out.println("Tên\t Địa chỉ\t Điện thoại\t Số giờ");
        if (type) {

            for (int i = 0; i < lstGiangVien.size(); i++) {
                if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
                    ((GiangVienCoHuu) lstGiangVien.get(i)).display();
                }
            }
        } else {
            for (int i = 0; i < lstGiangVien.size(); i++) {
                if (lstGiangVien.get(i) instanceof GiangVienThinhGiang) {
                    ((GiangVienThinhGiang) lstGiangVien.get(i)).display();
                }
            }
        }
    }
    public void totalSalary(){
        double total = 0.0;
        for (int i = 0; i < lstGiangVien.size(); i++) {
            if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
               GiangVienCoHuu gc = ((GiangVienCoHuu) lstGiangVien.get(i));
               total += gc.getLuongThoaThuan();
            } else {
                GiangVienThinhGiang gt = ((GiangVienThinhGiang) lstGiangVien.get(i));
                total += (gt.getGioDay() * 200000);
            }
        }
        
        System.out.println("\tTổng lương toàn công ty: " + total);
    }
//    public void MaxTongLuong(){
//        double total = 0.0;
//        float max = lstGiangVien.get(0); 
//        for (int i = 0; i < lstGiangVien.size(); i++) {
//            if (lstGiangVien.get(i) instanceof GiangVienCoHuu) {
//               
//            } else {
//                
//            }
//        }
//    }
    
    public static void main(String[] args) {
        QuanLyGiangVien app = new QuanLyGiangVien();
        app.run();
    }
}
