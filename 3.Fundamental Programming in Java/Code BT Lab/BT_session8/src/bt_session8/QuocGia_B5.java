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
public class QuocGia_B5 {
    ArrayList<Bai5> listQuocGia = new ArrayList<>();
    
    public void nhapDuLieu() {
    System.out.printf("Số quốc gia muốn nhập:");
    Scanner input = new Scanner(System.in);
    int cnt = input.nextInt();
    for (int i = 0; i < cnt; i++) {
        System.out.println("Nhập quốc gia thứ " + (i + 1));
        Bai5 ds = new Bai5();
        ds.nhapDuLieu();
        listQuocGia.add(ds);
    }
    System.out.println("Xin cảm ơn!");
    }
    public void hienThiDanhSach() {
        System.out.println("Số quốc gia đã nhập: ");
        for (int i = 0; i < listQuocGia.size(); i++) {
            Bai5 get = listQuocGia.get(i);
            System.err.println((i + 1) + ". " + get.toString());
        }
    }
    public void xoaSach() {
        System.out.printf("Nhập số thứ tự quốc gia muốn xóa:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        if (id < listQuocGia.size() && id >= 0) {
            listQuocGia.remove(id);
        }
        System.out.println("Xóa thành công");
    }
    public int showMenu() {
        System.out.println("Menu");
        System.out.println("1. Nhập tên quốc gia");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Xóa");
        System.out.println("4. Thoát");
        System.out.printf("Vui lòng nhập từ 1 -> 4:");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static void main(String[] args) {
        int choose;
        QuocGia_B5 main = new QuocGia_B5();
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
                main.xoaSach();
                break;
                case 4:
                System.exit(0);
                break;
            }
        } while (true);
    }
}

