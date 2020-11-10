/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

/**
 *
 * @author ADMIN
 */
public class BTTH1<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
    public static void main(String[] args) {
        BTTH1<String> stringGenerics = new BTTH1<String>();
        BTTH1<Integer> integerGenerics = new BTTH1<Integer>();
        
        stringGenerics.setT(new String("Tôi yêu Việt Nam"));
        integerGenerics.setT(new Integer(2015));
        System.out.println("Giá trị tại stringGenerics = " + stringGenerics.getT());
        System.out.println("Giá trị tại integerGenerics = " + integerGenerics.getT());
    }
}
