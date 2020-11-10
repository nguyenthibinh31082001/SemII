/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Local_Date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Work1 implements IWork1{
    //    Mã công việc		(workId : String)
//    Tên công việc		(workName: String)
//    Ngày kết thúc		(endDate: Date)
//    Tổng chi phí		(totalCost: Double)

    private String workId;
    private String workName;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    private LocalDate startDate;
    private LocalDate endDate;
    
    private double totalCost;

    public Work1() {
    }

    public Work1(String workId, String workName, LocalDate startDate, LocalDate endDate, double totalCost) {
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

    public String getStartDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(startDate);
    }
    public String getEndDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(endDate);
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
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã công việc:");
        workId = sc.nextLine();
        while(true){
            if(this.workId.length() > 3){
                  break;
              }else{
                  System.err.println("\tMã phải hơn 3 ký tự!!!");  
                  System.out.printf("\tNhập lại mã công việc: ");
                  workId = sc.nextLine();
              }
        }
        System.out.printf("\tNhập tên công việc:");
        workName = sc.nextLine();
        while(true){
            if(this.workName.length() > 0 ){
                  break;
              }else{
                  System.err.println("\tTên không được để trống!!!");  
                  System.out.printf("\tNhập lại tên công việc: ");
                  workName = sc.nextLine();
              }
        }
        System.out.printf("\tNhập ngày bắt đầu:");
        startDate = string2LocalDate(sc);
        System.out.printf("\tNhập ngày kêt thúc:");
        endDate = string2LocalDate(sc);
        while(true){
            try {
                System.out.printf("\tNhập tổng chi phí:");
                totalCost = sc.nextDouble();
//                sc.nextDouble();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số!!!");
                sc.nextDouble();
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%5s",this.workId));
        builder.append("|\t");
        builder.append(String.format("%10s", this.workName));
        builder.append("|\t");
        builder.append(String.format("%10s",startDate.format(dtf)));
        builder.append("|\t");
        builder.append(String.format("%10s",endDate.format(dtf)));
        builder.append("|\t");
        builder.append(String.format("%10s", this.totalCost));
        builder.append("|\t");
        builder.append(String.format("%10s", String.format("%.3f", calcualteCostPerDay())));
        builder.append("|\t");
        builder.append(String.format("%5s", NgayTH1()));
        
        System.out.print(builder.toString());
    }

    @Override
    public double calcualteCostPerDay() {
        return totalCost/NgayTH1();
    }
    public int NgayTH1() {
        Period p = Period.between(startDate, endDate);
        int y, m, d;
        y = p.getYears();
        m = p.getMonths();
        d = p.getDays();
        int total = (y*365)+(m*12)+d;
        return total;
    }
//    public int NgayTH1() {
//        Duration d = Duration.between(startDate, endDate);
//        return (int) d.toDays();
//    }
}
