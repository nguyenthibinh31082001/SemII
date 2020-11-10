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
public class Bai6_Lab6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập vào số phần tử cho mảng: ");
        int n= Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];

        System.out.println("Nhập giá trị các phần tử: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\tNhập phần tử thứ " + i + ": ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("Các phần tử của mảng là: ");
        for (int i = 0; i < n; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println(" ");
        
        Bai6_Lab6 shh = new Bai6_Lab6();
        System.out.print("Số hoàn hảo là: ");
        for(int i=0; i<n; i++){
            if (shh.checkSHH(arr[i])== true) {
            
            System.out.print(arr[i] + " ");
            }
        }
        
        System.out.println("");
        
    }
    boolean checkSHH(int n) {
        int sum = 0;
        for (int i = 1; i <= n/ 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            return true;
        }
        return false;
    }
    
}
