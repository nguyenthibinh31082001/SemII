/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_01;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai2 {
    public static void main(String[] args) {
        String ten;
        float toan, ly, hoa;
        char hanhkiem;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập tên sinh viên: ");
        ten = sc.nextLine();
        System.out.print("Nhập điểm toán: ");
        toan = sc.nextFloat();
        System.out.print("Nhập điểm lý: ");
        ly = sc.nextFloat();
        System.out.print("Nhập điểm hóa: ");
        hoa = sc.nextFloat();
        System.out.print("Nhập hạnh kiểm: ");
        hanhkiem = sc.next().charAt(0);
        
        System.out.println("===SINH VIÊN: ==="+ten);
        System.out.println("\tĐiểm toán: "+toan);
        System.out.println("\tĐiểm lý: "+ly);
        System.out.println("\tĐiểm hóa: " +hoa);
        System.out.println("\tĐiểm trung bình là: "+((toan+toan+ly+hoa)/4));
        System.out.printf("\tHạnh kiểm: ");
        
        if(hanhkiem == 'y' || hanhkiem == 'Y'){
            System.out.println("Yếu");
        }else if(hanhkiem == 'b' || hanhkiem == 'B'){
            System.out.println("Trung bình");
        }else if(hanhkiem == 't' || hanhkiem == 'T'){
            System.out.println("Tốt");
        }else{
            System.out.println("Phải nhập hạnh kiểm theo Y-B-T!!!");
        }
    }
}
