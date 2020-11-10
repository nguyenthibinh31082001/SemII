/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BTTL2 extends Thread{

    @Override
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập số lượng tỉnh: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] array = new String[n];
        for(int i = 0 ; i< array.length; i++){
            System.out.printf("\tTỉnh %d: ",i+1);
            array[i] = sc.nextLine();
        }
        System.out.println("");
        System.out.printf("Các tỉnh vừa nhập là: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + ", ");
        }
        System.out.println("");
        
        for (int i = 0;i<array.length; i++) {
            Random r = new Random(); 
            int randomTinh =r.nextInt(array.length); 
            System.out.println("\tTỉnh ngẫu nhiên: "+array[randomTinh]); 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        BTTL2 bttl2 = new BTTL2();
        bttl2.start();
    }
    /* Cachs 2: sd 2 thread:
    public static void main(String[] args) {
        String[] cityNames = {
            "ha noi","HCM","da nang","haiphong"
        };
        ThreadA t1 = new ThreadA(cityNames.length);
        ThreadB t2 = new ThreadB(t1, cityNames);
        t1.start();
        t2.start();
    }
    */
}
/* Cachs 2: sd 2 thread:
class ThreadA extends Thread{
    private int num;

    public ThreadA(int num) {
        this.num = num;
    }
    
    public int getRandom(){
        return (int) (Math.random()*num);
    }

    @Override
    public void run() {
        super.run(); 
        
        while (true) {            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.getRandom();
        }
    } 
}

class ThreadB extends Thread{
    ThreadA t;
    String[] cityNames;

    public ThreadB(ThreadA t, String[] cityNames) {
        this.t = t;
        this.cityNames = cityNames;
    }
    @Override
    public void run() {
        while (true) {            
            System.out.println(cityNames[t.getRandom()]);
        }
    }
}
*/