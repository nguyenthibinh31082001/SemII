/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person.employee;

import java.time.LocalDate;
import java.util.Scanner;
import person.Person;

/**
 *
 * @author Admin
 */
public class Employee extends Person{
    private String tenCty;
    private String phongBan;
    private String viTri;
    private float tongLuong;

    public Employee() {
    }

    public Employee(String tenCty, String phongBan, String viTri, float tongLuong, String hoTen, Boolean gioiTinh, LocalDate ngaySinh, String queQuan) {
        super(hoTen, gioiTinh, ngaySinh, queQuan);
        this.tenCty = tenCty;
        this.phongBan = phongBan;
        this.viTri = viTri;
        this.tongLuong = tongLuong;
    }

    public String getTenCty() {
        return tenCty;
    }

    public void setTenCty(String tenCty) {
        this.tenCty = tenCty;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public float getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(float tongLuong) {
        this.tongLuong = tongLuong;
    }

    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên công ty:");
        this.tenCty = input.nextLine();
        System.out.printf("\tNhập tên phòng ban:");
        this.phongBan = input.nextLine();
        System.out.printf("\tNhập vị trí:");
        this.viTri = input.nextLine();
        System.out.printf("\tNhập tổng lương:");
        this.tongLuong = input.nextFloat();
    }
    @Override
    public void display() {
        super.display();
        System.out.println("\tEmployee:");
        System.out.println("\t\tTên công ty: "+ tenCty);
        System.out.println("\t\tPhòng ban: "+ phongBan);
        System.out.println("\t\tVị trí: "+ viTri);
        System.out.println("\t\tTổng lương: "+ tongLuong);
    }
    
    
}
