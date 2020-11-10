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
public class Bai5_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String TenSv, MaSv;
        float mark_LT, mark_TH, avg_TL_TH;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Nhập tên sinh viên:");
        TenSv = input.nextLine();
        
        System.out.print("Nhập mã sinh viên:"); 
        MaSv = input.nextLine();
        
        System.out.print("Nhập điểm lý thuyết:");
        mark_LT = input.nextFloat();
        
        System.out.print("Nhập điểm thực hành:");
        mark_TH = input.nextFloat();
        
        avg_TL_TH = (mark_LT+mark_TH)/2;
//        System.out.print(+ avg_TL_TH);
        if(avg_TL_TH < 4){
            System.out.println("Sinh viên phải học lại.");
        }else if(mark_LT < 4){
            System.out.println("Thi lại lý thuyết.");
        }else if(mark_TH < 4){
            System.out.println("Thi lại thực hành.");
        }else if(4 <= avg_TL_TH && avg_TL_TH <= 7){
            System.out.println("Sinh viên đạt môn Java");
        }else if (avg_TL_TH > 7){
            System.out.println("Sinh viên xuất sắc môn Java.");
        }
    }
}
