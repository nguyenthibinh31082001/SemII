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
public class Bai3 {
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
        
        int tong = 0;
        int tg;
        System.out.printf("Các số nguyên tố của mảng là: ");
        for (int i=0;i<n;i++) {
            if (check(arr[i])  )
                System.out.print(arr[i] + " ");
        }
        System.out.println("");
       System.out.printf("Tổng các phần tử chia hết cho 3 là: ");
            
        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0) {
//                System.out.print(arr[i] + "\t\n");
                tong = tong + arr[i];
                 System.out.print(tong);
            }
        }
        System.out.println("");
    }
    public static boolean check(int n){
        if(n<=1) return false;
        for (int i = 2;i<= Math.sqrt(n); i++)
            if(n%i==0) return false;
        //Nếu không chia hết thì trả về true
        return true;
    }
//    public static int tinhTong(int arr[], int n){
//        int i;
//        int tong=0;
//        for(i=0;i<n;i++){
//            if(arr[i]%3==0){
//                tong=tong+arr[i];
//            }
//        }
//    return tong;
//    }
}
