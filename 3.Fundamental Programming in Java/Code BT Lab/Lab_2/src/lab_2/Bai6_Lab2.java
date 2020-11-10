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
public class Bai6_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N ;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Nhập số nguyên N:");
        N = input.nextInt();
        
        if(N % 2 == 0){
            System.out.println("Số nguyên N là số chẵn");
        }else{
            System.out.println("Số nguyên N là số lẻ");
        }    
    }
}
