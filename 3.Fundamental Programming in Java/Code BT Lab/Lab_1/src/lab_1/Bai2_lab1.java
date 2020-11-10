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
public class Bai2_lab1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a;
        
        Scanner songuyen = new Scanner(System.in);
        
        System.out.print("Nhập a:");
        a = songuyen.nextInt();
        
        System.out.println("Số a vừa nhập là:" + a);
    }
}
