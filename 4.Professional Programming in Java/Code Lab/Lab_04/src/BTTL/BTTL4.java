/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class BTTL4 extends Thread{
    
    String name;
    
    public BTTL4(String name) {
        this.name = name;
    }

    String[] arrSinhVien = new String[]{"Hoàng", "Tuấn", "Quỳnh", "Trang", "Vũ"};
    

    @Override
    public void run() {
        for(int i = 0 ; i< arrSinhVien.length; i++){
            Random r = new Random(); 
            int randomSV =r.nextInt(arrSinhVien.length); 
            System.out.println("Sinh viên: "+arrSinhVien[randomSV]); 
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
     public static void main(String[] args) {
        BTTL4 T1 = new BTTL4("Thread A: ");
        T1.start();
        BTTL4_2 T2 = new BTTL4_2("Thread B: ");
        T2.start();
    }
    
}
class BTTL4_2 extends Thread{
    String name;
    
    public BTTL4_2(String name) {
        this.name = name;
    }
    
    String[] arrHanhDong = new String[]{"...đang ăn", "...đang ngủ", "...đang xem phim",
        "...đang làm bài tập", "...đang học"};
    @Override
    public void run() {
        for(int i = 0 ; i< arrHanhDong.length; i++){
            Random r = new Random(); 
            int randomHD =r.nextInt(arrHanhDong.length); 
            System.out.println("Hành động: "+arrHanhDong[randomHD]); 
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
   
}