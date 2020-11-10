/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_10;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Car implements Icar{
    private String name;
    private String producer;
    private int year;
    private int seat;
    float rootPrice;

    public Car() {
    }

    public Car(String name, String producer, int year, int seat, float rootPrice) {
        this.name = name;
        this.producer = producer;
        this.year = year;
        this.seat = seat;
        this.rootPrice = rootPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public float getRootPrice() {
        return rootPrice;
    }

    public void setRootPrice(float rootPrice) {
        this.rootPrice = rootPrice;
    }
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên xe: ");
        name = input.nextLine();
        while(name.length()>200){
            System.err.println("\tTên xe không được vượt quá 200 ký tự!");
            System.out.printf("\tNhập tên xe: ");
            name = input.nextLine();
        }
        System.out.printf("\tNhập người sản xuất: ");
        producer = input.nextLine();
        while(producer.length()>30){
            System.err.println("\tNgười sản xuất không được vượt quá 30 ký tự!");
            System.out.printf("\tNhập người sản xuất: ");
            producer = input.nextLine();
        }
        while (true) {
            try {
                System.out.printf("\tNhập năm sản xuất: ");
                year = input.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
//                System.err.println("\tNhập lại:"+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập số ghế: ");
                seat = input.nextInt(); 
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
//                System.err.println("\tNhập lại:"+ex.getLocalizedMessage());
                  input.nextLine();
            }
        } 
        while (true) {
            try {
                System.out.printf("\tNhập giá gốc: ");
                rootPrice = input.nextFloat(); 
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số thực:");
//                System.err.println("\tNhập lại:"+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
    } 
    @Override
    public float calculateTax() {
//        throw new UnsupportedOperationException("Not supported yet."); 
        float Tax = 0;
        if(seat < 7){
            Tax = (float) (rootPrice * 0.6);
            return Tax;
        }else{
            Tax = (float) (rootPrice * 0.7);
            return Tax;
        }
//        return Tax;
        
    }

    @Override
    public float calculatePrice() {
//        throw new UnsupportedOperationException("Not supported yet."); 
        float Price = 0;
        Price = rootPrice + calculateTax();
        return Price;
    }

    @Override
    public void getInfor() {
        LuxuryCar luxuryCar = new LuxuryCar();
        System.out.printf("\tXe "+name);
        System.out.printf(" được sản xuất bởi "+producer);
        System.out.printf(" vào năm "+year);
        System.out.printf(" có "+seat+" ghế");
        System.out.printf(" với giá bán là "+calculatePrice()+" $.\n");
        System.out.printf(" => tổng giá bán = "+luxuryCar.calculatePrice());
    }
    
}
