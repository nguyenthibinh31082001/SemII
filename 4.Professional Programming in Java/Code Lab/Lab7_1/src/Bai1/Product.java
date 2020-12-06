package Bai1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Product {
    private int ProductId;
    private int CatelogId;
    private String  ProductName;
    private String Content;
    private String ContentDetail;
    private float PriceInput;
    private float PriceOutput;
    private LocalDate Created;
    private int Views;
    private int BuyItem;
    private boolean Status;

    public Product() {
    }

    public Product(int ProductId, int CatelogId, String ProductName, String Content, String ContentDetail, float PriceInput, float PriceOutput, LocalDate Created, int Views, int BuyItem, boolean Status) {
        this.ProductId = ProductId;
        this.CatelogId = CatelogId;
        this.ProductName = ProductName;
        this.Content = Content;
        this.ContentDetail = ContentDetail;
        this.PriceInput = PriceInput;
        this.PriceOutput = PriceOutput;
        this.Created = Created;
        this.Views = Views;
        this.BuyItem = BuyItem;
        this.Status = Status;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getCatelogId() {
        return CatelogId;
    }

    public void setCatelogId(int CatelogId) {
        this.CatelogId = CatelogId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getContentDetail() {
        return ContentDetail;
    }

    public void setContentDetail(String ContentDetail) {
        this.ContentDetail = ContentDetail;
    }

    public float getPriceInput() {
        return PriceInput;
    }

    public void setPriceInput(float PriceInput) {
        this.PriceInput = PriceInput;
    }

    public float getPriceOutput() {
        return PriceOutput;
    }

    public void setPriceOutput(float PriceOutput) {
        this.PriceOutput = PriceOutput;
    }

    public LocalDate getCreated() {
        return Created;
    }

    public void setCreated(LocalDate Created) {
        this.Created = Created;
    }

    public int getViews() {
        return Views;
    }

    public void setViews(int Views) {
        this.Views = Views;
    }

    public int getBuyItem() {
        return BuyItem;
    }

    public void setBuyItem(int BuyItem) {
        this.BuyItem = BuyItem;
    }

    public boolean isStatus() {
        return Status;
    }
    public String getStatus(){
        return Status == true ? "1":"0";
    }
    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("\tNhập mã danh mục:");
                this.CatelogId = s.nextInt();
                while(CatelogId < 0 ){
                    System.err.println("\tMã danh mục phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại mã danh mục: ");
                    CatelogId = s.nextInt();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        s.nextLine();
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
        System.out.printf("\tNhập content: ");
        this.Content = s.nextLine();
        while(true){
            if(this.Content.length() <= 250 && Content.length() > 0){
                  break;
              }else{
                  System.err.println("\tContent phải từ 1-250 ký tự!!!");  
                  System.out.printf("\tNhập lại content: ");
                  Content = s.nextLine();
              }
        }
        System.out.printf("\tNhập contentDetail: ");
        this.ContentDetail = s.nextLine();
        while(true){
            if( ContentDetail.length() > 0){
                  break;
              }else{
                  System.err.println("\tContentDetail không được để trống!!!");  
                  System.out.printf("\tNhập lại contentDetail: ");
                  ContentDetail = s.nextLine();
              }
        }
        while (true) {
            try {
                System.out.printf("\tNhập PriceInput: ");
                this.PriceInput = s.nextFloat();
                while(PriceInput < 0 ){
                    System.err.println("\tPriceInput phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại PriceInput: ");
                    PriceInput = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập PriceOutput: ");
                this.PriceOutput = s.nextFloat();
                while(PriceOutput < 0 ){
                    System.err.println("\tPriceOutput phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại PriceOutput: ");
                    PriceOutput = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        s.nextLine();
        System.out.print("\tNhập Created:");
        Created = string2LocalDate(s);
        while (true) {
            try {
                System.out.print("\tNhập Views:");
                this.Views = s.nextInt();
                while(Views < 0 ){
                    System.err.println("\tViews phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại Views: ");
                    Views = s.nextInt();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("\tNhập BuyItem:");
                this.BuyItem = s.nextInt();
                while(BuyItem < 0 ){
                    System.err.println("\tBuyItem phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại BuyItem: ");
                    BuyItem = s.nextInt();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while(true){
            try {
                System.out.printf("\tNhập trạng thái(true:Hiện/false: Ẩn): ");
                this.Status = s.nextBoolean();
                s.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true:Hiện/false: Ẩn)!!!");
                s.nextLine();
            }
        }
    }
    public LocalDate string2LocalDate(Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tNgày không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại ngày(dd/MM/yyyy): ");
               string2LocalDate(sc);

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
//    public void output() {
//        System.out.printf("%-6d %-6d %-9s %-18s %-15s %-13s %-15s %-15s %-15s %-15s %-15s\n",
//        this.ProductId,this.CatelogId, this.ProductName, this.Content, this.ContentDetail, 
//        this.PriceInput,this.PriceOutput,this.Created,this.Views,this.BuyItem,getStatus());
//    }
}
