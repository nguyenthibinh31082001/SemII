/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Product_Bai5 implements Comparable<Product_Bai5>{
    private String proId;
    private String proName;
    private String producer;
    private int yearMaking;
    private float price;

    public Product_Bai5() {
    }

    public Product_Bai5(String proId, String proName, String producer, int yearMaking, float price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void input() {
        Scanner s = new Scanner(System.in);   
        boolean isDone = false;
        do {
            System.out.printf("\tNhập proId: ");
            this.proId = s.nextLine();
            if (this.proId.length() > 0) {
                isDone = true;
            } else {
                System.err.println("\tProId không được để trống!!!");
            }
        } while (!isDone);
        do {
            System.out.printf("\tNhập proName: ");
            this.proName = s.nextLine();
            if (this.proName.length() > 0) {
                isDone = true;
            } else {
                System.err.println("\tProName không được để trống!!!");
            }
        } while (!isDone);
        do {
            System.out.printf("\tNhập producer: ");
            this.producer = s.nextLine();
            if (this.producer.length() > 0) {
                isDone = true;
            } else {
                System.err.println("\tProducer không được để trống!!!");
            }
        } while (!isDone);
        while (true) {
            try {
                System.out.printf("\tNhập yearMaking: ");
                    this.yearMaking = s.nextInt();
                    Year nhap= Year.of(this.yearMaking);
                    Year now = Year.now();
                    int year = now.compareTo(nhap);
//                do {
                    if ( year > 0) {
                        isDone = true;
                        break;
                    } else {
                        System.err.println("\tYearMaking không quá ngày hiện tại!!!");
                    }
//                } while (!isDone);
//                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  s.nextLine();
            }
        }
       
    }
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.proId));
        builder.append("|\t");
        builder.append(String.format("%10s", this.proName));
        builder.append("|\t");
        builder.append(String.format("%10s",this.producer));
        builder.append("|\t");
        builder.append(String.format("%10s", this.yearMaking));
        builder.append("|\t");
        builder.append(String.format("%10s", this.price));
        builder.append("|\t");
        
        System.out.print(builder.toString());
    }
    
    @Override
    public int compareTo(Product_Bai5 o) {
        return this.yearMaking.compareTo(o.getYearMaking());
    }
}
//https://viblo.asia/p/sap-xep-trong-java-8-63vKjaLM52R