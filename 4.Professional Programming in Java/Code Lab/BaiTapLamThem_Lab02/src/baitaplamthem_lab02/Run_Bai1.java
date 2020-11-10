/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplamthem_lab02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class Run_Bai1 {
    List<Bai_1> xemPhim = new ArrayList<Bai_1>();
      
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập số lượng vé xem phim: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Vé %d: \n",i+1);
            Bai_1 bai_1 = new Bai_1();
            bai_1.input();
            xemPhim.add(bai_1);
        }
    }
    public void display(){
        System.out.println("Danh sách vừa nhập là: ");
        System.out.println("Tên\tGía tiền\tXuất chiếu\tNgày xem");
        for(Bai_1 f : xemPhim){
            f.display();
            System.out.println(" ");
        }
    }
    public void countGia(){
        double tong = 0;
        for (int i = 0; i< xemPhim.size(); i++) {
            Bai_1 c = ((Bai_1) xemPhim.get(i));
            tong += c.getGia();
        }
        System.out.println("Tổng giá tiền các vé trong danh sách là: "+tong);
    }
    public static void main(String[] args) {
        Run_Bai1 run_Bai1 = new Run_Bai1();
        run_Bai1.input();
        run_Bai1.display();
        run_Bai1.countGia();
    }
}
