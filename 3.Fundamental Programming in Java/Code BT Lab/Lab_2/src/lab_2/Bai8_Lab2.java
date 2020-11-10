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
public class Bai8_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, c, d, x, y, max;
       

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập sô nguyên a:");
        a = input.nextInt();
        System.out.print("Nhập sô nguyên b:");
        b = input.nextInt();
        System.out.print("Nhập sô nguyên c:");
        c = input.nextInt();
        System.out.print("Nhập sô nguyên d:");
        d = input.nextInt();
        x= a;
        y= c;
        if(a < b){
            x = b;
        } 
         if(c < d){
            y = d;
        }
        max = x;
         if(y > x){;
            max = y;
             System.out.println("Số lớn nhất là:"+ max);
        }
    }
}
