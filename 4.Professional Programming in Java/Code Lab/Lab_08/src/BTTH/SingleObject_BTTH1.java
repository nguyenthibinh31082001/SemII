package BTTH;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class SingleObject_BTTH1 {
    
    private static SingleObject_BTTH1 instance = new SingleObject_BTTH1();

    public SingleObject_BTTH1() {
    }

    public static SingleObject_BTTH1 getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
    
    public static void main(String[] args) {
        SingleObject_BTTH1 bTTH1 = SingleObject_BTTH1.getInstance();
        
        bTTH1.showMessage();
    }
}
