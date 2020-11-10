/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person.student;

import java.time.LocalDate;
import java.util.Scanner;
import person.Person;

/**
 *
 * @author Admin
 */
public class Student extends Person{
    private String maSv;
    private String tenLop;
    private String khoaHoc;

    public Student() {
    }

    public Student(String maSv, String tenLop, String khoaHoc, String hoTen, Boolean gioiTinh, LocalDate ngaySinh, String queQuan) {
        super(hoTen, gioiTinh, ngaySinh, queQuan);
        this.maSv = maSv;
        this.tenLop = tenLop;
        this.khoaHoc = khoaHoc;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
    
    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã sinh viên:");
        this.maSv = input.nextLine();
        System.out.printf("\tNhập tên lớp:");
        this.tenLop = input.nextLine();
        System.out.printf("\tNhập khóa học:");
        this.khoaHoc = input.nextLine();
    }
    @Override
    public void display() {
        super.display();
        System.out.println("\tStudent:");
        System.out.println("\t\tMã sinh viên: "+ maSv);
        System.out.println("\t\tTên lớp: "+ tenLop);
        System.out.println("\t\tKhóa học: "+ khoaHoc);
    }
}
