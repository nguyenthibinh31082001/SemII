/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap;

import java.util.Scanner;
import mark.Mark;

/**
 *
 * @author Admin
 */
public class BKapStudent extends mark.Mark{
    private String courseName;
    private double scholarShip;

    public BKapStudent() {
    }

    public BKapStudent(String courseName, double scholarShip, String fullName, boolean gender, String className, float markOfC, float markOfHTML, float markOfSQL, float markOfPHP) {
        super(fullName, gender, className, markOfC, markOfHTML, markOfSQL, markOfPHP);
        this.courseName = courseName;
        this.scholarShip = scholarShip;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScholarShip() {
        Mark mark = new Mark();
        if(averageMark() > 17 && markOfC>=8 && markOfHTML>=8 && markOfSQL>=8 && markOfPHP>=8){
            return scholarShip = 3500;
        }else if(averageMark() > 12 && averageMark() < 17 && markOfC>=8 && markOfHTML>=8 && markOfSQL>=8 && markOfPHP>=8){
            return scholarShip = 2500;
        }else{
            return scholarShip = 0;
        }
    }

    public void setScholarShip(double scholarShip) {
        this.scholarShip = scholarShip;
    }
    @Override
    public void input() {
        super.input(); 
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên khóa học: ");
        this.courseName = sc.nextLine();
        while (true) {            
            if(this.courseName.length() > 0){
                break;
            }else{
                System.err.println("\tTên khóa học không được để trống!!!");
                System.out.printf("\tNhập lại tên khóa hoc: ");
                courseName = sc.nextLine();
            }
        }
    }
    @Override
    public void display() {
        super.display();
        StringBuilder builder = new StringBuilder();
        builder.append("\t|");
        builder.append(this.courseName);        
        builder.append("\t\t|");
        builder.append(this.getScholarShip());
        
        System.out.println(builder.toString());
    }
}
