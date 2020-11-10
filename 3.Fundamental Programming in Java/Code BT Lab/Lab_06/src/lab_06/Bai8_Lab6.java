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
public class Bai8_Lab6 {
	
    private static void nhap_mang(int []A, int n) {
        Scanner scn = new Scanner(System.in);
        for(int i=0; i<n; i++) {
                System.out.print("Phần tử mảng "+i+": ");
                A[i] = scn.nextInt();
        }
    }
	
    private static void xuat_mang(int []A, int n) {
        for(int i=0; i<n; i++) {
                System.out.println("A[ "+i+" ]: "+A[i]);
        }
    }
	
    private static void hoan_vi(int []A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
	
    private static void sap_xep_chon(int []A, int n) {
        for(int i=0; i<n-1; i++) {
            int minArr = i;
            for(int j=i+1; j<n; j++) {
                if(A[minArr]>A[j]) {
                        minArr = j;
                }
            }
            if(i!=minArr)
                hoan_vi(A, minArr, i);
        }
    }

    public static void main(String[] args) {
        int []A;
        int n=0;
        Scanner scn = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử mảng: ");
        n = scn.nextInt();
        A = new int[n];
        nhap_mang(A, n);
        System.out.println("Mảng sau khi sắp xếp (Selection Sort)");
        sap_xep_chon(A, n);
        xuat_mang(A, n);
    }
}
