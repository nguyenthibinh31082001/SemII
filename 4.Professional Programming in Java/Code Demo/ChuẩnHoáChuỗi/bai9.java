/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai9 {
    
    public static void proper(String s){
        StringBuffer kq= new StringBuffer();
        StringTokenizer tg= new StringTokenizer(s);
        while(tg.hasMoreTokens()){
            String s1= tg.nextToken();
            s1=s1.toLowerCase();
            String s2= s1.substring(0, 1);
            s1= s1.replaceFirst(s2, s2.toUpperCase());
            kq.append(s1).append(" ");
        }
        System.out.println("xau chuyen ve dang proper la: "+kq);
    }
    public static void main(String[] args) {
        String s0=new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s0: ");
        s0= in.nextLine();
        proper(s0);
       
    }
    
}
