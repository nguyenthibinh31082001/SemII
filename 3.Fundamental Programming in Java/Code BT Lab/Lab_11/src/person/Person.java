/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import sun.util.resources.LocaleData;

/**
 *
 * @author Admin
 */
public class Person implements IPerson, Comparable<Person>{
//    - Họ tên : Kiểu String – tối thiểu có 5 kí tự, tối đa có 50 kí tự
//    - Giới tính : Kiểu Boolean – bắt buộc phải nhập true/false
//    - Ngày sinh : Kiểu Date – Phải đủ 18 tuổi trở lên so với năm hiện tại
//    - Quê quán : Kiểu String – Tối thiểu có 5 kí tự, tối đa có 200 kí tự
    private String hoTen;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String queQuan;

    public Person() {
    }

    public Person(String hoTen, Boolean gioiTinh, LocalDate ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập họ tên:");
        hoTen = input.nextLine();
        while(hoTen.length()<5 || hoTen.length()>50){
            System.err.println("\tHọ tên phải tối đa 5 ký tự và không được vượt quá 50 ký tự!");
            System.out.printf("\tNhập họ tên:");
            hoTen = input.nextLine();
        }
         while (true) {
            try {
                System.out.printf("\tNhập giới tính:");
                gioiTinh = input.nextBoolean();
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập True/False!");
//                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
        input.nextLine();
        System.out.printf("\tNhập ngày sinh:");
        ngaySinh = string2LocalDate(input);
//        person.setNgaySinh(string2LocalDate(input));
        System.out.printf("\tNhập quê quán:");
        queQuan = input.nextLine();
        while(queQuan.length()<5 || queQuan.length()>50){
            System.err.println("\tQuê quán phải tối đa 5 ký tự và không được vượt quá 200 ký tự!");
            System.out.printf("\tNhập quê quán:");
            queQuan = input.nextLine();
        }
    }

    @Override
    public void display() {
        System.out.println("\tHọ tên: "+ hoTen);
        System.out.println("\tGiới tính: "+(this.gioiTinh == true ? "Nữ" : "Nam"));
        System.out.println("\tNgày sinh: "+ ngaySinh);
        System.out.println("\tQuê quán: "+ queQuan);
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
    public int compareTo(Person o) {
        return this.getHoTen().compareTo(o.getHoTen());
    }
    
}
