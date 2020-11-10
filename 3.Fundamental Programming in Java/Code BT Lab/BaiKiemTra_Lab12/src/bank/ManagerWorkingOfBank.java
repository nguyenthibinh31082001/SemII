/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import work.Work;

/**
 *
 * @author ADMIN
 */
public class ManagerWorkingOfBank {

    List<Work> lstWork = new ArrayList<>();

    
    public ManagerWorkingOfBank() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập vào thông tin n công việc của ngân hàng\n");
            System.out.printf("\t2. Hiển thị danh sách thông tin các công việc \n");
            System.out.printf("\t3. Sắp xếp và hiển thị danh sách tăng dần theo tên công việc \n");
            System.out.printf("\t4. Sắp xếp và hiển thị danh sách giảm dần theo số ngày thực hiện \n");
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
                    sortName(sc);
                    break;
                case 4:
                    SortNgayTH();
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
            WorkOfBank workOfBank = new WorkOfBank();
            workOfBank.input();
            lstWork.add(workOfBank);
        }
    }
    
    public void display() {
        System.out.println("Danh sách công việc vừa nhập:");
        System.out.println("Mã\tTên\tNgày bắt đầu\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tPhòng ban\tSố NV\tCấp duyệt");
        for(Work f : lstWork){
            f.display();
            System.out.println(" ");
        }
//        System.out.println(" ");
    }
    public void sortName(Scanner sc) {
        Collections.sort(
                lstWork,
                (Work o1, Work o2) -> o1.getWorkName().compareTo(o2.getWorkName())
        );
        System.out.println("Danh sách tên cầu thủ tăng dần là:");
        System.out.println("Mã\t\tTên\tNgày bắt đầu\t\tNgày kết thúc\tTổng chi phí\tChi phí 1 ngày\tPhòng ban\tSố NV\tCấp duyệt");
        for (int i = 0; i < lstWork.size(); i++) {
            lstWork.get(i).display();
            System.out.println(" ");
        }
    }
    
    public void SortNgayTH(){
        Collections.sort(lstWork, 
                (Work o1, Work o2) -> (int) (o2.NgayTH() - o1.NgayTH()));
        System.out.println("Danh sách số ngày thực hiện giảm dần là:");
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\tPhí chuyển nhượng\tLương theo tuần\tLương theo tháng\tLương theo năm");
        for (int i = 0; i < lstWork.size(); i++) {
            lstWork.get(i).display();
            System.out.println(" ");
        }
//        Work work;
//        for(int i = 0 ; i< lstWork.size(); i++){
//            work = lstWork.get(i);
//            LocalDate startDate = work.getStartDate();
//            LocalDate endDate = work.getEndDate();
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
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\tPhí chuyển nhượng\tLương theo tuần\tLương theo tháng\tLương theo năm");
        for (Work f : lstWork) {
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
        ManagerWorkingOfBank app = new ManagerWorkingOfBank();
        app.run();
    }
    
}
