/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MyThread_BTTH4 implements Runnable{

    String name;

    public MyThread_BTTH4(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " - is running");
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread_BTTH4.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
class DemoExcutorService{
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            MyThread_BTTH4 mt = new MyThread_BTTH4("Thread-" + (i + 1));
            service.submit(mt);
        }
    }
}