/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai17 {
    
    public static boolean ktra(String []arr, int i, int n){ //kiem tra sau xau arr[i] con xau nao giong no khong
        for(int j=i+1;j<=n;j++) if(arr[i].equals(arr[j])) return false;
        return true;        
    }
    
    public static int demsolan(String []arr, int i, int n){ 
        int k=0;
        for(int j=i;j>=1;j--) if(arr[j].equals(arr[i])) k++;
        return k;   
    }
    
    public static void main(String[] args) {
        String s0 = new String();
        String s2= "ketthuc";
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s0: ");
        s0= in.nextLine();
        StringTokenizer s1= new StringTokenizer(s0);
        int sotu= s1.countTokens();
        String arr[]= new String[100];
        int i=1, dem=0;
        while(s1.hasMoreTokens()){
            arr[i]= s1.nextToken();
            if(arr[i].equals(s2)) break;
            i++;
        }
        i--;
        for(int j=1;j<i;j++)
            for(int k=j+1;k<=i;k++){
                if(arr[j].equals(arr[k])) dem++;
            }
        System.out.println("so cac tu la: "+i);
        System.out.println("so tu khac nhau cua xau la: "+(i-dem));
        System.out.println("cac tu khac nhau la: ");
        for(int j=1;j<=i;j++) if(ktra(arr, j, i)) 
            System.out.println("tu '"+arr[j]+"' xuat hien: "+demsolan(arr,j,i)+" lan");
       
    }
}
