/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh_02;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BTH_6 {
    public static void main(String[] args) {
        int choose;
        int n, q=0;
        
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.printf("\t========TAM GIÁC=======\n");
            System.out.printf("\t1. Tam giác vuông đặc\n");
            System.out.printf("\t2. Tam giác vuông đặc ngược\n");
            System.out.printf("\t3. Tam giác cân đặc\n");
            System.out.printf("\t4. Thoát\n");
        
        System.out.printf("Mời bạn chọn hình:");
        choose = input.nextInt();
        switch(choose){
            case 1:
                System.out.printf("\tNhập độ dài cạnh tam giác:");
                n = input.nextInt();
                for(;n<=0;){
                    System.out.printf("Nhập n > 0 \nNhập lại n: ");
                    n = input.nextInt();
                }
                for(int i = 1; i <= n; i++){
                    for(int k = 1; k <= i; k++){
                        System.out.printf("*");            
                    }
                    System.out.printf("\n");
                }
                break;
            case 2:
                System.out.printf("\tNhập độ dài cạnh tam giác:");
                n = input.nextInt();
                for(;n<=0;){
                    System.out.printf("Nhập n > 0 \nNhập lại n: ");
                    n = input.nextInt();
                }
                for(int i = n; i >= 1; i--) {
                    for(int j = 1; j <= i; j++)
                       System.out.printf("$ ");

                    System.out.printf("\n");
                 }
                break;
            case 3:
                System.out.printf("\tNhập chiều cao tam giác cân:");
                n = input.nextInt();
                for(;n<=0;){
                    System.out.printf("Nhập n > 0 \nNhập lại n: ");
                    n = input.nextInt();
                }
                while (n > 0){
                    for (int i = 1; i<n; i++)
                        System.out.printf("%c", ' ');
                    for (int k = 0; k <= q; k ++)
                        System.out.printf("%c", '*');
                    n -- ;
                    q += 2 ;
                    System.out.printf("\n");
                }
                break;
            case 4:
               System.exit(0);
               break;
            default:
                System.out.println("!!!Mời bạn chọn lại!!!");
                break;
            }
        
        }
    }
}
