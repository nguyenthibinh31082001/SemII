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
public class BTH_2 {
    
    public static void main(String[] args) {
        int thang, nam;
       

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập tháng:");
        thang = input.nextInt();
        System.out.print("Nhập năm:");
        nam = input.nextInt();
        
        switch(thang){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12 :
                System.out.printf("Tháng %d có 31 ngày\n", thang);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.printf("Tháng %d có 30 ngày\n", thang);
                 break;
            case 2:
               if (nam % 4 == 0) {
                    if (nam % 100 == 0) {
                        if (nam % 400 == 0) {
                            /*
                             *  Năm nhuận là năm chia hết cho 4.
                             *  Nếu năm đó chia hết cho 100 thì cũng phải chia hết cho 400.
                             */
                            System.out.println("Năm " + nam + " là năm nhuận nên tháng 2 có 29 ngày.");
                        } else {
                            // Năm chia hết cho 4 và 100 nhưng không chia hết cho 400 thì không là năm nhuận.
                            System.out.println("Năm " + nam + " không phải là năm nhuận nên nên tháng 2 có 28 ngày.");
                        }
                    } else {
                        // Năm chia hết cho 4 nhưng không chia hết cho 100 thì là năm nhuận.
                        System.out.println("Năm " + nam + " là năm nhuận nên nên tháng 2 có 29 ngày.");
                    }
                } else {
                    // Năm không chia hết cho 4 thì không phải là năm nhuận.
                    System.out.println("Năm " + nam + " không phải là năm nhuận nên nên tháng 2 có 28 ngày.");
                }
            } 
        }
}
