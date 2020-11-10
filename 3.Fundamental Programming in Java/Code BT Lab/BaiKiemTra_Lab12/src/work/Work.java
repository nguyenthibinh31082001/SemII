/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Work implements IWork{

//    Mã công việc		(workId : String)
//    Tên công việc		(workName: String)
//    Ngày kết thúc		(endDate: Date)
//    Tổng chi phí		(totalCost: Double)

    private String workId;
    private String workName;
    private Date startDate;
    private Date endDate;
    private double totalCost;

    public Work() {
    }

    public Work(String workId, String workName, Date startDate, Date endDate, double totalCost) {
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

    public Date getStartDate() {
        return startDate;
    }
    public String getStartDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(startDate);
    }
    public String getEndDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(endDate);
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
        while(true){
            try {
                System.out.printf("\tNhập ngày bắt đầu:");
                String d = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 this.startDate = sdf.parse(d);
                 Date now = new Date(System.currentTimeMillis());
                 if(startDate.getYear() < now.getYear()){
                      break;
                 }
               
            } catch (ParseException e) {
                System.err.println("\tNhập sai định dạng (dd/MM/yyyy)");
//                sc.nextLine();
            }
        }
        while(true){
            try {
                System.out.printf("\tNhập ngày kết thúc:");
                String d = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 this.endDate = sdf.parse(d);
                 Date now = new Date(System.currentTimeMillis());
                 if(endDate.getYear() >= startDate.getYear()){
                      break;
                 }
               
            } catch (ParseException e) {
                System.err.println("\tNhập sai định dạng (dd/MM/yyyy)");
//                sc.nextLine();
            }
        }
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

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(this.workId));
        builder.append("|\t");
        builder.append(String.format("%10s", this.workName));
        builder.append("|\t");
        builder.append(String.format("%10s",getStartDateString()));
        builder.append("|\t");
        builder.append(String.format("%10s",getEndDateString()));
        builder.append("|\t");
        builder.append(String.format("%10s", this.totalCost));
        builder.append("|\t");
        builder.append(String.format("%10s", calcualteCostPerDay()));
        builder.append("|\t");
        builder.append(String.format("%10s", NgayTH()));
        
        System.out.print(builder.toString());
    }

    @Override
    public double calcualteCostPerDay() {
        long time1 = startDate.getTime();
        long time2 = endDate.getTime();
        double ngayth = ((time2 - time1)/(24*60*60*1000));
        return totalCost/ngayth;
    }
    public double NgayTH() {
        long time1 = startDate.getTime();
        long time2 = endDate.getTime();
        double ngayth = ((time2 - time1)/(24*60*60*1000));
        return ngayth;
    }
 
}
