/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2_Lab9.yamaha;

import Bai2_Lab9.Motor;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Serius extends Motor{
    private int warranty;//Thời gian bảo hành

    public Serius() {
    }

    public Serius(int warranty, String code, String name, double capacity, int num) {
        super(code, name, capacity, num);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }
    
    @Override
    public void inputInfor() {
        super.inputInfor();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập thời gian bảo hành xe serius:");
        while(true){
            try{
                this.warranty = input.nextInt();
                break;
            }catch(Exception ex){
                System.out.printf("Yêu cầu nhập số:");
            }
        }
        
    }
    @Override
    public void displayInfor(){
        super.displayInfor();
        System.out.println("\tThời gian bảo hành serius:"+warranty);
    }
    @Override
    public int compareTo(Motor o) {
        if(o instanceof Jupiter)
            return 0;
        return this.getWarranty() -  ((Serius)o).warranty;
    }
}
