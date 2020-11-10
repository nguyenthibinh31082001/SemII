/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Bai2{
    // Random 1 số ngẫu nhiên từ 1-50:
   static public int a;
    
    static class ThreadA extends Thread{
        @Override
        public void run() {
//            while (true) {                
                Random  rd = new Random();
                synchronized (this){
                    a = rd.nextInt(50);
                    System.out.println("Số ngẫu nhiên: "+a);
                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.err.println(e.getMessage());
//                }
//            }
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
//            while (true) {   
//                try {
                    if(a % 2 == 0){
                        System.out.println("Số ngẫu nhiên này số chẵn!!!");
                    }else{
                        System.out.println("Số ngẫu nhiên này là số lẻ!!!");
                    }
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.err.println(e.getMessage());
//                }
//            }
        }
    }
}