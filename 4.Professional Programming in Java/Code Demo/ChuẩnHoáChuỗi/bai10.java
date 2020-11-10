/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai10 {
    
    public static void main(String[] args) {
        String s0= new String();
        int max=1, n=0;
        int vt[]= new int[100];
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s0: ");
        s0= in.nextLine();
        String arr[]= new String[100];
        StringTokenizer s1= new StringTokenizer(s0);
        while(s1.hasMoreTokens()){
            arr[n]=s1.nextToken();
            n++;
        }
        for(int i=0;i<n;i++){
            if(arr[i].length()>max) max= arr[i].length();
        }
        System.out.print("tu lon nhat co do dai la: "+max); System.out.println("");
        System.out.print("vi tri cua cac tu co do dai max la: ");
        for(int i=0;i<n;i++) if(arr[i].length()==max) System.out.print(i+"  ,");
    }
}
