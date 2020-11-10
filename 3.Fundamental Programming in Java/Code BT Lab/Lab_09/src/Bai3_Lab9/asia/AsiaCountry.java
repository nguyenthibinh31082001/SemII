/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3_Lab9.asia;

import Bai3_Lab9.Country;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class AsiaCountry extends Country{
    private String location;
    // vi tri dia ly: Dong Nam A, Trung A hoac Nam A

    public AsiaCountry() {
    }

    public AsiaCountry(String location, String countryName, double area, long numberPerson) {
        super(countryName, area, numberPerson);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    @Override
    public void input() {
        super.input();
        Scanner input = new Scanner(System.in);
        System.out.printf("\tNhập vị trí:");
        this.location = input.nextLine();
    }
    @Override
    public void display() {
        super.display();
        System.out.println(location);
    }
}
