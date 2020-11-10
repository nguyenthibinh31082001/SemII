/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BTTH1 {
    public static void main(String[] args) {
        BTTH1 btth1 = new BTTH1();
        btth1.input();
        
    }
    public void input(){
        StringBuilder dsSinhVien = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            System.out.printf("Mời nhập sinh viên thứ %d: ",(i+1));
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dsSinhVien.append(str + "#");
        }
        
        System.out.println("Danh sách sinh viên:");
        String temp = dsSinhVien.toString();
        String arrSv[] = temp.split("#");
        for (int i = 0; i < arrSv.length; i++) {
            System.out.println("\t"+(i + 1) + ". " + arrSv[i]);
        }
    }
}
