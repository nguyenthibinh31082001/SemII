/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author ADMIN
 */
public class Bai_1 {
    List<Integer> lstSoNguyen = new ArrayList();
    
    public void input() {
        Scanner sc =  new Scanner(System.in);
        System.out.printf("Nhập số lượng phần tử: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("[%d] = ",i+1);
            int m = sc.nextInt();
            lstSoNguyen.add(m);
        }
        
    }
    public void display() {
        System.out.printf("Danh sách số nguyên vừa nhập:");
        System.out.println(lstSoNguyen);
    }
    public void sortASC(){
        System.out.printf("Danh sách số nguyên tăng dần là:");
        lstSoNguyen.sort((o1, o2) -> o1 - o2);
        System.out.println(lstSoNguyen);
    }
    public static void main(String[] args) {
        Bai_1 SoNguyen = new Bai_1();
        SoNguyen.input();
        SoNguyen.display();
        SoNguyen.sortASC();
    }
}
