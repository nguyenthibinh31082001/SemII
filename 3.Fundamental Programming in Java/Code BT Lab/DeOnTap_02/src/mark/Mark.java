/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mark;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mark implements IMark{
    private String fullName;
    private boolean gender;
    private String className;
    public float markOfC;
    public float markOfHTML;
    public float markOfSQL;
    public float markOfPHP;

    public Mark() {
    }

    public Mark(String fullName, boolean gender, String className, float markOfC, float markOfHTML, float markOfSQL, float markOfPHP) {
        this.fullName = fullName;
        this.gender = gender;
        this.className = className;
        this.markOfC = markOfC;
        this.markOfHTML = markOfHTML;
        this.markOfSQL = markOfSQL;
        this.markOfPHP = markOfPHP;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public String getGender(){
        return gender? "Nam":"Nữ";
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMarkOfC() {
        return markOfC;
    }

    public void setMarkOfC(float markOfC) {
        this.markOfC = markOfC;
    }

    public float getMarkOfHTML() {
        return markOfHTML;
    }

    public void setMarkOfHTML(float markOfHTML) {
        this.markOfHTML = markOfHTML;
    }

    public float getMarkOfSQL() {
        return markOfSQL;
    }

    public void setMarkOfSQL(float markOfSQL) {
        this.markOfSQL = markOfSQL;
    }

    public float getMarkOfPHP() {
        return markOfPHP;
    }

    public void setMarkOfPHP(float markOfPHP) {
        this.markOfPHP = markOfPHP;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập họ và tên:");
        fullName = sc.nextLine();
        while(true){
            if(this.fullName.length() > 3 && this.fullName.length() < 50){
                  break;
              }else{
                  System.err.println("\tHọ tên phải trên 3 ký tự và không quá 50 ký tự!!!");  
                  System.out.printf("\tNhập lại họ tên: ");
                  fullName = sc.nextLine();
              }
        }
        while(true){
            try {
                System.out.printf("\tNhập giới tính: ");
                this.gender = sc.nextBoolean();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true/false)!!!");
                sc.nextLine();
            }
        }
        System.out.printf("\tNhập tên lớp:");
        className = sc.nextLine();
        while(true){
            if(this.className.length() > 3 && this.className.length() < 50){
                  break;
              }else{
                  System.err.println("\tHọ tên phải trên 3 ký tự và không quá 50 ký tự!!!");  
                  System.out.printf("\tNhập lại tên lớp: ");
                  className = sc.nextLine();
              }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn C:");
                this.markOfC = sc.nextFloat();
                while(this.markOfC > 20){
                    System.err.println("\tThang điểm nhập là 20đ!!!");  
                    System.out.printf("\tNhập lại điểm môn C: ");
                    markOfC = sc.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn HTML:");
                this.markOfHTML = sc.nextFloat();
                while(this.markOfHTML > 20){
                    System.err.println("\tThang điểm nhập là 20đ!!!");  
                    System.out.printf("\tNhập lại điểm môn HTML: ");
                    markOfHTML = sc.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn SQL:");
                this.markOfSQL = sc.nextFloat();
                while(this.markOfSQL > 20){
                    System.err.println("\tThang điểm nhập là 20đ!!!");  
                    System.out.printf("\tNhập lại điểm môn SQL: ");
                    markOfSQL = sc.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn PHP:");
                this.markOfPHP = sc.nextFloat();
                while(this.markOfPHP > 20){
                    System.err.println("\tThang điểm nhập là 20đ!!!");  
                    System.out.printf("\tNhập lại điểm môn PHP: ");
                    markOfPHP = sc.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
//                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.fullName);
        builder.append("\t|");
        builder.append(this.getGender());
        builder.append("\t\t|");
        builder.append( this.className);
        builder.append("\t|");
        builder.append( this.markOfC);
        builder.append("\t|");
        builder.append( this.markOfHTML);
        builder.append("\t\t|");
        builder.append( this.markOfSQL);
        builder.append("\t\t|");
        builder.append( this.markOfPHP);
        builder.append("\t\t|");
        builder.append(this.averageMark()).append("/20");
        
        System.out.print(builder.toString());
    }

    @Override
    public float averageMark() {
        return (markOfC + markOfHTML + markOfSQL + markOfPHP)/4;
    }
    
}
