/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_06;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai5_Lab6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập vào số phần tử cho mảng: ");
        int n= Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];

        System.out.println("Nhập giá trị các phần tử: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\tNhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Các phần tử của mảng là: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("\t"+arr[i] + "\n");
        }
        System.out.println(" ");
        
        System.out.printf("Các số nguyên tố trong mảng là: ");
        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(" ");
    }
    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
        
    }
}
