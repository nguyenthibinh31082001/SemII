/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import work.Work;

/**
 *
 * @author Admin
 */
public class ManagerWorkingOfBank{

    List<Work> lstWork = new ArrayList<>();

    
    public ManagerWorkingOfBank() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
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
                    SortAscending();
                    break;
                case 4:
                    SortDecending();
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
        for(Work f : lstWork){
            f.display();
            System.out.println(" ");
        }
//        System.out.println(" ");
    }
    public void SortAscending(){
        Collections.sort(lstWork) ;
        System.out.println("Danh sách sắp xếp tăng dần theo tên công việc là: ");
        for(Work f : lstWork){
            System.out.println("");
            f.display();
        }
    }
    
    public void SortDecending(){
//        Work work;
//        for(int i = 0 ; i< lstWork.size(); i++){
//            work = lstWork.get(i);
//            LocalDate startDate = work.getStartDate();
//            LocalDate endDate = work.getEndDate();
//            long days = ChronoUnit.YEARS.between(startDate, endDate);
//            System.out.println(days);
//    }
            Collections.sort(lstWork, new Comparator<Work>() {
                @Override
                public int compare(Work o1, Work o2) {
                    if (o1.soNgayTh() < o2.soNgayTh()) {
                        return 1;
                    } else {
                        if (o1.soNgayTh() == o2.soNgayTh()) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                }
            });
//        }
    System.out.println("Danh sách giảm dần theo số ngày thực hiện là: ");
        for (int i = 0; i < lstWork.size(); i++) {
            lstWork.get(i).display();
            System.out.println(" ");
        }
    }
    public void search(Scanner sc){
        Work searchWork;
        Work setWork = new Work();
        int i, count = 0;
       
        System.out.printf("Nhập tên công việc cần tìm: ");
        sc.nextLine();
        String enterWork = sc.nextLine();
        setWork.setWorkName(enterWork);
        System.out.println("Dang sách tìm thấy: ");
        for ( i = 0; i < lstWork.size(); i++){
            searchWork = lstWork.get(i);
            if(searchWork.getWorkName().contains(enterWork)){
//                count++;
                searchWork.display();
            }
        }
//        if(i == lstVehicles.size()){
//            System.out.println("Không tìm thấy loại xe này " +enterVeh);
//        }
//        System.out.println("Số người có tên như vậy là: "+count);
    }
        
    public static void main(String[] args) {
        ManagerWorkingOfBank app = new ManagerWorkingOfBank();
        app.run();
    }
    
}
