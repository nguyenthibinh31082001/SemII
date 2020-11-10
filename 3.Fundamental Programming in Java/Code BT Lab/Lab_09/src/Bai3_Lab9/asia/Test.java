/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3_Lab9.asia;

import Bai3_Lab9.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class Test {
    List<Country> lstCountry = new ArrayList<>();
    
    public Test() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("\t1. Input information for n countries of Asia\n");
            System.out.printf("\t2.  Display information\n");
            System.out.printf("\t3. Sort descending by area and display result\n");
            System.out.printf("\t4. Sort ascending by area and display result\n");
            System.out.printf("\t5. Find information by countryName\n");
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
                    SortAscending();
                    break;
                case 5:
                    searchName(sc);
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
        System.out.printf("Số lượng quốc gia cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
//        Country arrcoutry[] = new Country[n];
        for (int i = 0; i < n; i++) {
            AsiaCountry asiaCountry = new AsiaCountry();
            asiaCountry.input();
            lstCountry.add(asiaCountry);
            System.out.println(" ");
        }
    }
    
    public void display() {
        System.out.println("Name\t  |   Area\t  |   NumberPerson\t  | Location\t");
        for (int i = 0; i < lstCountry.size(); i++) {
            lstCountry.get(i).display();
            System.out.println(" ");
        }
    }
    public void SortDescending(){
    Collections.sort(lstCountry, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.area < o2.area) {
                    return 1;
                } else {
                    if (o1.area == o2.area) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("Danh sách sắp xếp theo thứ tự area giảm dần là: ");
    System.out.println("Name\t  |   Area\t  |   NumberPerson\t  | Location\t");
        for (int i = 0; i < lstCountry.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstCountry.get(i).display();
            System.out.println(" ");
        }
    }
    public void SortAscending(){
    Collections.sort(lstCountry, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.area > o2.area) {
                    return 1;
                } else {
                    if (o1.area == o2.area) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("Danh sách sắp xếp theo thứ tự area tăng dần là: ");
    System.out.println("Name\t  |   Area\t  |   NumberPerson\t  | Location\t");
        for (int i = 0; i < lstCountry.size(); i++) {
//            System.out.println("Khu vực: " + lstCountry.get(i).area);
            lstCountry.get(i).display();
            System.out.println(" ");
        }
    }
    public void searchName(Scanner sc){
        Country searchCou;
        Country setCou = new Country();
        int i;
       
        System.out.printf("Nhập tên quốc gia cần tìm: ");
        sc.nextLine();
        String enterCou = sc.nextLine();
        setCou.setCountryName(enterCou);
        System.out.println("Dang sách tìm thấy: ");
        for ( i = 0; i < lstCountry.size(); i++){
            searchCou = lstCountry.get(i);
            if(searchCou.getCountryName().contains(enterCou)){
                searchCou.display();
            }
        }
//        if(i == lstCountry.size()){
//            System.out.println("Không tìm thấy loại xe này " +enterVeh);
//        }
        
    }

    
    
    public static void main(String[] args) {
        Test app = new Test();
        app.run();
    }
}
