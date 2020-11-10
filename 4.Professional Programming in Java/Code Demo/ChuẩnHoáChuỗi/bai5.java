/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stackjava.com.exam;

import java.util.*;
public class bai5 {
   
    public static void main(String[] args) {
         String s0= new String();
         int b[]= new int[1000];
         int dx[]= new int[1000];
         Scanner in= new Scanner(System.in);
         System.out.println("nhap xau s0: ");
         s0=in.nextLine();         
         char arr[]= s0.toCharArray();
         for(int i=0;i<arr.length;i++)  b[arr[i]]++;        
         for(int i=0;i<arr.length;i++){
             if(dx[(int)arr[i]]==0) System.out.print("so lan xuat hien cua: '"+arr[i]+"' la: "+b[arr[i]]+"\n");
             dx[(int)arr[i]]=1;
         }
    }

}
