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
public class Bai12_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pheptinh;
        float x, y;
       
        Scanner input = new Scanner(System.in);

        System.out.printf("Nhập số x: ");
        x = input.nextFloat();
        System.out.printf("Nhập số y: ");
        y = input.nextFloat();
        input.nextLine();
        System.out.printf("Nhập một phép tính(+,-,*,/):");
        pheptinh = input.nextLine();
        
        switch(pheptinh){
            case "+":
                System.out.printf("Tổng là:%.3f\n",x+y);
                break;
            case "-":
                System.out.printf("Hiệu là:%.3f\n",x-y);
                break;
            case "*":
                System.out.printf("Tích là:%.3f\n",x*y);
                break;
            case "/":
                if(y == 0){
                    System.out.printf("Phép tính không chia được\n");
                }else{
                    System.out.printf("Thương là:%.3f\n",x/y);
                }
                break;
        }
    }
}
