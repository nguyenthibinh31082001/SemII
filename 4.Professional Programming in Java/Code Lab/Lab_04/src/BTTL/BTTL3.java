/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BTTL3 extends Thread{

    String name;
    
    public BTTL3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random  rd = new Random();
        int nb = rd.nextInt(100);
        
        for (int i = 0; i < 1; i++) {
            System.out.println(name+" số ngẫu nhiên: "+nb);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BTTL3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        BTTL3 T1 = new BTTL3("Thread-1:");
        T1.start();
        BTTL3_2 T2 = new BTTL3_2("Thread-2:");
        T2.start();
    }
}
class BTTL3_2 extends Thread{
    String name;
    
    public BTTL3_2(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            LocalTime hour = java.time.LocalTime.now();
            System.out.println(name+" giờ hệ thống: "+hour.getHour()+":"+hour.getMinute()+":"+hour.getSecond());
            System.out.println("Bây giờ là "+hour.getHour()+":"+hour.getMinute());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BTTL3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}