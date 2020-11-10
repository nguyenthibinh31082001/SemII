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
public class Bai14_Lab3 {
    public static void main(String[] args) {
        int choose;
        float Toan, Ly, Van;
        float Tong, TB=0;
        
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.printf("\t========MENU=======\n");
            System.out.printf("\t1. Nhập họ tên của bạn\n");
            System.out.printf("\t2. Nhập vào điểm toán, điểm lý, điểm văn\n");
            System.out.printf("\t3. Hiển thị điểm trung bình\n");
            System.out.printf("\t4. Hiển thị xếp loại theo điểm trung bình\n");
            System.out.printf("\t5. Thoát\n");
        
        System.out.printf("Mời bạn chọn menu:");
        choose = input.nextInt();
        switch(choose){
            case 1:
                String Ten;
                input.nextLine();
                System.out.printf("\tTên của bạn là:");
                Ten = input.nextLine();
                break;
            case 2:
                System.out.printf("\tNhập điểm toán:");
                Toan = input.nextFloat();
                System.out.printf("\tNhập điểm lý:");
                Ly = input.nextFloat();
                System.out.printf("\tNhập điểm văn:");
                Van = input.nextFloat();
                Tong = Toan + Ly + Van;
                TB = Tong/3;
                break;
            case 3:
                System.out.printf("Điểm trung bình là: %f\n", TB);
                break;
            case 4:
                if(TB<5){
                    System.out.println("\tXếp loại yếu");
                }else if(TB>=5 && TB<= 6){
                    System.out.println("\tXếp loại trung bình");
                }else if(TB>=7 && TB<= 8){
                    System.out.println("\tXếp loại khá");
                }else{
                    System.out.println("\tXếp loại giỏi");
                }
                break;
            case 5:
               System.exit(0);
               break;
            default:
                System.out.println("!!!Mời bạn chọn lại!!!");
                break;
            }
        
        }
    }
}
