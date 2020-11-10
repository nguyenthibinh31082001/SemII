/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class BTTL1 extends Thread{

    @Override
    public void run() {
        for (int i = 0;i<100; i++) {
            Random  rd = new Random();
            int nb = rd.nextInt(100);
            System.out.println("Số ngẫu nhiên: "+nb);
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        BTTL1 bttl1 = new BTTL1();
        bttl1.start();
    }
}
