/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai11 {
    
    public static void main(String[] args) {
        String s0= new String();
        int na=0,pa=0,ka=0,so=0;
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s0: ");
        s0= in.nextLine();
        char arr[] = s0.toCharArray();
        for(int i=0;i<arr.length;i++){
            int n= (int)arr[i];
            if((32<=n&&n<=47)||(58<=n&&n<=64)||(91<+n&&n<=96)||(123<=n&&n<=126)) ka++;
            if(48<=n&&n<=57) so++;
            if(n==65||n==69||n==73||n==79||n==85||n==97||n==101||n==105||n==111||n==117) na++;
                 
            }
        pa=arr.length-ka-na-so;
                
            
        
        System.out.println("so cac ki tu la nguyen am la: "+na);
        System.out.println("so cac ki tu la phu am la: "+pa);
        System.out.println("so cac ki tu la chu so la: "+so);
        System.out.println("so cac ki tu khac la: "+ka);
    }
}
