/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai13_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float toan, ly, hoa, tong;
       
        Scanner input = new Scanner(System.in);

        System.out.printf("Nhập điểm toán: ");
        toan = input.nextFloat();
        System.out.printf("Nhập điểm lý: ");
        ly = input.nextFloat();
        System.out.printf("Nhập điểm hóa: ");
        hoa = input.nextFloat();
        
        tong = toan + ly + hoa;
        if((tong >= 15) && (toan>=4) && (ly>=4) && (hoa>=4)){
            System.out.println("Đậu");
            if((toan>=5) && (ly>=5) && (hoa>=5)){
                System.out.println("Học đều các môn");
            }else{
                System.out.println("Học chưa đều các môn");
            }
        }else{
            System.out.println("Thi hỏng");
        }
    }
}
