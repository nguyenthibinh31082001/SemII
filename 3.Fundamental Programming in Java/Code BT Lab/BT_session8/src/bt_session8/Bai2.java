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
public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập vào số sinh viên: ");
        int n= Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\tNhập sinh viên thứ " + i + ": ");
            arr[i] = scanner.nextLine();
        }
        System.out.println("Các sinh viên là: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("\t"+ arr[i] +"\n");
        }
    }
}
