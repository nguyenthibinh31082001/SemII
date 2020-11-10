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
public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào số dòng: ");
        int n= Integer.parseInt(sc.nextLine());
        System.out.printf("Nhập vào số cột: ");
        int m= Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][m];
        
        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập giá trị các phần tử mảng\n");
            System.out.printf("2. Hiển thị mảng vừa nhập theo ma trận\n");
            System.out.printf("3. In giá trị các phần từ nằm trên đường biên\n");
            System.out.printf("4. In giá trị và tổng các phần tử nằm trên đường chéo chính và đường chéo phụ\n");
            System.out.printf("5. Sắp xếp các cột trong mảng tăng dần\n");
            System.out.printf("6. Sắp xếp các hàng trong mảng tăng dần\n");
            System.out.printf("7. Thoát\n");
            
            System.out.printf("Chọn menu để thực hiện: ");
            int choose = Integer.parseInt(sc.nextLine());
            
            switch(choose){
                case 1:
                    System.out.println("Nhập giá trị các phần tử: ");
                    for (int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++){
                            System.out.printf("\tarr[%d][%d]= ",i,j);
                            arr[i][j] = Integer.parseInt(sc.nextLine());
                        }
                    }
                    break;
                case 2:
                    System.out.printf("Các phần tử của mảng là: \n");
                    for (int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++){
                            System.out.printf("%d\t", arr[i][j]);
                        }
                         System.out.printf("\n");
                    }
                    System.out.printf("\n");;
                    break;
                case 3:
                    System.out.printf("Các phần tử nằm trên dường biên là: ");
                    for (int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++){
                            if(i == 0 || j == 0 || i == (n-1) || j == (m-1)){
                                System.out.printf("%d ",arr[i][j]);
                            }
                        }
                    }
                    System.out.println(" ");
                    break;
                case 4:
                    int sum = 0, sum1 =0;
                    System.out.printf("\tCác phần tử nằm trên đường chéo chính là: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            // kiểm tra nếu i == j thì mới tính tổng
                            if (i == j) {
                                System.out.printf("%d ",arr[i][j]);
                                sum += arr[i][j];
                            }
                        }
                    }
                    System.out.println(" ");
                    System.out.printf("\tTổng các phần tử nằm trên đường chéo chính = " + sum);
                    System.out.println(" ");
                    
                    System.out.printf("\tCác phần tử nằm trên đường chéo phụ là: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if ((i+j) == (m-1)) {
                                System.out.printf("%d ",arr[i][j]);
                                sum1 += arr[i][j];
                            }
                        }
                    }
                    System.out.println(" ");
                    System.out.printf("\tTổng các phần tử nằm trên đường chéo phụ = " + sum);
                    System.out.println(" ");
                    System.out.printf("\tTổng các phần tử nằm trên đường chéo chính và đường chéo phụ = %d\n", sum+sum1);
                    break;
                case 5:
                    System.out.printf("\nSắp xếp các cột trong mảng tăng dần:\n");
                    BubbleSortA(arr,m,n);
                    XuatMaTran(arr,m,n);
                    break;
                case 6:
                    System.out.printf("\nSắp xếp các hàng trong mảng tăng dần:\n");
                    BubbleSortB(arr,m,n);
                    XuatMaTran(arr,m,n);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.printf("Vui lòng chọn từ 1-7!!!");
            } 
        }while (true);
    }
    public static void XuatMaTran(int [][] arr, int m, int n){
      for(int i = 0; i<m ; i++){
          System.out.println(" ");
          for(int j = 0; j<n ; j++)
            System.out.printf("%d\t",arr[i][j]);
      }
      System.out.println(" ");
    }
    /*Sap xep ma tran tang dan theo cot*/
    public static void BubbleSortA(int [][] arr, int m, int n){
        for(int k = 0; k<n ; k++)
            for(int i = 0; i<m-1 ; i++)
            for(int j = m-1; j>i ; j--)
            if(arr[j][k]<arr[j-1][k]){
                int temp = arr[j][k];
                arr[j][k] = arr[j-1][k];
                arr[j-1][k] = temp;
            }
    }
    /*Sap xep ma tran tang dan theo dong*/
    public static void BubbleSortB(int [][] arr, int m, int n)
    {
       for(int k = 0; k<m ; k++)
          for(int i = 0; i<n-1 ; i++)
          for(int j = n-1; j>i ; j--)
          if(arr[k][j]<arr[k][j-1])
          {
             int temp = arr[k][j];
             arr[k][j] = arr[k][j-1];
             arr[k][j-1] = temp;
          }
    }
}
