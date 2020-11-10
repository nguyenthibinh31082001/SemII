/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai3 {
     public static int thuannghich(int n){
         StringBuilder s= new StringBuilder();
         String str= ""+n;
         s.append(str);
         String kt= ""+s.reverse();
         if(str.equals(kt)) return 1;
         return 0;
               }
    
   
     public static void main(String[] args) {
         int n;
         Scanner in = new Scanner(System.in);
         System.out.print("nhap so can kiem tra: ");
         n=in.nextInt();
         if(thuannghich(n)==1) System.out.println("n la so thuan nghich");
         else System.out.println(" n khong la so thuan nghich");
    }
    
}
