/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work.bank;

import java.time.LocalDate;
import java.util.Scanner;
import work.Work;

/**
 *
 * @author Admin
 */
public class WorkOfBank extends Work{
    private String phongBanTh;
    private int soNhanVienTh;
    private String capDuyet;

    public WorkOfBank() {
    }

    public WorkOfBank(String phongBanTh, int soNhanVienTh, String capDuyet, String workId, String workName, LocalDate startDate, LocalDate endDate, double totalCost) {
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
        System.out.printf("\tNhập số nhân viên thực hiện:");
        soNhanVienTh = input.nextInt();
        input.nextLine();
        System.out.printf("\tNhập cấp duyệt:");
        capDuyet = input.nextLine();
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println("\tPhòng ban thực hiện: "+phongBanTh);
        System.out.println("\tSố nhân viên thực hiện: "+ soNhanVienTh);
        System.out.println("\tCấp duyệt: "+ capDuyet);
    }
}
