/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai14 {
    
//    public static void sapxep(String s){
//        String tg= new String();
//        StringTokenizer s1= new StringTokenizer(s);
//        int n= s1.countTokens();
//        String arr[]= new String[n];
//        int i=0;
//        while(s1.hasMoreTokens()){
//            arr[i]= s1.nextToken();
//            i++;
//            
//        }
//        for(int k=0;k<n-1;k++)
//            for(int j=k+1;j<n;j++){
//                if(arr[k].compareTo(arr[j])>0) {
//                    tg=arr[k];
//                    arr[k]=arr[j];
//                    arr[j]=tg;
//                }
//            }
//      
//       for(int j=0;j<n;j++) System.out.print(arr[j]+"  ");
//        System.out.println("");
//        
//        
//    }
      public static void sapxep(String s){
        StringTokenizer s1= new StringTokenizer(s);
        ArrayList<String> arr= new ArrayList<>();
        int n= s1.countTokens();
        int i=0;
        while(s1.hasMoreTokens()){
            String s2=s1.nextToken();
            arr.add(s2);
            
        }
        Collections.sort(arr);
          System.out.println(arr.toString());
    }
    public static void main(String[] args) {
        String s0= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("nhap xau s0: ");
        s0= in.nextLine();
        sapxep(s0);
    }
}
