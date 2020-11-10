/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai2_Lab3 {
   
    public static void main(String[] args) {
        int i,n, sum = 0;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập số nguyên n:");
        n = input.nextInt();
        
         for(i = 1; i <= n; i++){
            sum = sum + i;
        }
        System.out.println("Tổng từ 1 đến n là:" + sum);
        return;
    }
}
