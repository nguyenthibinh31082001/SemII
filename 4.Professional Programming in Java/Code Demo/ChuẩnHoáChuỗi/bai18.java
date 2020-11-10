/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai18 {
    

    
    public static void main(String[] args) {
        int n;
        String arr[]= new String[100];
        String S= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau S: ");
        S= in.nextLine();
        System.out.print("nhap so xau con n= ");        
        n= Integer.parseInt(in.nextLine());
        for(int i=1;i<=n;i++){
            System.out.print("nhap xau thu "+i+" : "); arr[i]=in.nextLine();
            
        }
        StringTokenizer s0= new StringTokenizer(S);
        int dem= s0.countTokens();
        String kq[]= new String[100];
        int k=1; int kt=0;
        while(s0.hasMoreTokens()){
            kq[k]=s0.nextToken();
            k++;
            
        }
        
        for(int i=1;i<k;i++){
            for(int j=1;j<=n;j++) if(arr[j].equals(kq[i])) {
                kt++; break;
            }
        }
        
        if(kt==dem) {
            System.out.println("ghep duoc");
            System.out.println("cac xau ghep thanh xau S la: ");
            for(int i=1;i<k;i++){
            for(int j=1;j<=n;j++) if(arr[j].equals(kq[i])) {
                System.out.print(j+" "); kt++; break;
            }
        }
        }
        else System.out.println("khong ghep duoc");
        
        
    }
    
}
