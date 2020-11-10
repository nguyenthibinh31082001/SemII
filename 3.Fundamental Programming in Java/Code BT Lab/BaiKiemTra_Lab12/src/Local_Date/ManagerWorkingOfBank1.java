/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Local_Date;

//import java.time.LocalDateTime.ManagerWorkingOfBank1;
//import java.time.LocalDateTime.Work1;
//import java.time.LocalDateTime.WorkOfBank1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ManagerWorkingOfBank1 {
    List<WorkOfBank1> lstWorkOfBank1 = new ArrayList<>();

    
    public ManagerWorkingOfBank1() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);
        initData();
        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập vào thông tin n công việc của ngân hàng\n");
            System.out.printf("\t2. Hiển thị danh sách thông tin các công việc \n");
            System.out.printf("\t3. Sắp xếp và hiển thị danh sách tăng giảm theo tên công việc \n");
            System.out.printf("\t4. Sắp xếp và hiển thị danh sách tăng giảm theo số ngày thực hiện \n");
            System.out.printf("\t5. Tìm kiếm thông tin công việc theo tên công việc\n");
            System.out.printf("\t6. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortNameASC(sc);
                    sortNameDESC(sc);
                    break;
                case 4:
                    SortNgayTHDESC();
                    SortNgayTHDASC();
                    break;
                case 5:
                    search(sc);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-6!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng công việc: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Công việc %d: \n",i+1);
            WorkOfBank1 workOfBank1 = new WorkOfBank1();
            workOfBank1.input();
            lstWorkOfBank1.add(workOfBank1);
        }
    }
    
    public void display() {
        System.out.println("Danh sách công việc vừa nhập:");
        System.out.println("Mã\t\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tSố ngày TH\tPhòng ban\tSố NV\tCấp duyệt");
        for(Work1 f : lstWorkOfBank1){
            f.display();
            System.out.println(" ");
        }
//        System.out.println(" ");
    }
    public void sortNameASC(Scanner sc) {
        Collections.sort(
                lstWorkOfBank1,
                (Work1 o1, Work1 o2) -> o1.getWorkName().compareTo(o2.getWorkName())
        );
        System.out.println("Danh sách tên cầu thủ tăng dần là:");
        System.out.println("Mã\t\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tSố ngày TH\tPhòng ban\tSố NV\tCấp duyệt");
        for (int i = 0; i < lstWorkOfBank1.size(); i++) {
            lstWorkOfBank1.get(i).display();
            System.out.println(" ");
        }
    }
    public void sortNameDESC(Scanner sc) {
        Collections.sort(
                lstWorkOfBank1,
                (Work1 o1, Work1 o2) -> o2.getWorkName().compareTo(o1.getWorkName())
        );
        System.out.println("Danh sách tên cầu thủ giảm dần là:");
        System.out.println("Mã\t\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tSố ngày TH\tPhòng ban\tSố NV\tCấp duyệt");
        for (int i = 0; i < lstWorkOfBank1.size(); i++) {
            lstWorkOfBank1.get(i).display();
            System.out.println(" ");
        }
    }
    public void SortNgayTHDASC(){
        Collections.sort(lstWorkOfBank1, 
                (Work1 o1, Work1 o2) -> (int) (o1.NgayTH1() - o2.NgayTH1()));
        System.out.println("Danh sách số ngày thực hiện tăng dần là:");
        System.out.println("Mã\t\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tSố ngày TH\tPhòng ban\tSố NV\tCấp duyệt");
        for (int i = 0; i < lstWorkOfBank1.size(); i++) {
            lstWorkOfBank1.get(i).display();
            System.out.println(" ");
        }
    }
    public void SortNgayTHDESC(){
        Collections.sort(lstWorkOfBank1, 
                (Work1 o1, Work1 o2) -> (int) (o2.NgayTH1() - o1.NgayTH1()));
        System.out.println("Danh sách số ngày thực hiện giảm dần là:");
        System.out.println("Mã\t\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tSố ngày TH\tPhòng ban\tSố NV\tCấp duyệt");
        for (int i = 0; i < lstWorkOfBank1.size(); i++) {
            lstWorkOfBank1.get(i).display();
            System.out.println(" ");
        }
//        Work work;
//        for(int i = 0 ; i< lstWork.size(); i++){
//            work = lstWork.get(i);
//            LocalDateTime startDate = work.getStartDate();
//            LocalDateTime endDate = work.getEndDate();
//            long days = ChronoUnit.YEARS.between(startDate, endDate);
//            System.out.println(days);
//    }
//            Collections.sort(lstWork, new Comparator<Work>() {
//                @Override
//                public int compare(Work o1, Work o2) {
//                    if (o1.soNgayTh() < o2.soNgayTh()) {
//                        return 1;
//                    } else {
//                        if (o1.soNgayTh() == o2.soNgayTh()) {
//                            return 0;
//                        } else {
//                            return -1;
//                        }
//                    }
//                }
//            });
//        }
//    System.out.println("Danh sách giảm dần theo số ngày thực hiện là: ");
//        for (int i = 0; i < lstWork.size(); i++) {
//            lstWork.get(i).display();
//            System.out.println(" ");
//        }
    }
    private void search(Scanner sc) {
        System.out.printf("Nhập tên công việc cần tìm: ");
        sc.nextLine();
        String name = sc.nextLine();
        int flag = 0;
        System.out.println("Mã\t\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tSố ngày TH\tPhòng ban\tSố NV\tCấp duyệt");
        for (Work1 f : lstWorkOfBank1) {
            if (f.getWorkName().toLowerCase().contains(name.trim().toLowerCase())) {
                f.display();
                flag++;
                System.out.println("");
            }
        }

        if (flag == 0) {
            System.out.println("Không tìm thấy công việc có tên là: " + name);
        }
    }
        
    public static void main(String[] args) {
        ManagerWorkingOfBank1 app = new ManagerWorkingOfBank1();
        app.run();
    }
    
    public void initData(){
        lstWorkOfBank1.add(new WorkOfBank1("Lap Trinh", 2, "Chu Tich", "W001", "Code", LocalDate.of(2015,10,1), LocalDate.of(2020,10,31), 1000));
        lstWorkOfBank1.add(new WorkOfBank1("bvc", 2, "Chu Tich", "W002", "aode", LocalDate.of(2020,8,15), LocalDate.of(2020,8,31), 1000));
        lstWorkOfBank1.add(new WorkOfBank1("quan tri", 2, "Chu Tich", "W003", "hode", LocalDate.of(2016,5,16), LocalDate.of(2020,5,31), 1000));
        lstWorkOfBank1.add(new WorkOfBank1("Lap Trinh2", 2, "Chu Tich", "W004", "dode", LocalDate.of(2020,3,17), LocalDate.of(2020,3,31), 1000));
        lstWorkOfBank1.add(new WorkOfBank1("Lap Trinh3", 2, "Chu Tich", "W005", "pode", LocalDate.of(2003,1,18), LocalDate.of(2020,2,28), 1000));
//        lstWorkOfBank1.add(new WorkOfBank1("Lap Trinh", 2, "Chu Tich", "W006", "Code", LocalDateTime.of(2001,2,19,0,0,0), LocalDateTime.of(2020,5,31,0,0,0), 1000));
    }
}
