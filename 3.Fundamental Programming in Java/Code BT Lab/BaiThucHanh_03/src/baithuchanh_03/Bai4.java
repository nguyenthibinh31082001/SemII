/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh_03;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào một chuỗi: ");
        String str= sc.nextLine();
        
        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Chuyển chuỗi thành chữ hoa\n");
            System.out.printf("2. Chuyển chuỗi thành chữ thường\n");
            System.out.printf("3. In ra số từ trong chuỗi\n");
            System.out.printf("4. Chuyển tất cả khoảng trắng thành ký tự '-'\n");
            System.out.printf("5. Viết hoa ký tự đầu tiên trong mỗi từ\n");
            System.out.printf("6. Thoát\n");
            
            System.out.printf("Chọn menu để thực hiện: ");
            int choose = Integer.parseInt(sc.nextLine());
            
            switch(choose){
                case 1:
                    String strHoa = str.toUpperCase();
                    System.out.println("\tChuỗi vừa nhập là: " + str);
                    System.out.println("\tChuyển đổi chuỗi sang chữ hoa là: "+ strHoa);
                    break;
                case 2:
                    String strThuong = str.toLowerCase();
                    System.out.println("\tChuỗi vừa nhập là: " + str);
                    System.out.println("\tChuyển đổi chuỗi sang chữ thường là: "+ strThuong);
                    break;
                case 3:
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    int SoTuTrongChuoi = stringTokenizer.countTokens();
                    System.out.println("\tSố từ có trong chuỗi \"" + str + "\" = " + SoTuTrongChuoi);
                    break;
                case 4:
                    str = str.replace(" ", "-");
                    System.out.println("\tChuyển khoảng trắng thành ký tự '-' = " +str);
                    break;
                case 5:
                    // Chỉ ký tự đầu chuyển thành chữ hoa:
//                    String[] arr = str.split(" ");
//                    String string1 = "";
//                    for (String x : arr) {
//                            string1 = string1 + (x.substring(0, 1).toUpperCase() + x.substring(1));
//                            string1 = string1 + " ";
//                    }
//                    System.out.println("\tBiến các chữ đầu thành hoa: " + string1);
                    
                    char[] chars = str.toLowerCase().toCharArray();
                    boolean found = false;
                    for (int i = 0; i < chars.length; i++) {
                      if (!found && Character.isLetter(chars[i])) {
                        chars[i] = Character.toUpperCase(chars[i]);
                        found = true;
                      } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { 
                        found = false;
                      }
                    }
                   System.out.printf("\tBiến các chữ đầu thành hoa: " .valueOf(chars));
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.printf("Vui lòng chọn từ 1-7!!!");
            } 
        }while (true);
    }
    
}
