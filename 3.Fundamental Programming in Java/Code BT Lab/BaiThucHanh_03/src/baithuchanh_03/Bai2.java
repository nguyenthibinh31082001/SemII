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
public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào số phần tử cho mảng: ");
        int n= Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        
        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập giá trị các phần tử mảng\n");
            System.out.printf("2. Hiển thị mảng vừa nhập\n");
            System.out.printf("3. In ra phần tử có giá trị lớn nhất, nhỏ nhất\n");
            System.out.printf("4. In ra phần tử có giá trị là số nguyên tố\n");
            System.out.printf("5. In ra phần tử có giá trị là số hoàn hảo\n");
            System.out.printf("6. Sắp xếp mảng giảm dần\n");
            System.out.printf("7. Thoát\n");
            
            System.out.printf("Chọn menu để thực hiện: ");
            int choose = Integer.parseInt(sc.nextLine());
            
            switch(choose){
                case 1:
                    System.out.println("Nhập giá trị các phần tử: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print("\tNhập phần tử thứ " + i + ": ");
                        arr[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.printf("Các phần tử của mảng là: ");
                    for (int i = 0; i < n; i++) {
                        System.out.printf(arr[i] + "\t");
                    }
                    System.out.println(" ");
                    break;
                case 3:
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
                    System.out.println("\tGiá trị nhỏ nhất là: "+min);
                    System.out.println("\tGiá trị lớn nhất là: "+max);
                    break;
                case 4:
                    System.out.printf("\tCác số nguyên tố trong mảng là: ");
                    for (int i = 0; i < arr.length; i++) {
                        if (CheckSNT(arr[i])) {
                            System.out.print(arr[i] + " ");
                        }
                    }
                    System.out.println(" ");
                    break;
                case 5:
                    Bai2 shh = new Bai2();
                    System.out.print("\tSố hoàn hảo là: ");
                    for (int i = 0; i < n; i++) {
                        if (shh.checkSHH(arr[i]) == true) {
                            System.out.print(arr[i] + " ");
                        }
                    }
                    System.out.println("");
                    break;
                case 6:
                    GiamDan(arr);
                    System.out.printf("\tMảng được sắp xếp giảm dần là: ");
                     for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println(" ");
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.printf("Vui lòng chọn từ 1-7!!!");
            } 
        }while (true);
    }
    public static boolean CheckSNT(int n) {
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
     public static void GiamDan(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public boolean checkSHH(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
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
