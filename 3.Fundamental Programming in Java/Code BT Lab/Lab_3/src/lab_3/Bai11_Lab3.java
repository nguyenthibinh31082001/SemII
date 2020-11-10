/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai11_Lab3 {
    public static void main(String[] args) {
        int n;
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Nhập số n:");
        n = input.nextInt();
        System.out.printf("Các số hoàn hảo từ 1 đến "+n+" là:");
        for ( int i = 1; i < n;i++){
            int sum = 0;
            for (int j = 1 ; j < i;j++){
                if (i%j==0){
                    sum+=j;
                }  
            }
            if (i == sum){
                System.out.printf(i+ ",");
            }   
        }
        System.out.println(" ");
    }
}
