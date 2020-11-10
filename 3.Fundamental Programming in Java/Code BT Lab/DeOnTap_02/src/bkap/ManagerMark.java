/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import mark.Mark;

/**
 *
 * @author Admin
 */
public class ManagerMark {

    List<BKapStudent> lstBKapStudent = new ArrayList<>();
    
    public void run(){
        Scanner sc = new Scanner(System.in);
//        initData();
        do{
            System.out.printf("\t************MENU**********\n");
            System.out.println("\t1. Nhập vào thông tin điểm thi của n sinh viên Bách Khoa Aptech");
            System.out.println("\t2. Hiển thị thông tin vừa nhập");
            System.out.println("\t3. Sắp xếp và hiển thị thông tin tăng giảm theo học bổng nhận được");
            System.out.println("\t4. Sắp xếp và hiển thị thông tin tăng giảm dần theo tên lớp");
            System.out.println("\t5. Tìm kiếm thông tin sinh viên theo tên lớp");
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
                    sortScholarShipDESC(sc);
                    sortScholarShipASC(sc);
                    break;
                case 4:
                    sortclassNameASC(sc);
                    sortclassNameDESC(sc);
                    break;
                case 5:
                    searchclassName(sc);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-6!!!");
            }
        }while(true);
    }
    private void input(Scanner sc) {
        System.out.printf("Số lượng sinh viên cần nhập: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên " + (i + 1)+" :");
//            Mark mark = new Mark();
            BKapStudent bKapStudent = new BKapStudent();
            bKapStudent.input();
            lstBKapStudent.add(bKapStudent);
        }
    }
    
    private void display() {
        System.out.println("Họ tên\tGiới tính\tTên lớp\tĐiểm C\tĐiểm HTML\tĐiểm SQL\tĐiểm PHP\tĐiểm TB\t\tTên khóa\tHọc bổng");
        for (Mark f : lstBKapStudent) {
            f.display();
            System.out.println(" ");
            System.out.println("=================================================================================================================================");
        }
    }
    private void sortScholarShipDESC(Scanner sc) {
        Collections.sort(lstBKapStudent, 
                (BKapStudent o1, BKapStudent o2) -> (int) (o2.getScholarShip() - o1.getScholarShip()));
        System.out.println("Danh sách học bổng giảm dần là:");
                System.out.println("Họ tên\tGiới tính\tTên lớp\tĐiểm C\tĐiểm HTML\tĐiểm SQL\tĐiểm PHP\tĐiểm TB\t\tTên khóa\tHọc bổng");
        for (int i = 0; i < lstBKapStudent.size(); i++) {
            lstBKapStudent.get(i).display();
            System.out.println("=================================================================================================================================");
        }
    }
    private void sortScholarShipASC(Scanner sc) {
        Collections.sort(lstBKapStudent, 
                (BKapStudent o1, BKapStudent o2) -> (int) (o1.getScholarShip() - o2.getScholarShip()));
        System.out.println("Danh sách học bổng tăng dần là:");
                System.out.println("Họ tên\tGiới tính\tTên lớp\tĐiểm C\tĐiểm HTML\tĐiểm SQL\tĐiểm PHP\tĐiểm TB\t\tTên khóa\tHọc bổng");
        for (int i = 0; i < lstBKapStudent.size(); i++) {
            lstBKapStudent.get(i).display();
            System.out.println("=================================================================================================================================");
        }
    }
    private void sortclassNameASC(Scanner sc) {
        Collections.sort(
                lstBKapStudent,
                (BKapStudent o1, BKapStudent o2) -> o1.getClassName().compareTo(o2.getClassName())
        );
        System.out.println("Danh sách tên lớp tăng dần là:");
        System.out.println("Họ tên\tGiới tính\tTên lớp\tĐiểm C\tĐiểm HTML\tĐiểm SQL\tĐiểm PHP\tĐiểm TB\t\tTên khóa\tHọc bổng");
        for (int i = 0; i < lstBKapStudent.size(); i++) {
            lstBKapStudent.get(i).display();
            System.out.println("=================================================================================================================================");
        }
    }
    private void sortclassNameDESC(Scanner sc) {
        Collections.sort(
                lstBKapStudent,
                (BKapStudent o1, BKapStudent o2) -> o2.getClassName().compareTo(o1.getClassName())
        );
        System.out.println("Danh sách tên lớp giảm dần là:");
        System.out.println("Họ tên\tGiới tính\tTên lớp\tĐiểm C\tĐiểm HTML\tĐiểm SQL\tĐiểm PHP\tĐiểm TB\t\tTên khóa\tHọc bổng");
        for (int i = 0; i < lstBKapStudent.size(); i++) {
            lstBKapStudent.get(i).display();
            System.out.println("=================================================================================================================================");
        }
    }
    private void searchclassName(Scanner sc) {
        System.out.printf("Nhập tên lớp cần tìm: ");
        sc.nextLine();
        String name = sc.nextLine();
        int flag = 0;
        System.out.println("Họ tên\tGiới tính\tTên lớp\tĐiểm C\tĐiểm HTML\tĐiểm SQL\tĐiểm PHP\tĐiểm TB\t\tTên khóa\tHọc bổng");
        for (BKapStudent f : lstBKapStudent) {
            if (f.getClassName().toLowerCase().contains(name.trim().toLowerCase())) {
                f.display();
                flag++;
                System.out.println("=================================================================================================================================");
            }
        }

        if (flag == 0) {
            System.err.println("Không tìm tên lớp có tên là: " + name);
        }
    }
    public static void main(String[] args) {
        ManagerMark managerPlayer = new ManagerMark();
        managerPlayer.run();
    }
//    public void initData(){
//        lstBKapStudent.add(new BKapStudent("cvbn", 213, "binn", true, "c1907", 19,18,20,17));
//        lstBKapStudent.add(new BKapStudent("scz", 54, "anna", false, "b1907", 10,18,11,9));
//        lstBKapStudent.add(new BKapStudent("ưeqd", 987, "lena", true, "h1907", 12,10,9,15));    
//    }

}
