/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1_Lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Vehicles implements IVehicle{
    private String maker;
    private String model;
    public double price;

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicles() {
    }

    public Vehicles(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }
    
    @Override
    public void input() {
       Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập người sản xuất:");
        maker = input.nextLine();
        System.out.printf("\tNhập loại xe:");
        model = input.nextLine();
        System.out.printf("\tNhập giá xe:");
        price = input.nextDouble(); 
    }

    @Override
//    public void display() {
//        System.out.println("\tNgười sản xuất: "+maker);
//        System.out.println("\tLoại xe: "+model);
//        System.out.println("\tGiá xe: "+price);
//    }
    public void display(){
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(maker);
        buider.append("|\t|");
        buider.append(model);
        buider.append("|\t|");
        buider.append(price);
        
        System.out.print(buider.toString());
    }
   
}
