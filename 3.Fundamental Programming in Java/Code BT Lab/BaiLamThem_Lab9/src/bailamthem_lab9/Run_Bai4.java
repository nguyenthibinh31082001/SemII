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
public class Run_Bai4 {
    List<Bai4> lstKhachSan = new ArrayList<>();

    public Run_Bai4() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập thông tin\n");
            System.out.printf("2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("3. Liệt kê các phòng trống trong danh sách.\n");
            System.out.printf("4. Tính tổng số lượng giường có trong danh sách.\n");
            System.out.printf("5. Sắp xếp danh sách liên kết tăng dần theo đơn giá thuê.\n");
            System.out.printf("6. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstKhachSan);
                    break;
                case 3:
                    LietKe(sc);
                    break;
                case 4:
                    Count(sc);
                    break;
                case 5:
                    SortAscending();
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
        System.out.print("Nhập số lượng phòng khách sạn:");
        int n = sc.nextInt();
        Bai4 khachsan;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Phòng %d: \n",i+1);
            khachsan = new Bai4();
            khachsan.input();
            lstKhachSan.add(khachsan);
        }
    }
    public void display( List<Bai4> lst ){
        System.out.println("Mã\t|  Tên\t|  Giá\t|  Số lượng\t|  Tình trạng\t ");
        for(Bai4 f : lst){
            f.display();
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    
    public void LietKe(Scanner sc){
        List<Bai4> lst = new ArrayList<>();
        for(Bai4 f : lstKhachSan){
             if(f.getTinhTrang() == 0){
                lst.add(f);
            }
        }
        System.out.println("Các phòng còn trống trong khách sạn là:");
        display(lst);
        System.out.println(" ");
    }
    public void Count(Scanner sc){
        int count = 0;
        List<Bai4> lst = new ArrayList<>();
        for(Bai4 f : lstKhachSan){
            count += f.getSoLuong();
        }
        System.out.println("Tổng số lượng giường có trong danh sách là: "+count);
    }

    public void SortAscending(){
    Collections.sort(lstKhachSan, new Comparator<Bai4>() {
            @Override
            public int compare(Bai4 o1, Bai4 o2) {
                if (o1.donGia > o2.donGia) {
                    return 1;
                } else {
                    if (o1.donGia == o2.donGia) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("Danh sách liên kết tăng dần theo đơn giá thuê là: ");
    System.out.println("Mã\t|  Tên\t|  Giá\t|  Số lượng\t|  Tình trạng\t ");
        for (int i = 0; i < lstKhachSan.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstKhachSan.get(i).display();
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        Run_Bai4 app = new Run_Bai4();
        app.run();
    }
}
