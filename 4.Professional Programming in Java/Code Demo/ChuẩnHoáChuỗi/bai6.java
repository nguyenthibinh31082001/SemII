/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai6 {
    
    public static void main(String[] args) {
        String s0= new String();
        Scanner in = new Scanner(System.in);
        System.out.println("nhap xau s0: ");
        s0= in.nextLine();
        StringBuilder kq= new StringBuilder();
        StringTokenizer tg= new StringTokenizer(s0);
        while(tg.hasMoreTokens()){
            char arr[]= tg.nextToken().toCharArray();
            arr[0]= Character.toUpperCase(arr[0]);
            for(int i=1;i<arr.length;i++) arr[i]= Character.toLowerCase(arr[i]);
            kq.append(arr); kq.append(" ");
            
            
        }
        /*
         * while(tg.hasMoreTokens()){
           String s2= tg.nextToken();
           s2=s2.toLowerCase();
           String s3=s2.substring(0, 1);
           s2=s2.replaceFirst(s3, s3.toUpperCase());
            kq.append(s2); kq.append(" ");
            
        }
         */
        
        System.out.println("xau sau khi chuan hoa la: "+kq);
        
        
    }
}
