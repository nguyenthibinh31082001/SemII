/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_02;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai2 {
    public static void main(String[] args) {
        char KyTu;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một chữ cái: ");
	KyTu = sc.next().charAt(0);
        
        switch(KyTu) {
            case 'o':
            case 'O':
            case 'u':
            case 'U':
            case 'i':
            case 'I':
            case 'a':
            case 'A':
            case 'e':
            case 'E':
                 System.out.printf("Chữ "+KyTu+ " là nguyên âm\n");
                break;
            default:
                System.out.printf("Chữ "+KyTu+ " không là nguyên âm\n");
        }
    }
}
