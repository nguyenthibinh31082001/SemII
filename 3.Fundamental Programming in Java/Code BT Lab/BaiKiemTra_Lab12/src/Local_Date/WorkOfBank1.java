/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Local_Date;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class WorkOfBank1 extends Work1{
    private String phongBanTh;
    private int soNhanVienTh;
    private String capDuyet;

    public WorkOfBank1() {
    }

    public WorkOfBank1(String phongBanTh, int soNhanVienTh, String capDuyet, String workId, String workName, LocalDate startDate, LocalDate endDate, double totalCost) {
        super(workId, workName, startDate, endDate, totalCost);
        this.phongBanTh = phongBanTh;
        this.soNhanVienTh = soNhanVienTh;
        this.capDuyet = capDuyet;
    }

    public String getPhongBanTh() {
        return phongBanTh;
    }

    public void setPhongBanTh(String phongBanTh) {
        this.phongBanTh = phongBanTh;
    }

    public int getSoNhanVienTh() {
        return soNhanVienTh;
    }

    public void setSoNhanVienTh(int soNhanVienTh) {
        this.soNhanVienTh = soNhanVienTh;
    }

    public String getCapDuyet() {
        return capDuyet;
    }

    public void setCapDuyet(String capDuyet) {
        this.capDuyet = capDuyet;
    }

    
    @Override
    public void input(){
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập phòng ban thực hiện:");
        phongBanTh = input.nextLine();
        while(true){
            if(this.phongBanTh.length() > 0){
                  break;
              }else{
                  System.err.println("\tPhòng ban thực hiên không được để trống!!!");  
                  System.out.printf("\tNhập lại phòng ban thực hiện: ");
                  phongBanTh = input.nextLine();
              }
        }
        while(true){
            try {
                System.out.printf("\tNhập số nhân viên thực hiện:");
                soNhanVienTh = input.nextInt();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số!!!");
                input.nextLine();
            }
        }
        input.nextLine();
        System.out.printf("\tNhập cấp duyệt:");
        capDuyet = input.nextLine();
        while(true){
            if(this.capDuyet.length() > 0){
                  break;
              }else{
                  System.err.println("\tCấp duyệt không được để trống!!!");  
                  System.out.printf("\tNhập lại cấp duyệt: ");
                  capDuyet = input.nextLine();
              }
        }
    }
    
    @Override
    public void display(){
        super.display();
        StringBuilder builder = new StringBuilder();
        builder.append("|\t\t");
        builder.append(String.format("%10s", this.phongBanTh));        
        builder.append("|\t");
        builder.append(String.format("%5s", this.soNhanVienTh));     
        builder.append("|\t");
        builder.append(String.format("%10s", this.capDuyet));  
        builder.append("|\t");
        
        System.out.println(builder.toString());
    }
}
