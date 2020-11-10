/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai15_Lab2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ChiSoCu, ChiSoMoi, PhanDinhMuc, PhanVuotDinhMuc;
        int DinhMuc=50;
        int DonGiaDinhMuc=230;
        int TienThueBaoDienKe=1000;
        int LuongDienSuDung;
        
       
        Scanner input = new Scanner(System.in);

        System.out.printf("Nhập chỉ số cũ: ");
        ChiSoCu = input.nextInt();
        System.out.printf("Nhập chỉ số mới: ");
        ChiSoMoi = input.nextInt();
        
        LuongDienSuDung = ChiSoMoi - ChiSoCu;
        if(LuongDienSuDung>DinhMuc){
//            Nếu dùng quá định mức thì phần vượt định mức bằng lượng điện sử dụng trừ đi định mức
            PhanDinhMuc = DinhMuc;
            PhanVuotDinhMuc = LuongDienSuDung - DinhMuc;
        }else{
            PhanDinhMuc=LuongDienSuDung;
            PhanVuotDinhMuc = 0;//Nếu dùng không quá định mức thì phần vượt định mức = 0
        }
        int DonGiaVuotDinhMuc = 0;
        if (PhanVuotDinhMuc <= 50){
            DonGiaVuotDinhMuc = 480;
        }else if(PhanVuotDinhMuc < 100){
            DonGiaVuotDinhMuc = 700;
        }else if(PhanVuotDinhMuc <= 100){
            DonGiaVuotDinhMuc = 900;
        }
        int TienTraDinhMuc = PhanDinhMuc * DonGiaDinhMuc;
        int TienVuotDinhMuc = PhanVuotDinhMuc * DonGiaVuotDinhMuc;
        int TongTienPhaiTra = TienTraDinhMuc+TienVuotDinhMuc + TienThueBaoDienKe;
        
        System.out.println("Chỉ số cũ: " +ChiSoCu);
        System.out.println("Chỉ số mới: " +ChiSoMoi);
        System.out.println("Tiền trả định mức: " +TienTraDinhMuc);
        System.out.println("Tiền trả vượt định mức: " +TienVuotDinhMuc);
        System.out.println("Tổng tiền phải trả: " +TongTienPhaiTra);
    }
}
