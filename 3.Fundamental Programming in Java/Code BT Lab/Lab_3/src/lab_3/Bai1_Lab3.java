/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3;

/**
 *
 * @author ADMIN
 */
public class Bai1_Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i, sum = 0;
        
        for(i = 1; i <= 100; i++){
            sum = sum + i;
        }
        System.out.println("Tổng từ 1 đến 100 là:" + sum);
        return;
    }
    
}
