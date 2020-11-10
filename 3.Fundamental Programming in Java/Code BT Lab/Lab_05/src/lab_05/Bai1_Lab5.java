/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_05;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1_Lab5 {
    private String prodId;
    private String prodName;
    private String manufacturer;
    private float producerPrice;
    public float sale_price;

    public Bai1_Lab5() {
    }

    public Bai1_Lab5(String prodId, String prodName, String manufacturer, float producerPrice) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.manufacturer = manufacturer;
        this.producerPrice = producerPrice;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getProducerPrice() {
        return producerPrice;
    }

    public void setProducerPrice(float producerPrice) {
        this.producerPrice = producerPrice;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập mã sản phẩm:");
        prodId = sc.nextLine();
        System.out.printf("Nhập tên sản phẩm:");
        prodName = sc.nextLine();
        System.out.printf("Nhập tên nhà sản xuất:");
        manufacturer = sc.nextLine();
        System.out.printf("Nhập giá sản xuất:");
        producerPrice = sc.nextFloat();
    }
    
    public void display(){
        System.out.println("Sản phẩm:");
        System.out.println("\tMã sản phẩm:"+prodId);
        System.out.println("\tTên sản phẩm:"+prodName);
        System.out.println("\tNhà sản xuất:"+manufacturer);
        System.out.println("\tGiá sản xuất:"+producerPrice);
       
    }
    public void clalculateSalePrice(){
        sale_price  = (float) (producerPrice + 0.05 * producerPrice);
        
        System.out.println("\tGiá bán:" + sale_price);
    }
}
