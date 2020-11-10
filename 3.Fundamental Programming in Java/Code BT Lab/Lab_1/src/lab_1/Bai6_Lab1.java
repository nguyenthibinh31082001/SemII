/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai6_Lab1 {
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n1,m1,n1m1;
        float n2,m2,n2m2,n1n2;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Nhập số nguyên n1:");
        n1 = input.nextInt();
        System.out.print("Nhập số nguyên m1:");
        m1 = input.nextInt();
        
        System.out.print("Nhập số thực n2:");
        n2 = input.nextFloat();
        System.out.print("Nhập số thực m2:");
        m2 = input.nextFloat();

        n1m1 = n1 + m1;
        n2m2 = n2 + m2;
        n1n2 = n1 + n2;
        System.out.println("Tổng 2 số nguyên vừa nhập là:" + n1m1);   
        System.out.println("Tổng 2 số thực vừa nhập là:" + n2m2);
        System.out.println("Tổng số nguyên và số thực vừa nhập là:" + n1n2); 
    } 
}
