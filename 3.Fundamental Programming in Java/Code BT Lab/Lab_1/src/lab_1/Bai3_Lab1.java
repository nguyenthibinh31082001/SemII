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
public class Bai3_Lab1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a;
        float m;
        
        Scanner songuyen = new Scanner(System.in);
        
        System.out.print("Nhập số nguyên a:");
        a = songuyen.nextInt();
        
        System.out.print("Nhập số thực m:");
        m = songuyen.nextFloat();
        
        System.out.println("Số nguyên a vừa nhập là:" + a);
        System.out.println("Số thực m vừa nhập là:" + m);
    }
}
