/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2_Lab9.yamaha;

import Bai2_Lab9.Motor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Yamaha {
    List<Motor> lstMotor = new ArrayList<>();
    
    public Yamaha(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.printf("************MENU**********\n");
            System.out.printf("\t1. Input\n");
            System.out.printf("\t2. Display\n");
            System.out.printf("\t3. Sort\n");
            System.out.printf("\t4. Search\n");
            System.out.printf("\t5. Exit\n");
            
            System.out.printf("Chọn chức năng 1-5: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstMotor);
                    break;
                case 3:
                    System.out.println("Danh sách các xe trước khi sắp xếp là:");
                    display(lstMotor);
                    System.out.println("Danh sách thời gian bảo hành tăng dần là:");
                    sortAscending();
                    System.out.println("Danh sách thời gian bảo hành giảm dần là:");
                    SortDescending();
                    break;
                case 4:
                    searchSerius(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-5!!!");
            }
        }
    }
    public void input(Scanner sc) {
        System.out.printf("Nhập thông tin cho xe serius (S), Nhập thông tin cho xe jupiter chọn (J):");
        String str =  sc.nextLine();
         char c = ' ';
        if(str.length() >= 0){
             c = sc.nextLine().charAt(0);
        }
       
        System.out.printf("Số lượng xe cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (c == 'C' || c == 'c') {
                Jupiter xe = new Jupiter();
                xe.inputInfor();
                lstMotor.add(xe);
            } else {
                Serius xe = new Serius();
                System.out.println("");
                xe.inputInfor();
                lstMotor.add(xe);
            }
        }
    }
    public void display(List<Motor> lstXe1) {
        for (int i = 0; i < lstMotor.size(); i++) {
            if (lstMotor.get(i) instanceof Jupiter) {
                ((Jupiter) lstMotor.get(i)).displayInfor();
            } else {
                 System.out.println("");
                ((Serius) lstMotor.get(i)).displayInfor();
            }
        }
    }

    
     private void sortAscending() {
        
        Collections.sort(lstMotor, new Comparator<Motor>() {
            @Override
            public int compare(Motor o1, Motor o2) {
                if((o1 instanceof Jupiter) && (o2 instanceof Jupiter)){
                    return ((Jupiter)o1).getWarranty() - ((Jupiter)o2).getWarranty();
                }else if((o1 instanceof Serius) && (o2 instanceof Serius)){
                      return ((Serius)o1).getWarranty() - ((Serius)o2).getWarranty() ;
                }else{
                    return 0;
                }
            }
        });
//        System.out.println("Danh sách sắp xếp tăng dần là: ");
        display(lstMotor);
    }
    
     private void SortDescending() {
        
        Collections.sort(lstMotor, new Comparator<Motor>() {
            @Override
            public int compare(Motor o1, Motor o2) {
                if((o1 instanceof Jupiter) && (o2 instanceof Jupiter)){
                    return ((Jupiter)o2).getWarranty() - ((Jupiter)o1).getWarranty();
                }else if((o1 instanceof Serius) && (o2 instanceof Serius)){
                      return ((Serius)o2).getWarranty() - ((Serius)o1).getWarranty() ;
                }else{
                    return 0;
                }
            }
        });
//        System.out.println("Danh sách sắp xếp giảm dần là: ");
        display(lstMotor);
    }
    
    public void searchSerius(Scanner sc){
        Serius searchSer;
        Serius setSer = new Serius();
        int i;

        System.out.printf("Nhập loại xe cần tìm: ");
        sc.nextLine();
        String enterSer = sc.nextLine();
        setSer.setCode(enterSer);
        System.out.println("Dang sách tìm thấy: ");
        for ( i = 0; i < lstMotor.size(); i++){
            searchSer = (Serius) lstMotor.get(i);
            if(searchSer.getName().contains(enterSer)){
                searchSer.displayInfor();
            }
        }
        if(i == lstMotor.size()){
            System.out.println("Không tìm thấy loại xe này " +enterSer);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Yamaha app = new Yamaha();
        app.run();
    }

    
}
