/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai7_Lab3 {
    public static void main(String[] args) {
        int N, i;
        int sum = 0, TBC;
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Nhập số N:");
        N = input.nextInt();
        System.out.printf("Các số lẻ nhỏ hơn "+N+" là:" );
        
        int tong =0;
        for(i=1;i<=N;i++){
            if(i%2 != 0){
                System.out.printf(i+ ",");
                 sum += i*i;
            }  
            tong += i ;
        }   
        TBC = (int) ((float)tong/N);
        System.out.println(" ");
        System.out.println("Tổng bình phương các số lẻ là:" +sum);
        System.out.println("TBC: " +TBC);
    }
}
