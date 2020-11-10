/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class BTTH2 {
    private static String REGEX = "xxx";
    private static String INPUT = "xxx là một chuỗi ký tự, khi cần thể hiện tình cảm thì viết xxx ở cuối thư";
    private static String REPLACE = "*beep*";
    
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}
