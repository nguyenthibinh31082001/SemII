/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon_javacore;

import com.sun.istack.internal.NotNull;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Categories implements ICategories{

    private int catalogId; //Mã danh mục – Phải là số nguyên lớn hơn 0, duy nhất
    private String catalogName; //Tên danh mục – Phải gồm từ 6-30 ký tự
    private String descriptions; //Mô tả danh mục – Không được để trống khi nhập
    private boolean catalogStatus; //Trạng thái danh mục – chỉ nhận giá trị true hoặc false khi nhập
    private int parentId; //Mã danh mục cha – khi nhập danh mục cha phải tồn tại (chỉ quản lý tối đa 3 cấp danh mục – danh mục gốc có parentId = 0)

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
        this.parentId = parentId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public String getCatalogStatus(){
        return catalogStatus == true ? "Hoạt động":"Kông hoạt động";
    }
    
    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    
    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã danh mục: ");
        catalogId = input.nextInt();
        while(true){
            if(this.catalogId > 0){
                break;
            }else{
                System.err.println("\tMã danh mục phải lơn hơn 0!!!");
                System.out.printf("\tNhập lại mã danh mục:");
                catalogName = input.nextLine();
            }
        }
        System.out.printf("\tNhập tên danh mục: ");
        catalogName = input.nextLine();
        while(catalogName.length()<6 || catalogName.length()>30){
            System.err.println("\tTên danh mục phải tối đa 6 ký tự và không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập lại tên danh mục:");
            catalogName = input.nextLine();
        }
        System.out.printf("\tNhập mô tả:");
        descriptions = input.nextLine();
        while(true){
            if(this.descriptions.length() > 0 ){
                  break;
              }else{
                  System.err.println("\tHọ tên phải trên 3 ký tự và không quá 50 ký tự!!!");  
                  System.out.printf("\tNhập lại mô tả: ");
                  descriptions = input.nextLine();
              }
        }
        while(true){
            try {
                System.out.printf("\tNhập trạng thái: ");
                this.catalogStatus = input.nextBoolean();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true/false)!!!");
                input.nextLine();
            }
        }
        System.out.printf("\tNhập mã danh muc cha: ");
        parentId = input.nextInt();
        while(true){
            if(this.parentId >= 0 && this.parentId <= 3){
                break;
            }else{
                System.err.println("\tMã danh mục cha chỉ từ 0-3!!!");
                System.out.printf("\tNhập lại mã danh mục cha:");
                parentId = input.nextInt();
            }
        }
    }

    @Override
    public void displayData() {
        //(Khi hiển thị trạng thái – true: Hoat dong, false – Khong hoat dong)
        System.out.printf("\tMã danh mục: "+ catalogId+" - ");
        System.out.println("Tên danh mục: "+catalogName);
        System.out.println("\tMô tả: "+ descriptions);
        System.out.printf("\tDanh mục cha: "+ parentId+ " - ");
        System.out.println("Trạng thái: "+getCatalogStatus());
    }
    
}
