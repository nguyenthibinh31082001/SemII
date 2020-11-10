/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai7_Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, c;
        float p_vuong,nua_p,s_vuong;

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số nguyên a:");
        a = input.nextInt();
        System.out.print("Nhập số nguyên b:");
        b = input.nextInt();
        System.out.print("Nhập số nguyên c:");
        c = input.nextInt();
        
        if((a > 0 && b > 0 && c > 0) && ((a + b > c) || (a + c > b) || (b + c > a))){
            if((a==b) && (a!=c)){
                System.out.println("Đây là tam giác cân");
            }else if((a==b) && (b==c) && (c==a)){
                System.out.println("Đây là tam giác đều");
            }else if((a*a == b*b + c*c) || (b*b == a*a + c*c) || (c*c == b*b + a*a)){
                System.out.println("Đây là tam giác vuông");
               
            }else{
                System.out.println("Đây là tam giác thường");
            }
                nua_p = (a+b+c)/2;
                p_vuong = nua_p*2;
                s_vuong = (float) sqrt(nua_p*(nua_p-a)*(nua_p-b)*(nua_p-c));
                System.out.println("Chu vi tam giác vuông là:" + p_vuong);
                System.out.println("Diện tích tam giác vuông là:" + s_vuong);
        }else {
            System.out.println("a, b, c phải khác 0");
        }
        
    }
}
