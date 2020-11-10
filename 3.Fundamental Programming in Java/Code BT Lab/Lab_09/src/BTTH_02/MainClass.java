/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_02;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class MainClass {
   private class NhapLieu {
       public String inputString() {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
        }
        public int inputInt() {
            Scanner input = new Scanner(System.in);
            do {
                try {
                    int number = Integer.parseInt(input.nextLine());
                    return number;
                } catch (Exception e) {
                    System.out.printf("Vui lòng nhập số nguyên: ");
                }
            } while (true);
        }
        public float inputFloat() {
            Scanner input = new Scanner(System.in);
            do {
                try {
                    float number = Float.parseFloat(input.nextLine());
                    return number;
                } catch (Exception e) {
                    System.out.printf("Vui lòng nhập số thực");
                }
            } while (true);
        }
   }
   public void nhapDuLieu() {
        NhapLieu nhap = new NhapLieu();
        System.out.printf("Nhập số nguyên: ");
        System.out.printf("\tGiá trị số nguyên = " + nhap.inputInt()+ "\n");
        System.out.printf("Nhập số thực: ");
        System.out.printf("\tGiá trị số thực = " + nhap.inputFloat()+ "\n");
        System.out.printf("Nhập số chuỗi: ");
        System.out.printf("\tGiá trị chuỗi = " + nhap.inputString()+ "\n");
   }
   public static void main(String[] args) {
        MainClass main = new MainClass();
        main.nhapDuLieu();
    }
}
