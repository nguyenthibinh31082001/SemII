/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai2_Lab4 {
    private String name;
    private String address;
    private double salary;

    public Bai2_Lab4() {
    }

    public Bai2_Lab4(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập tên:");
        name = sc.nextLine();
        System.out.printf("Nhập địa chỉ:");
        address = sc.nextLine();
        System.out.printf("Nhập tiền lương:");
        salary = sc.nextDouble();
        
    }
    public void display(){
        System.out.println("Person 1:");
        System.out.println("\tName:"+name);
        System.out.println("\tAddress:"+address);
        System.out.println("\tSalary:"+salary);
    }
}
