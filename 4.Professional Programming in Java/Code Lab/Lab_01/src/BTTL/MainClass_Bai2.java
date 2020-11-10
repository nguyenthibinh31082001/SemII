/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MainClass_Bai2 {
    List<Bai_2> lstBai_2 = new ArrayList<>();

    
    public MainClass_Bai2() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n sinh viên\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-3: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-3!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Sinh viên %d: \n",i+1);
            Bai_2 bai_2 = new Bai_2();
            bai_2.input();
            lstBai_2.add(bai_2);
        }
    }
    
    public void display() {
        System.out.println("Danh sách sinh viên vừa nhập:");
        System.out.println("rollNo\t\tfullname\tdeskphone\tcellphone\temail\t\tyearOfBirth");
        for(Bai_2 f : lstBai_2){
            f.display();
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        MainClass_Bai2 mainClass_Bai2 = new MainClass_Bai2();
        mainClass_Bai2.run();
    }
}
