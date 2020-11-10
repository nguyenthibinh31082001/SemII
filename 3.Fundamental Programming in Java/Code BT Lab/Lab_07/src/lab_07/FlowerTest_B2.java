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
 * @author Admin
 */
public class FlowerTest_B2 {
    List<Bai2> lstFlower = new ArrayList<>();

    public FlowerTest_B2() {
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("a. Nhập thông tin n loài hoa\n");
            System.out.printf("b. Hiển thị thông tin vừa nhập\n");
            System.out.printf("c. Sắp xếp danh sách tăng dần theo tên hoa\n");
            System.out.printf("d. Tìm kiếm theo flowerName\n");
            System.out.printf("e. Tìm kiếm theo flowerID\n");
            System.out.printf("f. Hiển thị tất cả các loài hoa có màu trắng\n");
            System.out.printf("g. Thoát\n");
            System.out.print("Chọn chức năng a->g: ");
             char  choice = sc.next().charAt(0);
            // Kiem tra nguoi dung chon chuc nang
            switch(choice){
                case 'a':
                    input(sc);
                    break;
                case 'b':
                    display(lstFlower);
                    break;
                case 'c':
                    sort();
                    break;
                case 'd':
                    search(sc);
                    break;
                case 'e':
                    searchByID(sc);
                    break;
                case 'f':
                    displayKindOfFlower(sc);
                    break;
                case 'g':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ a-g!!!");
            }
        }while(true);
    }
    
    public void input(Scanner sc){
        System.out.print("Nhập số lượng hoa:");
        int n = sc.nextInt();
        Bai2 flower;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Loại hoa %d: \n",i);
            flower = new Bai2();
            flower.input();
            lstFlower.add(flower);
        }
    }
    
    public void display( List<Bai2> lst ){
        for(Bai2 f : lst){
            System.out.println("");
            f.display();
        }
    }
    
    public void sort(){
        Collections.sort(lstFlower) ;
        System.out.println("Danh sách sắp xếp theo tên là: ");
        for(Bai2 f : lstFlower){
            System.out.println("");
            f.display();
        }
    }
    
     public void search(Scanner sc){
         sc.nextLine();
         System.out.print("Nhập tên hoa cần tìm: ");
         String search = sc.nextLine();
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstFlower){
            if(f.getFlowerName().contains(search)){
                lst.add(f);
            }
        }
         System.out.printf("Danh sách hoa tìm thấy theo tên: ");
        display(lst);
    }
     
     public void searchByID(Scanner sc){
         String ID;
         sc.nextLine();
         System.out.print("Nhập Id hoa cần tìm: ");
         String searchByID = sc.nextLine();
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstFlower){
            if(f.getFlowerID().contains(searchByID)){
                lst.add(f);
            }
        }
         System.out.printf("Danh sách hoa tìm thấy theo Id: ");
        display(lst);
     }
     public void displayKindOfFlower(Scanner sc){
        List<Bai2> lst = new ArrayList<>();
        for(Bai2 f : lstFlower){
            if(f.getKindOfFlower() == 3){
                System.out.println("");
                lst.add(f);
            }
        }
         System.out.printf("Các loài hoa có màu trắng là: ");
        display(lst);
     }
     public void searchByKindOfFlower(Scanner sc){
         int KindOfFlower; 
     }
     public static void main(String[] args) {
        FlowerTest_B2 app = new FlowerTest_B2();
        app.run();
//        int n, choose;
//        Scanner input = new Scanner(System.in);
//        Bai2 b1 = new Bai2();
//        System.out.printf("Nhập số lượng hoa:");
//        n = input.nextInt();
//        Bai2[] arr;
//        arr = new Bai2[n];
//        do {            
//            System.out.printf("************MENU**********\n");
//            System.out.printf("1. Nhập thông tin n loài hoa\n");
//            System.out.printf("2. Hiển thị thông tin vừa nhập\n");
//            System.out.printf("3. Sắp xếp danh sách tăng dần theo tên hoa\n");
//            System.out.printf("4. Tìm kiếm theo flowerID\n");
//            System.out.printf("5. Hiển thị tất cả các loài hoa có màu trắng\n");
//            System.out.printf("6. Thoát\n");
//            
//            System.out.printf("Chọn menu để thực hiện: ");
//            choose = input.nextInt();
//            
//            switch(choose){
//                case 1:
//                    for (int i = 0; i < n; i++) {
//                        System.out.printf("Loại hoa %d: \n",i);
//                        Bai2 fl = new Bai2();
//                        fl.inputData();
//                        arr[i] = fl;
//                    }
//                    break;
//                case 2:
//                    for(Bai2 fl : arr){
//                        fl.displayData();
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
//                    
//                    break;
//                case 6:
//                    System.exit(0);
//                default:
//                    System.out.printf("Vui lòng chọn từ 1-5!!!");
//            } 
//        } while (true);
//        
    }
}
