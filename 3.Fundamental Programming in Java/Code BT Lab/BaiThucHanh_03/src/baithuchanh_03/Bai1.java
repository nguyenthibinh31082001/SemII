/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh_03;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào số phần tử cho mảng: ");
        int n= Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        
        System.out.println("Nhập giá trị các phần tử: ");
            for (int i = 0; i < n; i++) {
                System.out.print("\tNhập phần tử thứ " + i + ": ");
                arr[i] = Integer.parseInt(sc.nextLine());
        }
        
        System.out.printf("Các phần tử của mảng là: ");
        for (int i = 0; i < n; i++) {
            System.out.printf(arr[i] + "\t");
        }
        System.out.println(" ");
    }
    
}
