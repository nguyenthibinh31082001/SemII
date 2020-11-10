/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_06;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Bai2_Lab6 {
    public static void main(String[] args) {
        Random rd = new Random();   
        int number1 = rd.nextInt(9);   
        System.out.println("Số vừa được sinh ra là " + number1);
    }
}
