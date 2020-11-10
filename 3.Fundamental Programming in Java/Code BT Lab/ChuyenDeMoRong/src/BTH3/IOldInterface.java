/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH3;

/**
 *
 * @author Admin
 */
public interface IOldInterface {
    public void oldMethod();
    default void newMethod1() {
        System.out.println("This is new 1");
    }
    default void newMethod2() {
        System.out.println("This is new 2");
    }
}
