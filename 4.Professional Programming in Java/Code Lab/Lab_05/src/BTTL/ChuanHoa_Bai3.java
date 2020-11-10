/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;
import java.util.StringTokenizer;
import static sun.text.normalizer.NormalizerImpl.convert;

/**
 *
 * @author Admin
 */
public class ChuanHoa_Bai3 {
    static public String a;
    
    
    static class ThreadA extends Thread{
        String[] listName = {"nGuYeN hOa bInH","lE tHaNh hAi","tRan mAnH tIeN","lE qUAnG qUaN"};
    
        @Override
        public void run() {
            for(int i = 0; i< 5; i++){               
                Random  rd = new Random();
                synchronized (this){
                    int randomSV =rd.nextInt(listName.length); 
                    a = listName[randomSV];
                    System.out.println("Tên: "+ a);
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
            for(int i = 0; i< 5; i++){  
                StringTokenizer s1= new StringTokenizer(a);
                StringBuffer kq= new StringBuffer();
                while(s1.hasMoreTokens()){
                    String s2= s1.nextToken();
                    s2=s2.toLowerCase();
                    String s3= s2.substring(0, 1);
                    s2=s2.replaceFirst(s3, s3.toUpperCase());
                    kq.append(s2).append(" ");

                }
                System.out.println("Tên sau khi chuẩn hóa: "+kq);
                
                try {
//
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }  
        }
    }
    
}