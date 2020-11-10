/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon_javacore;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Product implements IProduct{

    private String productId; //Mã sản phẩm bao gồm 4 ký tự, bắt đầu là ký tự “C” và là duy nhất
    private String productName; //Tên sản phẩm bao gồm từ 6-50 ký tự và là duy nhất
    private String title; //Tiêu đề sản phẩm bao gồm từ 6-30 ký tự
    private float importPrice; //giá nhập sản phẩm là số thực lớn hơn 0
    private float exportPrice; //giá bán sản phẩm là số thực và có giá trị lớn hơn giá bán ít nhất là MIN_INTEREST_RATE lần
    private float profit; //lợi nhuận sản phẩm tính theo công thức profit = exportPrice - importPrice
    private String descriptions; //mô tả sản phẩm – khi nhập không được để trống
    private boolean productStatus; //trạng thái sản phẩm – khi nhập chỉ nhận true hoặc false
    private Categories catalog; //Danh mục sản phẩm của sản phẩm

    public Product() {
    }

    public Product(String productId, String productName, String title, float importPrice, float exportPrice, float profit, String descriptions, boolean productStatus, Categories catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit = exportPrice - importPrice;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Categories getCatalog() {
        return catalog;
    }

    public void setCatalog(Categories catalog) {
        this.catalog = catalog;
    }
           
    
    @Override
    public void inputData() {
        //iKhông nhập lợi nhuận sản phẩm;
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã sản phẩm: ");
        productId = input.nextLine();
        while(true){
            if(productId.length() == 4){
                break;
            }else{
                System.err.println("\tMã sản phẩm phải gồm 4 ký tự, bắt đầu bằng 'C' và là duy nhất!!!");
                System.out.printf("\tNhập lại mã sản phẩm:");
                productId = input.nextLine();
            }
        }
        System.out.printf("\tNhập tên sản phẩm: ");
        productId = input.nextLine();
        while(true){
            if(productId.length()>6 && productId.length()<50){
                break;
            }else{
                System.err.println("\tTên sản phẩm phải gồm 6-50 ký tự, và là duy nhất!!!");
                System.out.printf("\tNhập lại tên sản phẩm:");
                productId = input.nextLine();
            }
        }
        System.out.printf("\tNhập tiêu đề sản phẩm: ");
        title = input.nextLine();
        while(true){
            if(title.length()>6 && title.length()<30){
                break;
            }else{
                System.err.println("\tTiêu đề sản phẩm phải gồm 6-30 ký tự!!!");
                System.out.printf("\tNhập lại tiêu đề sản phẩm:");
                title = input.nextLine();
            }
        }
        System.out.printf("\tNhập giá nhập sản phẩm: ");
        importPrice = input.nextFloat();
        while(true){
            if(this.importPrice > 0){
                break;
            }else{
                System.err.println("\tGiá sản phẩm phải lớn hơn 0!!!");
                System.out.printf("\tNhập lại giá nhập sản phẩm:");
                importPrice = input.nextFloat();
            }
        }
        System.out.printf("\tNhập giá bán sản phẩm: ");
        exportPrice = input.nextFloat();
        while(true){
            if(this.exportPrice > 0 && exportPrice > MIN_INTEREST_RATE){
                break;
            }else{
                System.err.println("\tGiá bán sản phẩm là số thực và có giá trị lớn hơn giá bán ít nhất là MIN_INTEREST_RATE lần!!!");
                System.out.printf("\tNhập lại giá bán sản phẩm:");
                exportPrice = input.nextFloat();
            }
        }
        System.out.printf("\tNhập mô tả: ");
        descriptions = input.nextLine();
        while(true){
            if(descriptions.length() > 0){
                break;
            }else{
                System.err.println("\tMô tả sản phẩm không được để trống!!!");
                System.out.printf("\tNhập lại mô tả:");
                descriptions = input.nextLine();
            }
        }
        while(true){
            try {
                System.out.printf("\tNhập trạng thái: ");
                this.productStatus = input.nextBoolean();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true/false)!!!");
                input.nextLine();
            }
        }
        System.out.printf("\tNhập danh mục sản phẩm: ");
//        catalog = input.nextFloat();
    }

    @Override
    public void displayData() {
        //Khi hiển thị trạng thái – true: Hoat dong, false – Khong hoat dong
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void calProfit() {
        //cTính lợi nhuận sản phẩm theo công thức
        System.out.println("Lợi nhuận: " + getProfit());
    }
    
}
