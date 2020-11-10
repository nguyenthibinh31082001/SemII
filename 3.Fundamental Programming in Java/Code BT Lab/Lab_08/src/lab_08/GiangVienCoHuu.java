/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_08;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class GiangVienCoHuu extends GiangVien{
    private double LuongThoaThuan;
    private static int soGioQuyDinh = 40;

    public GiangVienCoHuu() {
    }

    public GiangVienCoHuu(double LuongThoaThuan, String TenGiangVien, String DiaChi, String SĐT, float GioDay) {
        super(TenGiangVien, DiaChi, SĐT, GioDay);
        this.LuongThoaThuan = LuongThoaThuan;
    }

    public double getLuongThoaThuan() {
        return LuongThoaThuan;
    }

    public void setLuongThoaThuan(double LuongThoaThuan) {
        this.LuongThoaThuan = LuongThoaThuan;
    }

    public static int getSoGioQuyDinh() {
        return soGioQuyDinh;
    }

    public static void setSoGioQuyDinh(int soGioQuyDinh) {
        GiangVienCoHuu.soGioQuyDinh = soGioQuyDinh;
    }

    
    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập Lương thỏa thuận:");
        this.LuongThoaThuan = input.nextDouble();
    }
    @Override
    public void display() {
        super.display();
//        System.out.println("|\t\t"+getLuongThoaThuan() + "\t|\t" + soGioQuyDinh);
        System.out.println("\t|Lương thỏa thuận: " +LuongThoaThuan+ " | ");
        System.out.println("\t|Số giờ quy định: " +soGioQuyDinh+ " | ");
    }
}
