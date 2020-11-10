/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1_Lab9.test;

import Bai1_Lab9.Vehicles;
import Bai1_Lab9.car.Car;
import Bai1_Lab9.truck.Truck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Test {
    List<Vehicles> lstVehicles = new ArrayList<>();

    
    public Test() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("\t1. Input\n");
            System.out.printf("\t2. Display\n");
            System.out.printf("\t3. Sort by price\n");
            System.out.printf("\t4. Search by model\n");
            System.out.printf("\t5. Exit\n");
            
            System.out.printf("Chọn chức năng 1-5: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println("Danh sách các xe trước khi sắp xếp là:");
                    display();
                    SortAscending();
                    SortDescending();
                    break;
                case 4:
                    searchModel(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-5!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.printf("Nhập thông tin cho Car chọn (C), Nhập thông tin cho Truck chọn (T): ");
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
                Car car = new Car();
                car.input();
                lstVehicles.add(car);
                System.out.println(" ");
            } else if((c == 'T' || c == 't')){
                Truck truck = new Truck();
                truck.input();
                lstVehicles.add(truck);
                System.out.println(" ");
            }
        }
    }
    
    public void display() {
        System.out.println("Maker\t  |   model\t  |   price\t ");
        for (int i = 0; i < lstVehicles.size(); i++) {
            if (lstVehicles.get(i) instanceof Car) {
                ((Car) lstVehicles.get(i)).display();
                System.out.println(" ");
            } else {
                ((Truck) lstVehicles.get(i)).display();
                System.out.println(" ");
            }
        }
    }
    public void SortAscending(){
    Collections.sort(lstVehicles, new Comparator<Vehicles>() {
            @Override
            public int compare(Vehicles o1, Vehicles o2) {
                if (o1.price > o2.price) {
                    return 1;
                } else {
                    if (o1.price == o2.price) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("-Danh sách sắp xếp giá tăng dần là: ");
    System.out.println("Maker\t  |   model\t  |   price\t ");
        for (int i = 0; i < lstVehicles.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstVehicles.get(i).display();
            System.out.println(" ");
        }
    }
    public void SortDescending(){
    Collections.sort(lstVehicles, new Comparator<Vehicles>() {
            @Override
            public int compare(Vehicles o1, Vehicles o2) {
                if (o1.price < o2.price) {
                    return 1;
                } else {
                    if (o1.price == o2.price) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("-sDanh sách sắp xếp giá giảm dần là: ");
    System.out.println("Maker\t  |   model\t  |   price\t ");
        for (int i = 0; i < lstVehicles.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstVehicles.get(i).display();
            System.out.println(" ");
        }
    }
     public void searchModel(Scanner sc){
        Vehicles searchVeh;
        Vehicles setVeh = new Vehicles();
        int i;
       
        System.out.printf("Nhập mẫu xe cần tìm: ");
        sc.nextLine();
        String enterVeh = sc.nextLine();
        setVeh.setModel(enterVeh);
        System.out.println("Dang sách tìm thấy: ");
        for ( i = 0; i < lstVehicles.size(); i++){
            searchVeh = lstVehicles.get(i);
            if(searchVeh.getModel().contains(enterVeh)){
                searchVeh.display();
            }
        }
//        if(i == lstVehicles.size()){
//            System.out.println("Không tìm thấy loại xe này " +enterVeh);
//        }
        
    }

    
    
    public static void main(String[] args) {
        Test app = new Test();
        app.run();
    }
}
