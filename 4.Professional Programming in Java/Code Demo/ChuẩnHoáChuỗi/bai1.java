/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai1 {
    
    public static void chuyendoicoso(int n, int b){
        StringBuffer kq= new StringBuffer();
        int du=0;
        while(n>0){
            du=n%b;
            n=n/b;
            if(du<10) kq.append(du);  
            else kq.append((char)('A'+du-10));    
        }
        System.out.println(kq); 
    }
    
    public static void main(String[] args) {
        int n,b;
        Scanner in=new Scanner(System.in);
        System.out.print("nhap n: ");
        n= in.nextInt();
        System.out.print("nhap b: ");
        b=in.nextInt();
        System.out.println("sau khi chuyen n sang he co so "+b+" la:");
        chuyendoicoso(n,b);
        
    }
}
