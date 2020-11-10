/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ManagerPlayer {

    List<FootBallPlayer> lstFootBallPlayer = new ArrayList<>();
    
    public void run(){
        Scanner sc = new Scanner(System.in);
       
        do{
            System.out.printf("\t************MENU**********\n");
            System.out.println("\t1. Nhập thông tin cho n cầu thủ bóng đá");
            System.out.println("\t2. Hiển thị thông tin các cầu thủ");
            System.out.println("\t3. Sắp xếp danh sách tăng dần theo tổng lương theo năm và hiển thị");
            System.out.println("\t4. Sắp xếp danh sách giảm dần theo tổng lương theo năm và hiển thị");
            System.out.println("\t5. Sắp xếp danh sách tăng dần theo tên các cầu thủ và hiển thị");
            System.out.println("\t6. Tìm kiếm thông tin cầu thủ theo tên đội bóng");
            System.out.printf("\t7. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-7: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortSalaryByYearASC(sc);
                    break;
                case 4:
                    sortSalaryByYearDESC(sc);
                    break;
                case 5:
                    sortName(sc);
                    break;
                case 6:
                    search(sc);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-7!!!");
            }
        }while(true);
    }
    private void input(Scanner sc) {
        System.out.printf("Số lượng cầu thủ cần nhập: ");
        int n = sc.nextInt();
        FootBallPlayer footBallPlayer;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập cầu thủ " + (i + 1)+" :");
            footBallPlayer = new FootBallPlayer();
            footBallPlayer.input();
            lstFootBallPlayer.add(footBallPlayer);
        }
    }
    
    private void display() {

        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\t\tPhí chuyển nhượng\tLương theo tuần\t\tLương theo tháng\tLương theo năm");
        for (FootBallPlayer f : lstFootBallPlayer) {
            f.display();
            System.out.println("======================================================================================================================================================================");
        }
    }
    private void sortSalaryByYearASC(Scanner sc) {
        Collections.sort(lstFootBallPlayer, 
                (FootBallPlayer o1, FootBallPlayer o2) -> (int) (o1.salaryForYear() - o2.salaryForYear()));
        System.out.println("Danh sách tổng lương tăng dần theo năm là:");
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\t\tPhí chuyển nhượng\tLương theo tuần\t\tLương theo tháng\tLương theo năm");
        for (int i = 0; i < lstFootBallPlayer.size(); i++) {
            lstFootBallPlayer.get(i).display();
            System.out.println("======================================================================================================================================================================");
        }
    }
    private void sortSalaryByYearDESC(Scanner sc) {
        Collections.sort(lstFootBallPlayer, 
                (FootBallPlayer o1, FootBallPlayer o2) -> (int) (o2.salaryForYear() - o1.salaryForYear()));
        System.out.println("Danh sách tổng lương giảm dần theo năm là:");
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\t\tPhí chuyển nhượng\tLương theo tuần\t\tLương theo tháng\tLương theo năm");
        for (int i = 0; i < lstFootBallPlayer.size(); i++) {
            lstFootBallPlayer.get(i).display();
            System.out.println("======================================================================================================================================================================");
        }
    }
    private void sortName(Scanner sc) {
        Collections.sort(
                lstFootBallPlayer,
                (FootBallPlayer o1, FootBallPlayer o2) -> o1.getPlayerName().compareTo(o2.getPlayerName())
        );
        System.out.println("Danh sách tên cầu thủ tăng dần là:");
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\t\tPhí chuyển nhượng\tLương theo tuần\t\tLương theo tháng\tLương theo năm");
        for (int i = 0; i < lstFootBallPlayer.size(); i++) {
            lstFootBallPlayer.get(i).display();
            System.out.println("======================================================================================================================================================================");
        }
    }
    private void search(Scanner sc) {
        System.out.printf("Nhập tên đội bóng cần tìm: ");
        sc.nextLine();
        String name = sc.nextLine();
        int flag = 0;
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh\tCâu lạc bộ\tVị trí\t\tPhí chuyển nhượng\tLương theo tuần\t\tLương theo tháng\tLương theo năm");
        for (FootBallPlayer f : lstFootBallPlayer) {
            if (f.getFootballClub().toLowerCase().contains(name.trim().toLowerCase())) {
                f.display();
                flag++;
                System.out.println("======================================================================================================================================================================");
            }
        }

        if (flag == 0) {
            System.out.println("Không tìm thấy đội bóng có tên là: " + name);
        }
    }
    public static void main(String[] args) {
        ManagerPlayer managerPlayer = new ManagerPlayer();
        managerPlayer.run();
    }
}
