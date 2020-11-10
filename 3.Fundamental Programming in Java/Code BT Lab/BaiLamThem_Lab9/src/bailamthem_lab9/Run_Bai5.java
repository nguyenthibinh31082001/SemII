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
public class Run_Bai5 {
    List<Bai5> lstSach = new ArrayList<>();

    public Run_Bai5() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập thông tin\n");
            System.out.printf("2. Hiển thị thông tin vừa nhập(Thêm, Sửa, Xóa).\n");
            System.out.printf("3. Tìm quyển sách cũ nhất trong danh sách liên kết.\n");
            System.out.printf("4. Tìm một năm có nhiều sách xuất bản nhất và liệt kê tất cả các quyển sách xuất\n" +
"bản trong năm đó\n");
            System.out.printf("5. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-5: ");
            int choice = sc.nextInt();
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstSach);
                    break;
                case 3:
                    SachCu(sc);
                    break;
                case 4:
//                    Count(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-5!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng sách:");
        int n = sc.nextInt();
        Bai5 sach;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Quyển thứ %d: \n",i+1);
            sach = new Bai5();
            sach.input();
            lstSach.add(sach);
        }
    }
    public void display( List<Bai5> lst ){
        System.out.println("Tên\t|  Tác giả\t|  Năm xuất bản\t ");
        for(Bai5 f : lst){
            f.display();
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public void SachCu(Scanner sc){
        int min = 0;
        List<Bai5> lst = new ArrayList<>();
        for(Bai5 f : lstSach){
             if(f.getNamXuatBan() < min){
                 min = f.getNamXuatBan();
                lst.add(f);
            }
        }
        System.out.println("Quyển sách cũ nhất là: "+min);
        display(lst);
        System.out.println(" ");
    }
    
    
    public static void main(String[] args) {
        Run_Bai5 app = new Run_Bai5();
        app.run();
    }
}
