    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_01;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choose;
        float a,b;
        double nghiem, r;
        float i, j, h, s;
        
        Scanner sc = new Scanner(System.in);
         while(true){
            System.out.printf("====CHỌN YÊU CẦU THỰC HIỆN====\n");
            System.out.printf("\t1. Giải phương trình bậc 1\n");
            System.out.printf("\t2. Tính diện tích hình thang\n");
            System.out.printf("\t3. Tính chu vi và diện tích hình tròn\n");
            System.out.printf("\t4. Thoát\n");
        
        System.out.printf("Mời bạn chọn:");
        choose = sc.nextInt();
        
        switch(choose){
            case 1:
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                
                System.out.print("Nhập a: ");
                a = sc.nextFloat();
                System.out.print("Nhập b: ");
                b = sc.nextFloat();
                System.out.println("Phương trình bạn vừa nhập vào là: " + a + "x + " + b + " = 0.");
                if (a == 0) {
                    if (b == 0) {
                        System.out.println("Phương trình này có vô số nghiệm.");
                    } else {
                        System.out.println("Phương trình vô nghiệm.");
                    }
                } else {
                    nghiem = (double) -b / a;   
                    System.out.println("Phương trình có nghiệm x = " + decimalFormat.format(nghiem) + ".");
                }
                break;
            case 2:
                System.out.print("Nhập đáy lớn: ");
                i = sc.nextFloat();
                System.out.print("Nhập đáy nhỏ: ");
                j = sc.nextFloat();
                System.out.print("Nhập chiều cao: ");
                h = sc.nextFloat();

                s = ((i+j)/2)*h;
                System.out.printf("Diện tích hình thang = %.3f\n", s);
                break;
            case 3:
                System.out.printf("Nhập bán kính hình tròn: ");
                r = sc.nextDouble();
                System.out.println("Diện tích hình tròn là: " + tinhDienTich(r));
                System.out.println("Chu vi hình tròn là: "+ tinhChuVi(r));
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
    public static double tinhDienTich(double r) {
        return r * r * 3.14;
    }
    public static double tinhChuVi(double r){
        return r * 2 * 3.14;
    }
}
