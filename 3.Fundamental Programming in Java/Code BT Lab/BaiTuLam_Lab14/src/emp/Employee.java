/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Employee implements IEmployee{

    private String employeeId;
    private String employeeName;
    private boolean gender;
    private LocalDate birthday;
    private String country;
    private String congTy;
    private String phongBan;
    private String chucVu;
    private int heSoLuong;
    private int soCongViec;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, boolean gender, LocalDate birthday, String country, String congTy, String phongBan, String chucVu, int heSoLuong, int soCongViec) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.birthday = birthday;
        this.country = country;
        this.congTy = congTy;
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.soCongViec = soCongViec;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGender(){
        return gender == true ? "Nam":"Nữ";
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getStartDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(birthday);
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCongTy() {
        return congTy;
    }

    public void setCongTy(String congTy) {
        this.congTy = congTy;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getSoCongViec() {
        return soCongViec;
    }

    public void setSoCongViec(int soCongViec) {
        this.soCongViec = soCongViec;
    }
    
    
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã nhân viên:");
        employeeId = sc.nextLine();
        while(true){
            if(this.employeeId.length() >= 3){
                  break;
              }else{
                  System.err.println("\tMã phải hơn hoặc bằng 3 ký tự!!!");  
                  System.out.printf("\tNhập lại mã nhân viên: ");
                  employeeId = sc.nextLine();
              }
        }
        System.out.printf("\tNhập tên nhân viên:");
        employeeName = sc.nextLine();
        while(true){
            if(this.employeeName.length() > 0 && this.employeeName.length() < 50){
                  break;
              }else{
                  System.err.println("\tTên không được để trống và không quá 50 ký tự!!!");  
                  System.out.printf("\tNhập lại tên công việc: ");
                  employeeName = sc.nextLine();
              }
        }
        while(true){
            try {
                System.out.printf("\tNhập giới tính(true:Nam/false: Nữ): ");
                this.gender = sc.nextBoolean();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true:Nam/false: Nữ)!!!");
                sc.nextLine();
            }
        }
        System.out.printf("\tNhập ngày sinh:");
        birthday = string2LocalDate(sc);
        System.out.printf("\tNhập quê quán:");
        country = sc.nextLine();
        while(true){
            if(this.country.length() > 0){
                  break;
              }else{
                  System.err.println("\tQuê quán không được để trống!!!");  
                  System.out.printf("\tNhập lại quê quán: ");
                  country = sc.nextLine();
              }
        }
        System.out.printf("\tNhập tên công ty:");
        congTy = sc.nextLine();
        while(true){
            if(this.congTy.length() > 0){
                  break;
              }else{
                  System.err.println("\tTên công ty không được để trống!!!");  
                  System.out.printf("\tNhập lại tên công ty: ");
                  congTy = sc.nextLine();
              }
        }
        System.out.printf("\tNhập phòng ban:");
        phongBan = sc.nextLine();
        while(true){
            if(this.phongBan.length() > 0){
                  break;
              }else{
                  System.err.println("\tPhòng ban không được để trống!!!");  
                  System.out.printf("\tNhập lại phòng ban: ");
                  phongBan = sc.nextLine();
              }
        }
        System.out.printf("\tNhập chức vụ:");
        chucVu = sc.nextLine();
        while(true){
            if(this.chucVu.length() > 0){
                  break;
              }else{
                  System.err.println("\tChức vụ không được để trống!!!");  
                  System.out.printf("\tNhập lại chức vụ: ");
                  chucVu = sc.nextLine();
              }
        }
        while(true){
            try {
                System.out.printf("\tNhập hệ số lương: ");
                this.heSoLuong = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số!!!");
                sc.nextLine();
            }
        }
        while(true){
            try {
                System.out.printf("\tNhập số công việc trong tháng: ");
                this.soCongViec = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số!!!");
                sc.nextLine();
            }
        }
    }

    public LocalDate string2LocalDate(Scanner sc){
        LocalDate ld = null;
        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
//            e.printStackTrace();
               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại ngày sinh(dd/MM/yyyy): ");
               sc.nextLine();

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    @Override
    public void display() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.employeeId));
        builder.append("|\t");
        builder.append(String.format("%10s", this.employeeName));
        builder.append("|\t");
        builder.append(String.format("%10s",this.getGender()));
        builder.append("|\t");
        builder.append(String.format("%10s",birthday.format(dtf)));
        builder.append("|\t");
        builder.append(String.format("%10s", this.country));
        builder.append("|\t");
        builder.append(String.format("%10s", this.congTy));
        builder.append("|\t");
        builder.append(String.format("%10s", this.phongBan));
        builder.append("|\t");
        builder.append(String.format("%10s", this.chucVu));
        builder.append("|\t");
        builder.append(String.format("%10s", this.heSoLuong));
        builder.append("|\t");
        builder.append(String.format("%5s", this.soCongViec));
        builder.append("|\t");
        builder.append(String.format("%10s", calculateBonus()));
        builder.append("|\t");
        builder.append(String.format("%10s", calculateSalary()));
//        builder.append(String.format("%5s", String.format("%.3f", calculateSalary())));
        
        System.out.print(builder.toString());
    }

    @Override
    public double calculateBonus() {
        if(soCongViec >= 5 && soCongViec < 7){
            return 2000;
        }else if(soCongViec >= 7 && soCongViec < 10){
            return 5000;
        }else if(soCongViec >= 10){
            return 10000;
        }else{
            return 0;
        }
        
    }

    @Override
    public double calculateSalary() {
        return basicSalay * heSoLuong + calculateBonus();
    }
    
}
