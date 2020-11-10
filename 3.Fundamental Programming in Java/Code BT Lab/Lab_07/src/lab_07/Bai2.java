/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_07;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai2 implements Comparable<Bai2>{
    private String flowerID; //mã nhập
    private String flowerName; // tên hoa
    private String color; // màu hoa
    private int kindOfFlower;//số chủng loại của loài hoa này (Hoa Hồng: Hồng Đỏ, Hồng Vàng, Hồng Trắng => số chủng loại = 3)

    public Bai2() {
    }

    public Bai2(String flowerID, String flowerName, String color, int kindOfFlower) {
        this.flowerID = flowerID;
        this.flowerName = flowerName;
        this.color = color;
        this.kindOfFlower = kindOfFlower;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKindOfFlower() {
        return kindOfFlower;
    }

    public void setKindOfFlower(int kindOfFlower) {
        this.kindOfFlower = kindOfFlower;
    }
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã hoa:");
        flowerID = input.nextLine();
        System.out.printf("\tNhập tên hoa:");
        flowerName = input.nextLine();
        System.out.printf("\tNhập màu hoa:");
        color = input.nextLine();
        System.out.printf("\tNhập loại hoa(1: Hoa Hồng Đỏ, 2: Hoa Hồng vàng, 3: Hoa Hồng Trắng):");
        kindOfFlower = input.nextInt();
    }
    public void display(){
        System.out.println("\tMã hoa: "+flowerID);
        System.out.println("\tTên hoa: "+flowerName);
        System.out.println("\tMàu hoa: "+color);
        System.out.println("\tChủng loại hoa: "+kindOfFlower);
    }
    @Override
    public int compareTo(Bai2 o) {
        return this.getFlowerName().compareTo(o.getFlowerName());
    }
}
