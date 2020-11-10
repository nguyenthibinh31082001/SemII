/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Work implements IWork, Comparable<Work>{
//    - Mã công việc (workId : String) 
//    - Tên công việc (workName: String) 
//    - Ngày bắt đầu (startDate: Datetime) 
//    - Ngày kết thúc (endDate: Datetime) 
//    - Tổng chi phí (totalCost: Double) 
    private String workId;
    private String workName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;

    public Work() {
    }

    public Work(String workId, String workName, LocalDate startDate, LocalDate endDate, double totalCost) {
        this.workId = workId;
        this.workName = workName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    
    @Override
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã công việc:");
        workId = input.nextLine();
        while(workId.length() > 30){
            System.err.println("\tMã công việc không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập mã công việc:");
            workId = input.nextLine();
        }
        System.out.printf("\tNhập tên công việc: ");
        workName = input.nextLine();
        while(workName.length()<5){
            System.err.println("\tTên công việc phải tối đa 5 ký tự!");
            System.out.printf("\tNhập tên công việc:");
            workName = input.nextLine();
        }
//        input.nextLine();
        System.out.printf("\tNhập ngày bắt đầu:");
        startDate = string2LocalDate(input);
        System.out.printf("\tNhập ngày kêt thúc:");
        endDate = string2LocalDate(input);
//        person.setNgaySinh(string2LocalDate(input));
         while (true) {
            try {
                System.out.printf("\tNhập tổng chi phí:");
                totalCost = input.nextDouble();
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!");
//                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
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
               System.err.println("\tNgày không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại ngày(dd/MM/yyyy): ");
               sc.nextLine();

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    @Override
    public void display() {
        System.out.println("\tMã công việc: "+ workId);
        System.out.println("\tTên công việc: "+workName);
        System.out.println("\tNgày bắt đầu: "+ startDate);
        System.out.println("\tNgày kết thúc: "+ endDate);
        System.out.println("\tTổng chi phí: "+totalCost);
        System.out.println("\t"+soNgayTh());
    }

    @Override
    public double calcualteCostPerDay() {
        float chiPhiNgayCong = 0;
//        chiPhiNgayCong = totalCost/(endDate - startDate);
        return chiPhiNgayCong;
    }

    @Override
    public int compareTo(Work o) {
        return this.getWorkName().compareTo(o.getWorkName());
    }
    public long soNgayTh(){
       Work work = new Work();
        LocalDate startDate = work.getStartDate();
        LocalDate endDate = work.getEndDate();
        Period p = Period.between(startDate, endDate);
        return p.getDays();
    }
}
