/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai16 {
    
    public static void main(String[] args) {
        String s1= new String();
        String s2= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s1: ");
        s1=in.nextLine();
        System.out.println("nhap xau s2: ");
        s2= in.nextLine();
        int n=s2.length();
        String s= new String();
        String kt= new String();
        System.out.println("cac vi tri cua s2 trong s1 la: ");
        for(int i=0;i<s1.length()-n+1;i++){
            kt=s1.substring(i, i+n);
            if(kt.equals(s2)) System.out.print(i+"   ");
                   
        }
        
       s1= s1.replaceAll(s2, s);
        
        System.out.println("\n xau s1 sau khi xoa tat ca cac xau s2 la: ");
        System.out.println(s1);
        
       
    }
}
