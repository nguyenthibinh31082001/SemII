/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class BTTH1 {
    private String rollNumber;
    private String fullName;
    private String className;

    public BTTH1() {
    }

    
    public BTTH1(String rollNumber, String fullName, String className) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.className = className;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
   
    public void inputData(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập mã sinh viên:");
        rollNumber = input.nextLine();
        System.out.printf("Nhập họ tên sinh viên:");
        fullName = input.nextLine();
        System.out.printf("Nhập tên lớp học:");
        className = input.nextLine();
    }
    
    public void displayData(){
        System.out.println("Sinh viên:");
        System.out.println("\tMã sinh viên: "+rollNumber);
        System.out.println("\tHọ tên: "+fullName);
        System.out.println("\tLớp: "+className);
    }
}
