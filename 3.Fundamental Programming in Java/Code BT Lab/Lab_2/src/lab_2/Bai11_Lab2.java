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
public class Bai11_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String color;
       
        Scanner input = new Scanner(System.in);

        System.out.printf("Mời bạn chọn mã màu: ");
        color = input.nextLine();
        
        if(color.equals("r") || color.equals("R")){
            System.out.println("Red");
        }else if(color.equals("g")||color.equals("G")){
            System.out.println("Green");
        }else if(color.equals("b")||color.equals("B")){
            System.out.println("Blue");
        }else{
            System.out.println("Black");
        }
    }
}
