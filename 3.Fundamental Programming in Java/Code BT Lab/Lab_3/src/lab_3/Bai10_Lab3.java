/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai10_Lab3 {
    public static void main(String[] args) {
        int n;
        int sum = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Nhập số n:");
        n = input.nextInt();
        
        if(check(n) )
            System.out.printf("%d là số hoàn hảo.\n",n);
        else
            System.out.printf("%d không phải là số hoàn hảo.\n",n);
        return;
    }
    public static boolean check(int n){
        int sum = 0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0) 
                sum+=i;
        }
        if(sum==n) return true; 
        return false;
    }
}
