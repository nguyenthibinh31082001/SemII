/*
╔═══╗╔═══╗╔═╗╔═╗╔══╗╔═╗─╔╗╔══╗╔═══╗     ╔═══╗╔═══╗╔╗─╔╗     ╔╗──╔╗╔═╗─╔╗
╚╗╔╗║║╔═╗║║║╚╝║║╚╣─╝║║╚╗║║╚╣─╝║╔═╗║     ║╔══╝╚╗╔╗║║║─║║     ║╚╗╔╝║║║╚╗║║
─║║║║║║─║║║╔╗╔╗║─║║─║╔╗╚╝║─║║─║║─╚╝     ║╚══╗─║║║║║║─║║     ╚╗║║╔╝║╔╗╚╝║
─║║║║║║─║║║║║║║║─║║─║║╚╗║║─║║─║║─╔╗     ║╔══╝─║║║║║║─║║     ─║╚╝║─║║╚╗║║
╔╝╚╝║║╚═╝║║║║║║║╔╣─╗║║─║║║╔╣─╗║╚═╝║     ║╚══╗╔╝╚╝║║╚═╝║     ─╚╗╔╝─║║─║║║
╚═══╝╚═══╝╚╝╚╝╚╝╚══╝╚╝─╚═╝╚══╝╚═══╝     ╚═══╝╚═══╝╚═══╝     ──╚╝──╚╝─╚═╝
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo_Procedure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Minh Tuan
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

    @Override
    public String toString() {
        return "Product{" + "ProductId=" + ProductId + ", ProductName=" + ProductName + ", Price=" + Price + ", Producer=" + Producer + ", DateCreated=" + DateCreated + ", Status=" + Status + '}';
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Product Name: ");
        this.ProductName = sc.nextLine();
        System.out.println("Price: ");
        while(true){
            try {
                 this.Price = sc.nextFloat();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Input not float");
            }
            sc.nextLine();
        }
        
        System.out.println("Producer");
        this.Producer = sc.nextLine();
       
        while(true){
             System.out.println("Date create (dd/MM/yyyy)");
            try {
                this.DateCreated = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("Input not format: dd/MM/yyyyy");
            }
        }
        
        while(true){
            System.out.println("Status: ");
            try {
                this.Status = sc.nextBoolean();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Input not format: true/false");
            }
        }
    }
    
    public void display(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%10d", this.ProductId));
        builder.append(String.format("%25s", this.ProductName));
        builder.append(String.format("%10.2f", this.Price));
        builder.append(String.format("%20s", this.Producer));
        builder.append(String.format("%10b", this.Status));
        
        System.out.println(builder.toString());
    }
}
