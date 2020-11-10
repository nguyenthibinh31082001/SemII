/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_02;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai1 {
    public static void main(String[] args) {
        int choose, a, b, n, m;
        
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.printf("====CHỌN YÊU CẦU THỰC HIỆN====\n");
            System.out.printf("\t1. Tìm UCLN và BCNN của 2 số a và b cho trước\n");
            System.out.printf("\t2. In ra chuỗi Fibonacci của một số n và liệt kê các số nguyên tố nhỏ hơn n cho trước\n");
            System.out.printf("\t3. Tìm số thuận nghịch\n");
            System.out.printf("\t4. Thoát\n");
        
        System.out.printf("Mời bạn chọn:");
        choose = sc.nextInt();
        
        switch(choose){
            case 1:
                System.out.printf("Nhập số nguyên a:");
                a = sc.nextInt();
                System.out.printf("Nhập số nguyên b:");
                b = sc.nextInt();

                System.out.println("UCLN là:"+UCLN(a, b));
                System.out.println("BCNN là:"+BCNN(a, b));
                break;
            case 2:
                System.out.printf("Nhập 1 số n:");
                n = sc.nextInt();
                System.out.printf("Số Fibonacci của %d là: %d\n",n, Fibonacci(n));
                System.out.printf("Tất cả các số nguyên tố nhỏ hơn %d là: ",n);
                if (n >= 2) {
                    System.out.printf("%d ", 2);
                }
                for (int i = 3; i < n; i+=2) {
                    if (CheckSNT(i) == 1) {
                        System.out.printf("%d ", i);
                    }
                }
                System.out.printf(" \n");
                break;
            case 3:
                System.out.print("Nhập số nguyên dương m: ");
                m = sc.nextInt();
                
                System.out.println("Số "+m + " " + isThuanNghich(m));
                break;
            case 4:
               System.exit(0);
               break;
            default:
                System.out.println("!!!Mời bạn chọn lại!!!");
                break;
            }
        }
    }
    public static int UCLN(int a, int b) {
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
            return a;
        }
    public static int BCNN(int a, int b) {
        return (a * b) / UCLN(a, b);
    }
    public static int Fibonacci(int n){
        if (n == 1 || n == 2)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static int CheckSNT(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
           System.out.println(n+" không phải là số nguyên tố, nhập số lớn hơn 2");
        }
        // check so nguyen to khi n >= 2
        int CanBac2 = (int) sqrt(n);
        for (int i = 2; i <= CanBac2; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
    return 1;
    }
    public static String isThuanNghich(int m) {
        // chuyển đổi số m thành một chuỗi String
        String numberStr = String.valueOf(m);
        // kiểm tra tính thuận nghịch
        int size = numberStr.length();
        for (int i = 0; i < (size/2); i++) {
            if (numberStr.charAt(i) != numberStr.charAt(size - i - 1)) {
                return "không là số thuận nghịch";
            }
        }
        return "là số thuận nghịch";
    }
}
