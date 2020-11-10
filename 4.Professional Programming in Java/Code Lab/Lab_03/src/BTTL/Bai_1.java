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
public class Bai_1 {
    
    private String data;
    public Bai_1() {
    }

    public Bai_1(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void input(Scanner sc){
        System.out.printf("Nhập dữ liệu: ");
        this.data = sc.nextLine();
    }
    @Override
    public String toString() {
        return data;
    }
    public void writeText2File(List<Bai_1> lstData) throws IOException{
        String filePath = "dulieu.txt";
        boolean isVietTiep = false;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // Ghi ra file
        for (Bai_1 b1 : lstData) {
        osw.write(b1.toString());
        }
        osw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        osw.close(); // Đóng kết nối tới file
    }
    public void writeTextByLine(List<Bai_1> lstData) throws FileNotFoundException, IOException {
        String filePath = "dulieu.txt";
        boolean isVietTiep = true;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Ghi ra file
        for (Bai_1 b1 : lstData) {
        bw.write(b1.toString());
        bw.newLine(); // thêm dòng mới gọi
        }
        bw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        bw.close(); // Đóng kết nối tới file
    }
    public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "dulieu.txt";
        File myFile = new File(filePath);
        FileInputStream fos = new FileInputStream(myFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fos));
        String temp;
        int cnt = 1;
        while ((temp = br.readLine()) != null) {
        System.out.println(cnt + ". \t" + temp);
        cnt++;
        }
    }
    public static void main(String[] args) {
        try {
            Bai_1 demo = new Bai_1();
            
            Scanner sc = new Scanner(System.in);
            List<Bai_1> lstDuLieu = new ArrayList<>();
            demo.input(sc);
            lstDuLieu.add(demo);
            demo.writeTextByLine(lstDuLieu);
            demo.readTextByLine();
            demo.writeText2File(lstDuLieu);
            System.out.println("Ghi dữ liệu thành công!!!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
            Logger.getLogger(Bai_1.class.getName()).log(Level.SEVERE,null, e);
        }
    }

}
