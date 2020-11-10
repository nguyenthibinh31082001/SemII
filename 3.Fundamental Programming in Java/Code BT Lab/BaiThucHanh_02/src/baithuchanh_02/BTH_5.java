/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh_02;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BTH_5 {
    public static void main(String[] args) {
        int n, temp, sum=0;

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số có 3 chữ số:");
        n = input.nextInt();
        
        if(n<100 || n>999) {
           System.out.println("Số bạn nhập không hợp lệ!. Nhấn Enter để nhập lại!");  
        }
        while(n != 0){
            temp = n%10;    
            if(temp % 2 == 0)
                sum += temp;
               n /= 10;
        }
        System.out.println("Tổng các số chẵn trong số nguyên là:" + sum);
    }
}
