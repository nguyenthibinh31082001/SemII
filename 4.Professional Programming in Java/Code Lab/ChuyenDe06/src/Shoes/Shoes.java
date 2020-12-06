/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shoes;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Shoes implements Serializable{
    private int id; // Khóa chính
    private String name; // Tên sản phẩm
    private float price; // Giá sản phẩm
    private int year; // Năm sản xuất
    private String description; // Mô tả

    public Shoes() {
    }

    public Shoes(int id, String name, float price, int year, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.year = year;
        this.description = description;
    }

    public Shoes(String name, float price, int year, String description) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.print("\tNhập tên sản phẩm: ");
        this.name = s.nextLine();
        while(true){
            if(this.name.length() > 0 && this.name.length() < 32){
                  break;
              }else{
                  System.err.println("\tTên sản phẩm chỉ giới hạn 32 ký tự !!!");  
                  System.out.printf("\tNhập lại tên sản phẩm: ");
                  name = s.nextLine();
              }
        }
        while (true) {
            try {
                System.out.printf("\tNhập giá: ");
                this.price = s.nextFloat();
                while(price < 0 ){
                    System.err.println("\tGiá phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại giá: ");
                    price = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("\tNhập năm sản xuất:");
                this.year = s.nextInt();
                while(year < 0 ){
                    System.err.println("\tNăm sản xuất phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại năm sản xuất: ");
                    year = s.nextInt();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        s.nextLine();
        System.out.print("\tNhập mô tả:");
        this.description = s.nextLine();
        while(true){
            if(this.description.length() > 0 && this.description.length() < 64){
                  break;
              }else{
                  System.err.println("\tTên sản phẩm chỉ giới hạn 64 ký tự !!!");  
                  System.out.printf("\tNhập lại tên sản phẩm: ");
                  description = s.nextLine();
              }
        }
        System.out.println("\t>>> Cảm ơn! <<<");
    }
    public void output(){
        System.out.printf("%-5d %-20s %-15.2f %-20d %-15s\n",
        this.id,this.name, this.price, this.year, this.description);
    }

    @Override
    public String toString() {
        return "Shoes{" + "id=" + id + ", name=" + name + ", price=" + price + ", year=" + year + ", description=" + description + '}';
    }
    
}
