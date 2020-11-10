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
public class Bai4_Lab6 {
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
        
        int min = arr[0];
        int max = arr[0];
        
        for(int i = 0; i < n; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất là: "+min);
        System.out.println("Giá trị lớn nhất là: "+max);
    }
    
}
