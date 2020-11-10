/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1_Lab9.car;

import Bai1_Lab9.Vehicles;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Car extends Vehicles{
    private String color;

    public Car() {
    }

    public Car(String color, String maker, String model, double price) {
        super(maker, model, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập màu xe:");
        this.color = input.nextLine();
    }
    @Override
    public void display() {
        super.display();
        System.out.println("\tMàu xe: " +color);
    }
}
