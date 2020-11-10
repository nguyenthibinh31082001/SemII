/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1_Lab9.truck;

import Bai1_Lab9.Vehicles;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Truck extends Vehicles{
    private int truckload;

    public Truck() {
    }

    public Truck(int truckload, String maker, String model, double price) {
        super(maker, model, price);
        this.truckload = truckload;
    }

    public int getTruckload() {
        return truckload;
    }

    public void setTruckload(int truckload) {
        this.truckload = truckload;
    }
    
    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập xe tải:");
        this.truckload = input.nextInt();
    }
    @Override
    public void display() {
        super.display();
        System.out.println("\tXe tải: " +truckload);
    }
}
