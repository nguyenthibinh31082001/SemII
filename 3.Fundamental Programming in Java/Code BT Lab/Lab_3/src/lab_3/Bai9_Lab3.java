/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai9_Lab3 {
      public static void main(String[] args) {
        int choose;
        
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.printf("Cuối tuần bạn muốn làm gì?\n");
            System.out.printf("\t1. Đi học Java\n");
            System.out.printf("\t2. Đi chơi công viên ngắm gấu\n");
            System.out.printf("\t3. Đi về nhà nghỉ\n");
            System.out.printf("\t4. Ra sông Hồng tắm tiên\n");
            System.out.printf("\t5. Ngủ cả ngày\n");
            System.out.printf("\t6. Thoát\n");
        
        System.out.printf("Mời bạn chọn menu:");
        choose = input.nextInt();
        
        switch(choose){
            case 1:
                System.out.printf("\t1. Đi học Java");
                break;
            case 2:
                System.out.printf("\t2. Đi chơi công viên ngắm gấu");
                break;
            case 3:
                System.out.printf("\t3. Đi về nhà nghỉ\n");
                break;
            case 4:
                System.out.printf("\t4. Ra sông Hồng tắm tiên\n");
                break;
            case 5:
               System.out.printf("\t5. Ngủ cả ngày\n");
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
