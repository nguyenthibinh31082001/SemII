/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedemo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class Person implements Serializable{
    private int id;
    private String fullname;
    private boolean gender;
    private LocalDate birthday;

    public Person(int id, String fullname, boolean gender, LocalDate birthday) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", birthday=" + birthday + '}';
    }
    
    
    
}
