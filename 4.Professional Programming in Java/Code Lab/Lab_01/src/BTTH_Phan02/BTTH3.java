/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class BTTH3 {
    String regExp = "^C[0-9]{4}[GHIKML]$";
    
    public void validateName() {
        do {
            System.out.printf("Nhập tên của lớp: ");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if (matcher.matches()) {
                System.err.println("Tên hợp lệ");
            break;
            } else {
                System.err.println("Tên sai, nhập lại!");
            }
        } while (true);
    }
    public static void main(String[] args) {
        BTTH3 bai3 = new BTTH3();
        bai3.validateName();
    }
}
