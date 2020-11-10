/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Test {

    List<Car> lstCar = new ArrayList<>();

    
    public Test() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("\t1. Nhập vào một danh sách Luxury\n");
            System.out.printf("\t2. Hiển thị thông tin của danh sách\n");
            System.out.printf("\t3. Sắp xếp danh sách giảm dần bởi giá bán và hiển thị thông tin\n");
            System.out.printf("\t4. Tìm kiếm thông tin theo tên xe nhập vào\n");
            System.out.printf("\t5. Hiển thị tổng giá bán với giá vận chuyển là $ 20,000\n");
            System.out.printf("\t6. Exit\n");
            
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
                    SortDescending();
                    break;
                case 4:
                    searchName(sc);
                    break;
                case 5:
                    sumPrice();
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
        System.out.print("Nhập số lượng xe: ");
        int n = sc.nextInt();
//        Car car;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Xe %d: \n",i+1);
//            car = new Car();
            LuxuryCar luxuryCar = new LuxuryCar();
            luxuryCar.input();
            lstCar.add(luxuryCar);
        }
    }
    
    public void display() {
        System.out.println("Danh sách xe vừa nhập:");
        for(Car f : lstCar){
            f.getInfor();
            System.out.println(" ");
        }
//        System.out.println(" ");
    }
    public void SortDescending(){
    Collections.sort(lstCar, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.calculatePrice() < o2.calculatePrice()) {
                    return 1;
                } else {
                    if (o1.calculatePrice() == o2.calculatePrice()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("-Danh sách giá bán giảm dần là: ");
        for (int i = 0; i < lstCar.size(); i++) {
            lstCar.get(i).getInfor();
            System.out.println(" ");
        }
    }
     public void searchName(Scanner sc){
        Car searchCar;
        Car setCar = new Car();
        int i;
       
        System.out.printf("Nhập tên xe cần tìm: ");
        sc.nextLine();
        String enterCar = sc.nextLine();
        setCar.setName(enterCar);
        System.out.println("Dang sách tìm thấy: ");
        for ( i = 0; i < lstCar.size(); i++){
            searchCar = lstCar.get(i);
            if(searchCar.getName().contains(enterCar)){
                searchCar.getInfor();
            }
        }
//        if(i == lstVehicles.size()){
//            System.out.println("Không tìm thấy loại xe này " +enterVeh);
//        }
        
    }
     public void sumPrice(){ 
//         System.out.println("Danh sách xe: ");
//        for(Car f : lstCar){
//            LuxuryCar luxuryCar = new LuxuryCar();
//            System.out.println("asd: "+luxuryCar.calculatePrice(0));
//            System.out.println(" ");
//        }
     }
    
    
    public static void main(String[] args) {
        Test app = new Test();
        app.run();
    }
    
}
