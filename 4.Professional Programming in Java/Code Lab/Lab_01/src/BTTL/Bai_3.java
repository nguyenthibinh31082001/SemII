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
public class Bai_3 {
    private static final String year = "(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)";
    public static void main(String[] args) {
        do {
            System.out.printf("Nhập ngày tháng năm sinh của bạn: ");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(year);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if (matcher.matches()) {
                System.err.println("Ngày tháng năm sinh hợp lệ(mm-dd-yyyy hoặc mm/dd/yyyy)");
                break;
            } else {
                System.err.println("Ngày tháng năm không hợp lệ(mm-dd-yyyy hoặc mm/dd/yyyy), nhập lại!");
            }
        } while (true);
    }
    
}
