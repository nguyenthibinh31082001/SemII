/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_session8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ThanhPho_B6 {
    ArrayList<Bai6> listQThanhPho = new ArrayList<>();
    public void nhapDuLieu() {
    Scanner input = new Scanner(System.in);
    System.out.printf("Tiếp tục - chọn 1 để nhập:");
    int cnt = input.nextInt();
    for (int i = 0; i < cnt; i++) {
        if(cnt == 1){
            System.out.println("Nhập thành phố:");
            Bai6 ds = new Bai6();
            ds.nhapDuLieu();
            listQThanhPho.add(ds);
        }else{
            break;
        }
        
    }
    System.out.println("Xin cảm ơn!");
    }
    public void hienThiDanhSach() {
        System.out.println("Số thành phố đã nhập: ");
        for (int i = 0; i < listQThanhPho.size(); i++) {
            Bai6 get = listQThanhPho.get(i);
            System.err.println((i + 1) + ". " + get.toString());
        }
    }
    public int showMenu() {
        System.out.println("Menu");
        System.out.println("1. Nhập tên thành phô");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Thoát");
        System.out.printf("Vui lòng nhập từ 1 -> 4:");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static void main(String[] args) {
        int choose;
        ThanhPho_B6 main = new ThanhPho_B6();
        do {
            choose = main.showMenu();
            switch (choose) {
                case 1:
                main.nhapDuLieu();
                break;
                case 2:
                main.hienThiDanhSach();
                break;
                case 3:
                System.exit(0);
                break;
            }
        } while (true);
    }
}
