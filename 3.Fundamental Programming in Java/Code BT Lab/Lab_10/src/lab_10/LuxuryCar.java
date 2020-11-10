/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_10;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LuxuryCar extends Car{
    private float specialRate;

    public LuxuryCar() {
    }

    public LuxuryCar(float specialRate, String name, String producer, int year, int seat, float rootPrice) {
        super(name, producer, year, seat, rootPrice);
        this.specialRate = specialRate;
    }

    public float getSpecialRate() {
        return specialRate;
    }

    public void setSpecialRate(float specialRate) {
        this.specialRate = specialRate;
    }
    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập specialRate: ");
        specialRate = input.nextFloat();
    }
//    @Override
//    public float calculatePrice() {
//        float sumPrice = 0; 
//        sumPrice = rootPrice + calculateTax() + rootPrice * specialRate;
//        return sumPrice;
//    }
    
    public float calculatePrice(float transportCost){
        transportCost = 20000;
        float sumPrice_transportCost = 0;
//        sumPrice_transportCost = calculatePrice() + transportCost;
//        float sumPrice = 20000; 
        sumPrice_transportCost = rootPrice + calculateTax() + rootPrice * specialRate + transportCost;
        return sumPrice_transportCost;
    }
}
