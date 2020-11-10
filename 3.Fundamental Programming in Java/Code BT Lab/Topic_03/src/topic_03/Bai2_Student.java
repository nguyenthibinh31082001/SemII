/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_03;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai2_Student {
    private String rollNo;
    private String name;
    private int age;
    private String address;
    private float tMark;
    private float pMark;

    public Bai2_Student() {
    }

    public Bai2_Student(String rollNo, String name, int age, String address, float tMark, float pMark) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tMark = tMark;
        this.pMark = pMark;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float gettMark() {
        return tMark;
    }

    public void settMark(float tMark) {
        this.tMark = tMark;
    }

    public float getpMark() {
        return pMark;
    }

    public void setpMark(float pMark) {
        this.pMark = pMark;
    }
    
    public void studentInput(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập mã sinh viên:");
        rollNo = sc.nextLine();
        System.out.printf("Nhập tên sinh viên:");
        name = sc.nextLine();
        System.out.printf("Nhập tuổi sinh viên:");
        age = sc.nextInt();
        sc.nextLine();
        System.out.printf("Nhập Địa chỉ:");
        address = sc.nextLine();
        System.out.printf("Nhập điểm lý thuyết:");
        tMark = sc.nextFloat();
        System.out.printf("Nhập điểm thực hành:");
        pMark = sc.nextFloat();
        System.out.println("Cảm Ơn!");
    }
//    public String studentInfo(){
//        return "Bai2_Student{" + "rollNo=" + rollNo + ", name=" + name + ", age=" + age + ",address=" + address + ",tMark=" + tMark+ ",pMark=" + pMark +'}';
//    }
    public void studentInfo() {
        String data = "Student{" + "rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", address=" + address + ", tMark=" + tMark + ", pMark=" + pMark + '}';
        System.out.println(data);
}
//    public String printRank(float tMark, float pMark){
//        if(tMark < 40 || pMark < 40){
//            System.out.println("Thi lại môn Java");
//        }else if(tMark < 40 || pMark >= 40){
//            System.out.println("Thi lại lý thuyết môn Java");
//        }else if(tMark >= 40 || pMark < 40){
//            System.out.println("Thi lại thực hành môn Java");
//        }else if(tMark >= 40 || pMark >= 40){
//            System.out.println("Pass môn Java");
//        }
//    }
}
