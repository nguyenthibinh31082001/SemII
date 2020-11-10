/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3_Lab9;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Country implements ICountry{
    private String countryName;
    public double area;
    long numberPerson;

    public Country() {
    }

    public Country(String countryName, double area, long numberPerson) {
        this.countryName = countryName;
        this.area = area;
        this.numberPerson = numberPerson;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(long numberPerson) {
        this.numberPerson = numberPerson;
    }

    
    @Override
    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập tên quốc gia: ");
        countryName = input.nextLine();
        System.out.printf("\tNhập khu vực: ");
        area = input.nextDouble();
        System.out.printf("\tNhập số dân: ");
        numberPerson = input.nextLong();
    }

    @Override
    public void display() {
        StringBuilder buider = new StringBuilder();
        buider.append("");
        buider.append(countryName);
        buider.append("|\t|");
        buider.append(area);
        buider.append("|\t|");
        buider.append(numberPerson);
        buider.append("|\t|");
        System.out.print(buider.toString());
    }

    @Override
    public float everageArea(double area, long numberPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
