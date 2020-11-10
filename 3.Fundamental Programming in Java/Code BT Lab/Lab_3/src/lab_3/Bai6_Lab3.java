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
public class Bai6_Lab3 {
    public static void main(String[] args) {
        int n,m,i,j;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập chiều dài hcn:");
        n = input.nextInt();
        System.out.printf("Nhập chiều rộng hcn:");
        m = input.nextInt();
        
        for(;n<=0 || m <= 0;){
            if(n <= 0){
                System.out.printf("Chiều dài phải lớn hơn 0 \nNhập lại chiều dài: ");
                n = input.nextInt();
            }
            if(m <= 0){
                System.out.printf("Chiều rộng phải lớn hơn 0 \nNhập lại chiều rộng: ");
                m = input.nextInt();
            }
        }    
        for( i = 1; i <= n; i++){
            for( j = 1 ; j <= m; j++){
                if(i == 1 || j == 1 || i == n || j == m){
                    System.out.printf("*");
                }
                else{
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }
    }
}
