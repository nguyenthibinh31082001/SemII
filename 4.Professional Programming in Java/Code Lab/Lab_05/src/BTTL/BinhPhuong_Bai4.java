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
public class BinhPhuong_Bai4 {
    static public int a;
    
    
    static class Thread1 extends Thread{
    
        @Override
        public void run() {
            for(int i=1; i<10;i++) {                
                Random  rd = new Random();
                synchronized (this){
                    a = rd.nextInt(50);
                    System.out.println("Số ngẫu nhiên: "+a);
                }
                if(a % 2 == 0){
                    Thread2.currentThread();
                }else{
                    
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
        Thread1 T1 = new Thread1();
        T1.start();
        Thread2 T2 = new Thread2();
        T2.start();
        Thread3 T3 = new Thread3();
        T3.start();
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            int answer = 0;
            for(int i=1; i<10;i++) { 
//                 if(a % 2 == 0){
                        if(a % i == 0) {
                            answer++;
                        }
                    System.out.println("Ước của "+ a +" là: "+answer);
//                }
                try {
                   
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    static class Thread3 extends Thread{
        @Override
        public void run() {
            int answer = 0;
            for(int i=1; i<10;i++) { 
                 if(a % 2 == 0){
//                     
                    System.out.println("Bình phương "+ a +" là: "+a*a);
                }
                try {
                   
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}