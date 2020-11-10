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
public class Bai4_Lab1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a;
        int n;
        float m;
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Nhập chuỗi a:");
        a = input.nextLine();
        
        System.out.print("Nhập số nguyên n:");
        n = input.nextInt();
        
        System.out.print("Nhập số thực m:");
        m = input.nextFloat();
        
        System.out.println("Chuỗi a vừa nhập là:" + a);
        System.out.println("Số nguyên n vừa nhập là:" + n);
        System.out.println("Số thực m vừa nhập là:" + m);
        
      
    }
}
