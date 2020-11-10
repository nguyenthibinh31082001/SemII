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
public class Bai5_Lab3 {
    public static void main(String[] args) {
        int n,i,j;
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập độ dài cạnh:");
        n = input.nextInt();
        
         for(i=1;i<=n;i++){
           for(j=1;j<=n-i;j++)
               System.out.printf(" ");/*in ra màn hình khoảng trắng đến vị trí thứ n-i */
           for(j=1;j<=2*i-1;j++){
             if (j==1||j==2*i-1)
                 System.out.printf("*");/*tiếp tục in ra màn hình * tại vị trí 1 và 2*i-1 */
             else 
                 System.out.printf(" ");
           }
           System.out.printf("\n"); /* chuyển xuống hàng tiếp theo */
           if (i==n-1){ /* đến hàng cuối cùng thì in ra cạnh đáy của tam giác*/
              for(j=1; j<=2*n-1;j++) 
                   System.out.printf("*");
                   System.out.println(" ");
              break ;
           }
        }
    }
}
