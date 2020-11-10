/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplamthem_lab02;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Run_Bai2 {
    List<HOPSUA_Bai2> lstHopSua = new ArrayList();
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng hộp sữa: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Hộp sữa %d: \n",i+1);
            HOPSUA_Bai2 hOPSUA_Bai2 = new HOPSUA_Bai2();
            hOPSUA_Bai2.input();
            lstHopSua.add(hOPSUA_Bai2);
        }
    }
    
    public void display() {
        System.out.println("Danh sách hộp sữa vừa nhập:");
        System.out.println("Nhãn hiệu\tTrọng lượng\tHạn sử dụng");
        for(HOPSUA_Bai2 f : lstHopSua){
            f.display();
            System.out.println(" ");
        }
    }
//    public void count2003(){
//        int count = 0;
//        for(int i = 0 ; i< lstHopSua.size(); i++){
//            HOPSUA_Bai2 hOPSUA_Bai2 = new HOPSUA_Bai2();
//            Yea
//            if(hOPSUA_Bai2.)
//        }
//    }
    public void sortHSD(){
        Collections.sort(lstHopSua, (HOPSUA_Bai2 o1, HOPSUA_Bai2 o2) -> (int) (o1.Year()- o2.Year()));
        
        System.out.println("Danh sách hạn sử dụng tăng dần là:");
        System.out.println("Nhãn hiệu\tTrọng lượng\tHạn sử dụng");
        for (int i = 0; i < lstHopSua.size(); i++) {
            lstHopSua.get(i).display();
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        Run_Bai2 run_Bai2 = new Run_Bai2();
        run_Bai2.input();
        run_Bai2.display();
        run_Bai2.sortHSD();
    }
}
