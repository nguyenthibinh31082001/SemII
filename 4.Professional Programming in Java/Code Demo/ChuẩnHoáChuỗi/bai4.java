/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai4 {
    
    
    
    public static StringBuilder tong(String a, String b){
        StringBuilder c= new StringBuilder();
        int la=a.length();
        int lb=b.length();
        char a1[]= a.toCharArray();
        char b1[]= b.toCharArray();
        int kq[]= new int[100];
        char a2[]= new char[100];
        char b2[]= new char[100];
        int n=(la>lb)?la:lb;
        for(int i=n-1;i>=0;i--){ //dua cac so ve cung hang don vi, chuc, tram...
            if((i+la-n)>=0) a2[i]=a1[i+la-n];
            else a2[i]= 48;
            if((i+lb-n)>=0) b2[i]=b1[i+lb-n];
            else b2[i]=48;
        }        
        for(int i=0;i<n;i++) kq[i]= ((int)b2[i]+ (int)a2[i]- 96);
        for(int i=n-1;i>=1;i--) if(kq[i]>=10){
                kq[i]=kq[i]%10;
                kq[i-1]++;
            } 
        for(int i=0;i<n;i++) c.append(kq[i]);
        return c;
    }    
    
    public static StringBuilder hieu(String a, String b){
        StringBuilder c= new StringBuilder();
        int la=a.length();
        int lb=b.length();
        char a1[]= a.toCharArray();
        char b1[]= b.toCharArray();
        int kq[]= new int[100];
        char a2[]= new char[100];
        char b2[]= new char[100];
        int n=(la>lb)?la:lb;
        for(int i=n-1;i>=0;i--){
            if((i+la-n)>=0) a2[i]=a1[i+la-n];
            else a2[i]= 48;
            if((i+lb-n)>=0) b2[i]=b1[i+lb-n];
            else b2[i]=48;
        }
        
        for(int i=0;i<n;i++) kq[i]= ((int)a2[i]- (int)b2[i]);
        for(int i=n-1;i>=1;i--) if(kq[i]<0){
                kq[i]=kq[i]+10;
                kq[i-1]--;
            } 
        if(kq[0]>=0){
            for(int i=0;i<n;i++) c.append(kq[i]);
            return c;
        }
        
        else {
            for(int i=0;i<n;i++) kq[i]= ((int)b2[i]- (int)a2[i]);
            for(int i=n-1;i>=1;i--) if(kq[i]<0){
                kq[i]=kq[i]+10;
                kq[i-1]--;
            }
        }
        c.append("-");
        for(int i=0;i<n;i++) c.append(kq[i]);
        return c;
        
    }    
    
        public static StringBuilder tich(String a, String b){
        StringBuilder c= new StringBuilder();
        int la=a.length();
        int lb=b.length();
        char a1[]= a.toCharArray();
        char b1[]= b.toCharArray();
        int kq[]= new int[100];
        int c2[]= new int[100];
        char a2[]= new char[100];
        char b2[]= new char[100];
        int n=(la>lb)?la:lb;
        for(int i=n-1;i>=0;i--){
            if((i+la-n)>=0) a2[i]=a1[i+la-n];
            else a2[i]= 48;
            if((i+lb-n)>=0) b2[i]=b1[i+lb-n];
            else b2[i]=48;
        }
        int k=1;
        for(int i=n-1;i>=0;i--){
             for(int j=0;j<n;j++) {
                c2[j]= (int)(b2[i]-48)*(int)(a2[j]-48)*k;
                kq[j]=kq[j]+c2[j];
            }
             k=k*10;
        }
        for(int i=n-1;i>0;i--) if(kq[i]>=10){            
            kq[i-1]=kq[i-1]+ kq[i]/10;
            kq[i]= kq[i]%10;
            
        }
        
        
        for(int i=0;i<n;i++) c.append(kq[i]);
        return c;
        
        
    }    
    
    
     
    
    public static void main(String[] args) {
        String a= new String();
        String b= new String();        
        Scanner in= new Scanner(System.in);
        System.out.print("nhap so a: ");
        a= in.nextLine();
        System.out.print("nhap so b: ");
        b=in.nextLine();
        System.out.println("tong 2 so a va b la: "+tong(a,b));
        System.out.println("hieu 2 so a va b la: "+hieu(a,b));
        System.out.println("tich 2 so a va b la: "+tich(a,b));
        System.out.println("");
        
    }
    
}
