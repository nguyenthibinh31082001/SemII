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
public class ImplOperationSubtract implements ITinhToan, IAccuracy{
    private int accuracy;

    @Override
    public void doOperation(float num1, float num2) {
        System.out.printf("\n");
        System.out.printf("Phép trừ = %." + this.accuracy + "f", (num1 - num2));
    }

    @Override
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
