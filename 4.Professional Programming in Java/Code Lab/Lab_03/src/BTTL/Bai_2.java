/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Bai_2 {
    private int Int;
    private double Double;
    private boolean Boolean;
    private char Char;
    private String String;

    public Bai_2() {
    }

    public Bai_2(int Int, double Double, boolean Boolean, char Char, String String) {
        this.Int = Int;
        this.Double = Double;
        this.Boolean = Boolean;
        this.Char = Char;
        this.String = String;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int Int) {
        this.Int = Int;
    }

    public double getDouble() {
        return Double;
    }

    public void setDouble(double Double) {
        this.Double = Double;
    }

    public boolean isBoolean() {
        return Boolean;
    }

    public void setBoolean(boolean Boolean) {
        this.Boolean = Boolean;
    }

    public char getChar() {
        return Char;
    }

    public void setChar(char Char) {
        this.Char = Char;
    }

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }
    
    public void input(){
        Scanner sc  = new Scanner(System.in);
        System.out.printf("Nhập số nguyên: ");
        this.Int = sc.nextInt();
        System.out.printf("Nhập số thực: ");
        this.Double = sc.nextDouble();
        System.out.printf("Nhập số true/false: ");
        this.Boolean = sc.nextBoolean();
        System.out.printf("Nhập số ký tự char: ");
        this.Char = sc.next().charAt(0);
        sc.nextLine();
        System.out.printf("Nhập số chuỗi string: ");
        this.String = sc.nextLine();
    }
    public void display(){
        System.out.println("Int = "+this.Int);
        System.out.println("Double = "+this.Double);
        System.out.println("Boolean = "+this.Boolean);
        System.out.println("Char = "+this.Char);
        System.out.println("String = "+this.String);
    } 

    @Override
    public String toString() {
        return "Bai_2{" + "Int=" + Int + ", Double=" + Double + ", Boolean=" + Boolean + ", Char=" + Char + ", String=" + String + '}';
    }
    
    public void writeTextByLine(List<Bai_2> lstData) throws FileNotFoundException, IOException {
        String filePath = "data.dat";
        boolean isVietTiep = true;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Ghi ra file
        for (Bai_2 b2 : lstData) {
            bw.write(b2.toString());
            bw.newLine(); // thêm dòng mới gọi
        }
        bw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        bw.close(); // Đóng kết nối tới file
    }
    
    public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "data.dat";
        File myFile = new File(filePath);
        FileInputStream fos = new FileInputStream(myFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fos));
        String temp;
        int cnt = 1;
        while ((temp = br.readLine()) != null) {
        System.out.println(cnt + ". \t" + temp);
        cnt++;
        }
//        File objFile = new File(filePath);
//        try {
//            FileInputStream fis = new FileInputStream(objFile);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//            
//            int numLine = 1;
//            String line;
//            
//            while ((line = br.readLine()) != null) {
//                System.out.println(numLine + ": "+ line);
//                numLine++;
//            }
//            
//        } catch (FileNotFoundException ex) {
//           ex.printStackTrace();
//        } catch (IOException ex) {
//           ex.printStackTrace();
//        }
    }
    public static void main(String[] args) {
        try {
            Bai_2 demo = new Bai_2();
            
            Scanner sc = new Scanner(System.in);
            List<Bai_2> lstDuLieu = new ArrayList<>();
            demo.input();
            lstDuLieu.add(demo);
            demo.writeTextByLine(lstDuLieu);
            demo.readTextByLine();
//            demo.writeText2File(lstDuLieu);
            System.out.println("Ghi dữ liệu thành công!!!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
            Logger.getLogger(Bai_2.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
