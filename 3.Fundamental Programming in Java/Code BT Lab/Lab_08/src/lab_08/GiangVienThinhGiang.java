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
public class GiangVienThinhGiang extends GiangVien{
    private String CoQuanLamViec;
    private float GioCoTheDay;
    
    public GiangVienThinhGiang() {
    }
    
    public GiangVienThinhGiang(String coQuanLamViec, float gioCoTheDay) {
        this.CoQuanLamViec = CoQuanLamViec;
        this.GioCoTheDay = GioCoTheDay;
    }
    
    public GiangVienThinhGiang(String CoQuanLamViec, float GioCoTheDay, String TenGiangVien, String DiaChi, String SĐT, float GioDay) {
        super(TenGiangVien, DiaChi, SĐT, GioDay);
        this.CoQuanLamViec = CoQuanLamViec;
        this.GioCoTheDay = GioCoTheDay;
    }

    public String getCoQuanLamViec() {
        return CoQuanLamViec;
    }

    public void setCoQuanLamViec(String CoQuanLamViec) {
        this.CoQuanLamViec = CoQuanLamViec;
    }

    public float getGioCoTheDay() {
        return GioCoTheDay;
    }

    public void setGioCoTheDay(float GioCoTheDay) {
        this.GioCoTheDay = GioCoTheDay;
    }


    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập cơ quan làm việc:");
        this.CoQuanLamViec = input.nextLine();
        System.out.printf("\tNhập  giờ có thể dạy:");
        this.GioCoTheDay = input.nextFloat();
    }
    @Override
    public void display() {
        super.display();
//        System.out.println("\t\t"+getCoQuanLamViec()+ "\t | \t" + getGioCoTheDay());
        System.out.println("\t|Lương thỏa thuận: " +CoQuanLamViec+ " | ");
        System.out.println("\t|Số giờ quy định: " +GioCoTheDay+ " | ");
    }
    
    
}
