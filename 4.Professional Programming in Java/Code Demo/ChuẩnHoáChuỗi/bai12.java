/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai12 {
    
    public static void chuanhoa(String s){
        StringTokenizer s1= new StringTokenizer(s);
        StringBuffer kq= new StringBuffer();
        while(s1.hasMoreTokens()){
            String s2= s1.nextToken();
            s2=s2.toLowerCase();
            String s3= s2.substring(0, 1);
            s2=s2.replaceFirst(s3, s3.toUpperCase());
            kq.append(s2).append(" ");
            
        }
        System.out.println("ho ten xau khi chuan hoa la: "+kq);
    }
    public static void main(String[] args) {
        String s0= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        s0= in.nextLine();
        chuanhoa(s0);
    }
}
