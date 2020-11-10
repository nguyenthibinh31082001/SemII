/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Employee implements Comparable<Employee>{
    private String id;
    private String name;
    private boolean gender;
    private LocalDate birthday;
    private String queQuan;
    private String phongBan;
    private String viTri;
    private float tongLuong;

    public Employee() {
    }

    public Employee(String id, String name, boolean gender, LocalDate birthday, String queQuan, String phongBan, String viTri, float tongLuong) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.queQuan = queQuan;
        this.phongBan = phongBan;
        this.viTri = viTri;
        this.tongLuong = tongLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }
    public String getGender(){
        return gender == true ? "Nữ":"Nam";
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
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

    
    public void input(){
        Scanner sc  = new Scanner(System.in);
        System.out.printf("\tNhập mã nhân viên: ");
        this.id = sc.nextLine();
        System.out.printf("\tNhập tên nhân viên: ");
        this.name = sc.nextLine();
        System.out.printf("\tNhập số giới tính: ");
        this.gender = sc.nextBoolean();
        sc.nextLine();
        System.out.printf("\tNhập ngày sinh: ");
        this.birthday = string2LocalDate(sc);
        System.out.printf("\tNhập quê quán: ");
        this.queQuan = sc.nextLine();
        System.out.printf("\tNhập phòng ban: ");
        this.phongBan = sc.nextLine();
        System.out.printf("\tNhập vị trí: ");
        this.viTri = sc.nextLine();
        System.out.printf("\tNhập tổng lương: ");
        this.tongLuong = sc.nextFloat();
    }
     public LocalDate string2LocalDate(Scanner sc){
        LocalDate ld = null;
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
//            e.printStackTrace();
               System.err.println("\tNgày không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại ngày(dd/MM/yyyy): ");
               sc.nextLine();

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", gender=" + getGender() + ", birthday=" + birthday + ", queQuan=" + queQuan + ", phongBan=" + phongBan + ", viTri=" + viTri + ", tongLuong=" + tongLuong;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) this.tongLuong;
    }

}
