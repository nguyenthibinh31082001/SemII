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
public class OldClassImpl implements IOldInterface{
    @Override
    public void oldMethod() {
        System.out.println("This is old method");
    }
    @Override
    public void newMethod1() {
        IOldInterface.super.newMethod1(); // Call to parent
        System.out.println("and...this is inside child");
    }
}
