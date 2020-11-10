/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_session8;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai4 {
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
        
        System.out.printf("Các phần tử số chẵn của mảng là: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + "\t");
            }
        }
        System.out.println(" ");
    }
}
