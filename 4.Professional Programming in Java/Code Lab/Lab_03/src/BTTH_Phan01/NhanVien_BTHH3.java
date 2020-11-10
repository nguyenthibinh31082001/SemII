/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class NhanVien_BTHH3 implements Serializable{
    String name;
    int age;
    String address;

//    NhanVien_BTHH3(String nguyen_Van_A, int i, String hn) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public NhanVien_BTHH3() {
    }

    public NhanVien_BTHH3(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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
    @Override
    public String toString() {
        return name + "(" + age + ")" + address;
    }
    
}
