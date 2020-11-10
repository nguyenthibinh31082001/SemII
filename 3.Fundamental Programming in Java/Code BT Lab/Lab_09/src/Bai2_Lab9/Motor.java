/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2_Lab9;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Motor implements IMotor,Comparable<Motor>{
    private String code; // Mã xe
    private String name; // Tên loại xe
    private double capacity; // Dung tích xi lanh
    private int num; // Kiểu truyền lực là mấy số

    public Motor() {
    }

    public Motor(String code, String name, double capacity, int num) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public void inputInfor() {
       Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập mã xe:");
        code = input.nextLine();
        System.out.printf("\tTên loại xe:");
        name = input.nextLine();
        while (true) {
            try {
                System.out.printf("\tDung tích xi lanh:");
                capacity = input.nextDouble();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
        while (true) {
            try {
                
                System.out.printf("\tKiểu truyền lực là mấy số:");
                num = input.nextInt();
             
                break;
            } catch (Exception ex) {
                System.out.printf("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  input.nextLine();
            }
        }
    }
    @Override
    public void displayInfor() {
//        System.out.println("\tMã xe: "+code);
//        System.out.println("\tLoại xe: "+name);
//        System.out.println("\tDung tích xi lanh: "+capacity);
//        System.out.println("\tKiểu truyền lực: "+num);
        
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(code);
        buider.append("|\t|");
        buider.append(name);
        buider.append("|\t|");
        buider.append(capacity);
        buider.append("|\t|");
        buider.append(num);
        
        System.out.print(buider.toString());
    }

    @Override
    public void changeInfor() {
        
    }

    @Override
    public int compareTo(Motor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
