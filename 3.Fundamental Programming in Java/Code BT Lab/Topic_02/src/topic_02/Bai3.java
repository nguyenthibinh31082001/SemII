/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_02;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, num;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
	n = sc.nextInt();
        System.out.println();
	num = n;
        
        for (int i = 1; i <= n; i++) {
            // 
            for (int j = 1; j <= i; j++) {
                    System.out.print(" ");
            }
            // 
            for (int k = 1; k <= num; k++) {
                    System.out.print("*");
            }
            // 
            for (int k = n - i; k >= 1; k--) {
                    System.out.print("*");
            }
            num--;
            System.out.println();
	}
        for (int i = 2; i <= n; i++) {
            //
            for (int j = n - i + 1; j >= 1; j--) {
                    System.out.print(" ");
            }
            // 
            for (int k = 1; k <= i; k++) {
                    System.out.print("*");
            }
            // 
            for (int k = i - 1; k >= 1; k--) {
                    System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
