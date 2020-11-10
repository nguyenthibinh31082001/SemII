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
public class BTH_8 {
    public static void main(String[] args) {
        int choose;
        int n, q=0;
        
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.printf("\t========MENU=======\n");
            System.out.printf("\t1. Nhập 1 số nguyên n\n");
            System.out.printf("\t2. Chuyển số nguyên sang số nhị phân\n");
            System.out.printf("\t3. Chuyển số nguyên sang số bát phân\n");
            System.out.printf("\t4. chuyển số nguyên sang số thập phân\n");
            System.out.printf("\t5. chuyển số nguyên sang số thập lục phân\n");
            System.out.printf("\t6. Thoát\n");
        
        System.out.printf("Mời bạn chọn:");
        choose = input.nextInt();
        switch(choose){
            case 1:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                break;
            case 2:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số nhị phân của "+n+" = " + Integer.toString(n, 2));
                break;
            case 3:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số bát phân của "+n+" = " + Integer.toString(n, 8));
                break;
            case 4:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số thập phân của "+n+" = " + Integer.toString(n, 10));
                break;
            case 5:
                System.out.printf("Nhập số nguyên n:");
                n = input.nextInt();
                System.out.println("Số thập lục phân của "+n+" = " + Integer.toString(n, 16));
                break;
            case 6:
               System.exit(0);
               break;
            default:
                System.out.println("!!!Mời bạn chọn lại!!!");
                break;
            }
        
        }
    }
}
