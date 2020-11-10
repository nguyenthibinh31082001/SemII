/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai4_Lab3 {
    
    public static void main(String[] args) {
        int n;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập 1 số nguyên:");
        n = input.nextInt();
        
        int count = 0;
        for(int i = 2; i <= sqrt(n); i++){
            if(n % i == 0){
                count++;
            }
        }
        if(count == 0){
            System.out.println("số nguyên "+n+" là số nguyên tố.");
        }else{
            System.out.println("số nguyên "+n+" không là số nguyên tố.");
        }
//        if(false){
//            System.out.println("số nguyên "+n+"không là số nguyên tố.");
//        }else{
//            System.out.println("số nguyên "+n+" là số nguyên tố.");
//        }

        
    }
//    public static  boolean  kiemtranguyento(int n){
//        int a = (int) Math.sqrt(n);
//           for(int i =2; i<=a;i++){
//            if(n%i == 0){
//             return false;
//            }
//          }
//          return true;
//      }  
}
