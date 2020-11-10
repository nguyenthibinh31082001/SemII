/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai14_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float gio, luong;
       
        Scanner input = new Scanner(System.in);

        System.out.printf("Nhập số giờ: ");
        gio = input.nextFloat();
        System.out.printf("Nhập số lương của 1 giờ: ");
        luong = input.nextFloat();
        
        if(gio>40){
            System.out.printf("Tổng số lương là:%.3f\n",luong*40 + (gio-40)*luong*1.5);
        }else{
            System.out.printf("Tổng số lương là:%.3f\n",gio*luong);
        }
    }
}
