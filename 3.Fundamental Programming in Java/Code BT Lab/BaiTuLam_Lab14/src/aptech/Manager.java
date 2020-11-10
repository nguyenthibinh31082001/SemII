/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Manager {

    List<AptechEmployee> lstAptechEmployee = new ArrayList<>();

    
    public Manager() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);
//        initData();
        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n nhân viên Aptech\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Sắp xếp thông tin giảm dần và tăng dần theo thưởng và hiển thị\n");
            System.out.printf("\t4. Sắp xếp thông tin tăng dần và giảm dần theo phòng ban và hiển thị\n");
            System.out.printf("\t5. Tìm kiếm thông tin theo phòng ban\n");
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
                    sortCalculateBonusDESC(sc);
                    sortCalculateBonusASC(sc);
                    break;
                case 4:
                    sortPhongBanASC(sc);
                    sortPhongBanDESC(sc);
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
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Nhân viên %d: \n",i+1);
            AptechEmployee aptechEmployee = new AptechEmployee();
            aptechEmployee.input();
            lstAptechEmployee.add(aptechEmployee);
        }
    }
    
    public void display() {
        System.out.println("Danh sách nhân viên vừa nhập:");
        System.out.println("Mã\t\tTên\tGiới tính\tNgày sinh\tQuê quán\tCông ty\t\tPhòng ban\tChức vụ\t\tHệ số Lương\tSố CV\tThưởng\t\tLương\t\tĐơn vị\t\tLĩnh vực");
        for(AptechEmployee f : lstAptechEmployee){
            f.display();
            System.out.println(" ");
        }
//        System.out.println(" ");
    }
    public void sortCalculateBonusDESC(Scanner sc) {
        Collections.sort(lstAptechEmployee, 
                (AptechEmployee o1, AptechEmployee o2) -> (int) (o2.calculateBonus()- o1.calculateBonus()));
        System.out.println("Danh sách thưởng giảm dần là:");
        System.out.println("Mã\t\tTên\tGiới tính\tNgày sinh\tQuê quán\tCông ty\t\tPhòng ban\tChức vụ\t\tHệ số Lương\tSố CV\tThưởng\t\tLương\t\tĐơn vị\t\tLĩnh vực");
        for (int i = 0; i < lstAptechEmployee.size(); i++) {
            lstAptechEmployee.get(i).display();
            System.out.println(" ");
        }
    }
     public void sortCalculateBonusASC(Scanner sc) {
        Collections.sort(lstAptechEmployee, 
                (AptechEmployee o1, AptechEmployee o2) -> (int) (o1.calculateBonus()- o2.calculateBonus()));
        System.out.println("Danh sách thưởng tăng dần là:");
        System.out.println("Mã\t\tTên\tGiới tính\tNgày sinh\tQuê quán\tCông ty\t\tPhòng ban\tChức vụ\t\tHệ số Lương\tSố CV\tThưởng\t\tLương\t\tĐơn vị\t\tLĩnh vực");
        for (int i = 0; i < lstAptechEmployee.size(); i++) {
            lstAptechEmployee.get(i).display();
            System.out.println(" ");
        }
    }
    public void sortPhongBanASC(Scanner sc) {
        Collections.sort(
                lstAptechEmployee,
                (AptechEmployee o1, AptechEmployee o2) -> o1.getPhongBan().compareTo(o2.getPhongBan())
        );
        System.out.println("Danh sách tăng dần theo phòng ban là:");
        System.out.println("Mã\t\tTên\tGiới tính\tNgày sinh\tQuê quán\tCông ty\t\tPhòng ban\tChức vụ\t\tHệ số Lương\tSố CV\tThưởng\t\tLương\t\tĐơn vị\t\tLĩnh vực");
        for (int i = 0; i < lstAptechEmployee.size(); i++) {
            lstAptechEmployee.get(i).display();
            System.out.println(" ");
        }
    }
    public void sortPhongBanDESC(Scanner sc) {
        Collections.sort(
                lstAptechEmployee,
                (AptechEmployee o1, AptechEmployee o2) -> o2.getPhongBan().compareTo(o1.getPhongBan())
        );
        System.out.println("Danh sách giảm dần theo phòng ban là:");
        System.out.println("Mã\t\tTên\tGiới tính\tNgày sinh\tQuê quán\tCông ty\t\tPhòng ban\tChức vụ\t\tHệ số Lương\tSố CV\tThưởng\t\tLương\t\tĐơn vị\t\tLĩnh vực");
        for (int i = 0; i < lstAptechEmployee.size(); i++) {
            lstAptechEmployee.get(i).display();
            System.out.println(" ");
        }
    }
   
//    public void SortNgayTH(){
//        Collections.sort(lstWork1, 
//                (Work1 o1, Work1 o2) -> (int) (o2.NgayTH1() - o1.NgayTH1()));
//        System.out.println("Danh sách số ngày thực hiện giảm dần là:");
//        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\tPhí chuyển nhượng\tLương theo tuần\tLương theo tháng\tLương theo năm");
//        for (int i = 0; i < lstWork1.size(); i++) {
//            lstWork1.get(i).display();
//            System.out.println(" ");
//        }
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
//    }
    private void search(Scanner sc) {
        System.out.printf("Nhập tên phòng ban cần tìm: ");
        sc.nextLine();
        String name = sc.nextLine();
        int flag = 0;
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\tPhí chuyển nhượng\tLương theo tuần\tLương theo tháng\tLương theo năm");
        for (AptechEmployee f : lstAptechEmployee) {
            if (f.getPhongBan().toLowerCase().contains(name.trim().toLowerCase())) {
                f.display();
                flag++;
                System.out.println("");
            }
        }

        if (flag == 0) {
            System.err.println("Không tìm thấy phòng ban có tên là: " + name);
        }
    }
        
    public static void main(String[] args) {
        Manager app = new Manager();
        app.run();
    }
    
//    public void initData(){
//        lstAptechEmployee.add(new AptechEmployee("hn", "xh", "001", "dfg", true,LocalDate.of(2015,10,1), "cdc", "sc", "cđ", "dsd", 1, 6));
//        lstAptechEmployee.add(new AptechEmployee("hn", "xh", "002", "abc", false,LocalDate.of(2001,11,11), "cdc", "sc", "abs", "dsd", 3, 10));
//        lstAptechEmployee.add(new AptechEmployee("hn", "xh", "003", "hid", true,LocalDate.of(2005,04,02), "cdc", "sc", "yun", "dsd", 2, 8));
//    }
    
}
