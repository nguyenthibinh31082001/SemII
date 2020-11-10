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
public class BookManager_Bai3 {
    List<Book_Bai3> lstBook = new ArrayList<>();
    
    public static void main(String[] args) {
        try {
            BookManager_Bai3 demo = new BookManager_Bai3();
            
            Scanner sc  = new Scanner(System.in);
            System.out.printf("Nhập số lượng cuốn sách: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.printf("Cuốn sách %d:\n", i+1);
                List<Book_Bai3> lstBook = new ArrayList<>();
                Book_Bai3 book_Bai3 = new Book_Bai3();
                book_Bai3.input();
                lstBook.add(book_Bai3);
                demo.writeTextByLine(lstBook);
                demo.readTextByLine();
                
            }
            demo.search(sc);
//            List<Book_Bai3> lstBook = new ArrayList<>();
//            demo.writeTextByLine(lstBook);
//            demo.readTextByLine();
            System.out.println("Ghi dữ liệu thành công!!!");
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.toString());
            Logger.getLogger(BookManager_Bai3.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    private void search(Scanner sc) {
        System.out.printf("Nhập tên sách cần tìm: ");
        sc.nextLine();
        String name = sc.nextLine();
        int flag = 0;
        
        for (Book_Bai3 f : lstBook) {
            if (f.getBookName().toLowerCase().contains(name.trim().toLowerCase())) {
                f.toString();
                flag++;
                System.out.println("");
            }
        }

        if (flag == 0) {
            System.err.println("Không tìm thấy sách có tên là: " + name);
        }
    }
    public void writeTextByLine(List<Book_Bai3> lstData) throws FileNotFoundException, IOException {
        String filePath = "book.txt";
        boolean isVietTiep = true;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Ghi ra file
        for (Book_Bai3 b2 : lstData) {
            bw.write(b2.toString());
            bw.newLine(); // thêm dòng mới gọi
        }
        bw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        bw.close(); // Đóng kết nối tới file
    }
     public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "book.txt";
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

//    public void input(){
//        Scanner sc  = new Scanner(System.in);
//        System.out.printf("Nhập số lượng cuốn sách: ");
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Cuốn sách %d:\n", i+1);
//            Book_Bai3 book_Bai3 = new Book_Bai3();
//            book_Bai3.input();
//            lstBook.add(book_Bai3);
//            
//        }
//    }

    
}
