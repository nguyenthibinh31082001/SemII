/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BookManager_Bai4 {
    List<Bai_4> lstBai_4 = new ArrayList<>();

    
    public BookManager_Bai4() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n cuốn sách\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Sắp xếp giảm dần theo giá.\n");
            System.out.printf("\t4. Thoát\n");
            
            System.out.printf("Chọn chức năng 1-4: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortDESC();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-4!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng cuốn sách: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Cuốn sách %d: \n",i+1);
            Bai_4 bai_4 = new Bai_4();
            bai_4.nhap();
            lstBai_4.add(bai_4);
        }
    }
    
    public void display() {
        System.out.println("Danh sách cuốn sách vừa nhập:");
        System.out.println("isbn\t\tbookName\tauthor\t\tpublisher\tprice");
        for(Bai_4 f : lstBai_4){
            f.display();
            System.out.println(" ");
        }
    }
    private void sortDESC() {
        Collections.sort(lstBai_4, (Bai_4 o1, Bai_4 o2)-> (int) (o2.getPrice() - o1.getPrice()));
        
        System.out.println("Danh sách cuốn sách giảm dần là:");
        System.out.println("isbn\t\tbookName\tauthor\t\tpublisher\tprice");
        for(Bai_4 f : lstBai_4){
            f.display();
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        BookManager_Bai4 bookManager_Bai4 = new BookManager_Bai4();
        bookManager_Bai4.run();
    }

    
}
