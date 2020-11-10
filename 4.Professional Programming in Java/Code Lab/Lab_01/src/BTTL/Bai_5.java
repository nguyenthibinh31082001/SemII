/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Bai_5 {
    private static final String numberPhoneHN = "043[0-9]{6}$";
    public static void main(String[] args) {
        do {
            System.out.printf("Nhập số điện thoại Hà Nội: ");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(numberPhoneHN);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if (matcher.matches()) {
                System.err.println("Số điện thoại Hà Nội hợp lệ!");
                break;
            } else {
                System.err.println("Số điện thoại Hà Nội không hợp lệ, nhập lại!");
            }
        } while (true);
    }
}
