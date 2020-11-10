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
public class ChanLe_Bai5 {
    // Random 1 số ngẫu nhiên từ 1-100 và mỗi giây sẽ sinh ra một số:
    static public int a;
    
    
    static class ThreadA extends Thread{
        @Override
        public void run() {
            while (true) {                
                Random  rd = new Random();
                synchronized (this){
                    a = rd.nextInt(100);
                    System.out.println("Số ngẫu nhiên: "+a);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        ThreadA T1 = new ThreadA();
        T1.start();
        ThreadB T2 = new ThreadB();
        T2.start();
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            while (true) {   
                try {
                    if(a % 2 == 0){
                        System.out.println("Số ngẫu nhiên "+ a +" này là số chẵn!!!");
                    }else{
                        System.out.println("Số ngẫu nhiên "+ a +" này là số lẻ!!!");
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
