/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_01;

/**
 *
 * @author ADMIN
 */
public class MainClass {
    public void phepTinh(ITinhToan phepTinh, float num1, float num2) {
        phepTinh.doOperation(num1, num2);
    }
    
    public static void main(String[] args) {
        MainClass main = new MainClass();

        ImplOperationAdd add = new ImplOperationAdd();
        add.setAccuracy(IAccuracy.TWO_NUMBER);
        main.phepTinh(add, 6, 9);

        ImplOperationSubtract sub = new ImplOperationSubtract();
        sub.setAccuracy(IAccuracy.THREE_NUMBER);
        main.phepTinh(sub, 9, 6);
        ImplOperationMultiply multi = new ImplOperationMultiply();
        multi.setAccuracy(IAccuracy.FOUR_NUMBER);
        main.phepTinh(multi, 3, 3);
    }
}
