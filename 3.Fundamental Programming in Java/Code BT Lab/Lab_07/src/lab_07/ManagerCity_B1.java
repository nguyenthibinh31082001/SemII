/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ManagerCity_B1 {
    List<Bai1> lstCity = new ArrayList<>();

    public ManagerCity_B1() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("1. Nhập thông tin n thành phố\n");
            System.out.printf("2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("3. Sắp xếp thông tin tăng dần theo tên nước.\n");
            System.out.printf("4. Tìm kiếm thông tin theo cityId\n");
            System.out.printf("5. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-5: ");
            int choice = sc.nextInt();
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstCity);
                    break;
                case 3:
                    sortCountry();
                    break;
                case 4:
                    searchByCityId(sc);
                    break;
                case 'e':
//                    searchByID(sc);
                    break;
                case 'f':
                    
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
        System.out.print("Nhập số thành phố:");
        int n = sc.nextInt();
        Bai1 city;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Thành phố %d: \n",i);
            city = new Bai1();
            city.input();
            lstCity.add(city);
        }
    }
    
    public void display( List<Bai1> lst ){
        for(Bai1 f : lst){
            System.out.println("");
            f.display();
        }
    }
    public void sortCountry(){
        Collections.sort(lstCity) ;
        System.out.println("Danh sách sắp xếp theo tên nước là: ");
        for(Bai1 f : lstCity){
            System.out.println("");
            f.display();
        }
    }
    public void searchByCityId(Scanner sc){
         String ID;
         sc.nextLine();
         System.out.print("Nhập Id thành phố cần tìm: ");
         String searchByCityId = sc.nextLine();
        List<Bai1> lst = new ArrayList<>();
        for(Bai1 f : lstCity){
            if(f.getCityId().contains(searchByCityId)){
                lst.add(f);
            }
        }
         System.out.printf("Danh sách thành phố tìm thấy theo Id: ");
        display(lst);
     }
    public static void main(String[] args) {
        ManagerCity_B1 app = new ManagerCity_B1();
        app.run();
//        int n, choose;
//        Scanner input = new Scanner(System.in);
//        Bai1 b1 = new Bai1();
//        System.out.printf("Nhập số lượng thành phố:");
//        n = input.nextInt();
//        Bai1[] arr;
//        arr = new Bai1[n];
//        do {            
//            System.out.printf("************MENU**********\n");
//            System.out.printf("1. Nhập thông tin n thành phố\n");
//            System.out.printf("2. Hiển thị thông tin vừa nhập\n");
//            System.out.printf("3. Sắp xếp thông tin tăng dần theo tên nước.\n");
//            System.out.printf("4. Tìm kiếm thông tin theo cityId\n");
//            System.out.printf("5. Thoát\n");
//            
//            System.out.printf("Chọn menu để thực hiện: ");
//            choose = input.nextInt();
//            
//            switch(choose){
//                case 1:
//                    for (int i = 0; i < n; i++) {
//                        System.out.printf("Thành phố %d: \n",i);
//                        Bai1 c = new Bai1();
//                        c.inputData();
//                        arr[i] = c;
//                    }
//                    break;
//                case 2:
//                    for(Bai1 c : arr){
//                        c.displayData();
//                        System.out.println(" ");
//                    }
//                    break;
//                case 3:
//                    
//                    break;
//                case 4:
//                    
//                    break;
//                case 5:
//                    System.exit(0);
//                default:
//                    System.out.printf("Vui lòng chọn từ 1-5!!!");
//            } 
//        } while (true);
//        
    }
}
