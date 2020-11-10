/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai15 {
    
    public static void main(String[] args) {
        String s= new String();
        String s1= new String();
        String s2= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s: ");
        s= in.nextLine();        
        System.out.println("nhap xau s1: ");
        s1= in.nextLine();
        System.out.println("nhap xau s2: ");
        s2= in.nextLine();
        int n=s1.length();
        char arr[]=s.toCharArray();
        int dem=0;
        String kt= new String();
        for(int i=1;i<s.length()-n;i++){
            kt=s.substring(i, i+n); if(kt.equals(s1)) dem++;
        }
        System.out.println("so lan xuat hien cua s1 trong s la: "+dem);
        System.out.println("xau s sau khi thay tat ca nhung xau s1 bang s2 la: ");
        s=s.replaceAll(s1, s2);
        System.out.println(s);
    }
}
