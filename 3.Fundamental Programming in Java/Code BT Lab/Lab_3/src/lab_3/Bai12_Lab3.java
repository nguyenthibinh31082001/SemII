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
public class Bai12_Lab3 {
    public static void main(String[] args) {
//        int n,m = 0;
//        
        Scanner input = new Scanner(System.in);
//        
//        System.out.printf("Nhập số n:");
//        n = input.nextInt();
        
//        for (int i = 1; i < n; i++) {
//            System.out.print(fibonacci(i) + " ");
//        }
        int n;
        int x=1,y=1,z=2;
        System.out.printf("Nhập số n:");
        n = input.nextInt();
            
            if(n<2){ 
                if(n>0){
                   System.out.printf(x+ " ");
                }
                return;
            }
            System.out.printf(x+ " "+y);
//            cout<<x<<" "<<y<<" ";
            for(int i=n-2;i>0;--i){
                System.out.printf(z+ " ");
                x=y;
                y=z;
                z+=x;
            }
            return ;
        
    }  
//    private static int fibonacci(int m) {
//        if (m < 0) {
//            return -1;
//        } else if (m == 0 || m == 1) {
//            return m;
//        } else {
//            return fibonacci(m - 2) + fibonacci(m - 1);
//        }
//        
//    }
    

}
