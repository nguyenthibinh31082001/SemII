/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech;

import emp.Employee;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class AptechEmployee extends Employee{
    private String donVi;
    private String linhVuc;

    public AptechEmployee() {
    }

    public AptechEmployee(String donVi, String linhVuc, String employeeId, String employeeName, boolean gender, LocalDate birthday, String country, String congTy, String phongBan, String chucVu, int heSoLuong, int soCongViec) {
        super(employeeId, employeeName, gender, birthday, country, congTy, phongBan, chucVu, heSoLuong, soCongViec);
        this.donVi = donVi;
        this.linhVuc = linhVuc;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }
    
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập đơn vị:");
        donVi = sc.nextLine();
        while(true){
            if(this.donVi.length() > 0){
                  break;
              }else{
                  System.err.println("\tĐơn vị không được để trống!!!");  
                  System.out.printf("\tNhập lại đơn vị: ");
                  donVi = sc.nextLine();
              }
        }
        System.out.printf("\tNhập lĩnh vực đào tạo:");
        linhVuc = sc.nextLine();
        while(true){
            if(this.linhVuc.length() > 0){
                  break;
              }else{
                  System.err.println("\tLĩnh vực đào tạo không được để trống!!!");  
                  System.out.printf("\tNhập lại lĩnh vực đào tạo: ");
                  linhVuc = sc.nextLine();
              }
        }
    }
    @Override
    public void display() {
        super.display();
        StringBuilder builder = new StringBuilder();
        builder.append("|\t");
        builder.append(String.format("%10s",this.donVi));
        builder.append("|\t");
        builder.append(String.format("%10s", this.linhVuc));
        builder.append("|\t");
        
        System.out.print(builder.toString());
    }
}
