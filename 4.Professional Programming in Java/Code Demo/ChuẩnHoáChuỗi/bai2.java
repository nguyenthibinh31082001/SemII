/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava.com.exam;

import java.util.*;
public class bai2 {
    
    
    public static void main(String[] args) {
        String s;
        Scanner in=new Scanner(System.in);
        System.out.println("nhap vao mot xau: ");
        s= in.nextLine();       
        StringTokenizer s1= new StringTokenizer(s);
	System.out.println("So cac tu trong xau la: "+s1.countTokens());
}
}


