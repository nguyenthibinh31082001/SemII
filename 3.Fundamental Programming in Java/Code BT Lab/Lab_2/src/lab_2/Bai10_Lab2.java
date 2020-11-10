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
public class Bai10_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String may, nguoi;
       

        Scanner input = new Scanner(System.in);

        System.out.printf("Chào mừng bạn dã đến với trò chơi Kéo Búa Giấy!!!\n");
        System.out.printf("Mời bạn chọn: ");
        nguoi = input.nextLine();
        System.out.printf("Mời máy chọn: ");
        may = input.nextLine();
        
        switch(nguoi){
            case "keo":
                switch(may){
                    case "keo":
                        System.out.println("Hòa");
                        break;
                    case "giay":
                        System.out.println("Bạn đã thắng");
                        break;
                    case "bua":
                        System.out.println("Bạn đã thua");
                        break;
                    default:
                        System.out.println("Máy đã nhập sai");
                }
                break;
            case "bua":
                switch(may){
                    case "bua":
                        System.out.println("Hòa");
                        break;
                    case "giay":
                        System.out.println("Bạn đã thua");
                        break;
                    case "keo":
                        System.out.println("Bạn đã thắng");
                        break;
                    default:
                        System.out.println("Máy đã nhập sai");  
                }
            break;
            case "giay":
                switch(may){
                    case "giay":
                        System.out.println("Hòa");
                        break;
                    case "bua":
                        System.out.println("Bạn đã thắng");
                        break;
                    case "keo":
                        System.out.println("Bạn đã thua");
                        break;
                    default:
                        System.out.println("Máy đã nhập sai");  
                }
            break;
           default:
                System.out.println("Bạn đã nhập sai");
        }
    }
}
