/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai3_Lab3 {
    public static void main(String[] args) {
        int a, b ;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập số nguyên a:");
        a = input.nextInt();
        System.out.printf("Nhập số nguyên b:");
        b = input.nextInt();
        
        System.out.println("UCLN là:"+UCLN(a, b));
        System.out.println("BCNN là:"+BCNN(a, b));
    }
    public static int UCLN(int a, int b) {
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
            return a;
        }
    public static int BCNN(int a, int b) {
        return (a * b) / UCLN(a, b);
    }
}
