/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class PrintNumber_BTTH3 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("#" + i);    
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintNumber_BTTH3.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }
    
    
}
class PrintCharacter implements Runnable {

    @Override
    public void run() {
        for (int i = 'A'; i <'Z'; i++) {
            System.out.println("\t" + (char) i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintCharacter.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }
    
}
class MainClass{
    public static void main(String[] args) {
        PrintNumber_BTTH3 printN = new PrintNumber_BTTH3();
        Thread printC = new Thread(new PrintCharacter());
        printN.start();
        printC.start();
    }
}