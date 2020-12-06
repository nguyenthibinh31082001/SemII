/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesprocedure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Product {
    private int ProductId;
    private String ProductName;
    private float Price;
    private String Producer;
    private LocalDate DateCreated;
    private boolean Status;

    public Product() {
    }

    public Product(int ProductId, String ProductName, float Price, String Producer, LocalDate DateCreated, boolean Status) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Price = Price;
        this.Producer = Producer;
        this.DateCreated = DateCreated;
        this.Status = Status;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String Producer) {
        this.Producer = Producer;
    }

    public LocalDate getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(LocalDate DateCreated) {
        this.DateCreated = DateCreated;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.printf("\tNhập tên sản phẩm: ");
        this.ProductName = s.nextLine();
        while(true){
            if(this.ProductName.length() <= 100 && ProductName.length() > 0){
                  break;
              }else{
                  System.err.println("\tTên sản phẩm phải từ 1-100 ký tự!!!");  
                  System.out.printf("\tNhập lại tên sản phẩm: ");
                  ProductName = s.nextLine();
              }
        }
        while (true) {
            try {
                System.out.printf("\tNhập Price: ");
                this.Price = s.nextFloat();
                while(Price < 0 ){
                    System.err.println("\tPrice phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại Price: ");
                    Price = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        s.nextLine();
        System.out.printf("\tNhập nhà sản xuất: ");
        this.Producer = s.nextLine();
        while(true){
            if(this.Producer.length() <= 100 && Producer.length() > 0){
                  break;
              }else{
                  System.err.println("\tNhà sản xuất phải từ 1-100 ký tự!!!");  
                  System.out.printf("\tNhập lại nhà sản xuất: ");
                  Producer = s.nextLine();
              }
        }
        while (true) {   
            System.out.print("\tNhập DateCreated:");
            try {
                this.DateCreated = LocalDate.parse(s.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                
                break;
            } catch (Exception e) {
                System.err.println("\tNgày không hợp lệ (dd/MM/yyyy)");
            }
        }
        while(true){
            try {
                System.out.printf("\tNhập trạng thái(true/false): ");
                this.Status = s.nextBoolean();
                s.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true/false)!!!");
                s.nextLine();
            }
        }
        
    }
    public void display(){
        System.out.printf("%-5d %-15s %-10.2f %-20s %-15s %-13b\n",
        this.ProductId,this.ProductName, this.Price, this.Producer, this.DateCreated, 
        this.Status);
//        StringBuilder builder = new StringBuilder();
//        builder.append(String.format("%2d", this.ProductId));
//        builder.append(String.format("%25s", this.ProductName));
//        builder.append(String.format("%10.2f", this.Price));
//        builder.append(String.format("%20s", this.Producer));
//        builder.append(String.format("%10b", this.Status));
//        
//        System.out.println(builder.toString());
    }
}
