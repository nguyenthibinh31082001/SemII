/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai8 {
    
    public static void chuyendoi(String s){
        StringTokenizer tg= new StringTokenizer(s);
        StringBuffer kq= new StringBuffer();
        String s1[]= new String[10];
        int i=1;
        while(tg.hasMoreTokens()){
            s1[i]= tg.nextToken();
            i++;
            
            
        }
        kq.append(s1[3]).append("  "); kq.append(s1[1]).append("  "); kq.append(s1[2]).append("  ");
        System.out.println(kq);
    }
    public static void main(String[] args) {
        String s0= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau ho ten: ");
        s0= in.nextLine();
        chuyendoi(s0);
        
    }
    
}
