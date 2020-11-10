/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BookManagerNew_Bai3 {
    static List<Book_Bai3> lstBook = new ArrayList<>();
    
    public static void main(String[] args) {
        String path = "book4.txt";
        input();
        display();
        write(path);
        read(path);
        search();
    }
    static void input(){
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            System.out.printf("Nhập số lượng sách: ");
            int n = Integer.parseInt(br.readLine());
            
            Book_Bai3 book;
            while(n>0){
                book = new Book_Bai3();
                System.out.printf("\tNhập mã sách: ");
                book.setIsbn(br.readLine());
                System.out.printf("\tNhập tên sách: ");
                book.setBookName(br.readLine());
                System.out.printf("\tNhập tác giả: ");
                book.setAuthor(br.readLine());
                System.out.printf("\tNhập người xuất bản: ");
                book.setPublisher(br.readLine());
                System.out.printf("\tNhập giá: ");
                book.setPrice(Float.parseFloat(br.readLine()));
                lstBook.add(book);
                n--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void write(String path){
        try (
                FileOutputStream fos = new FileOutputStream(path);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                
                ){
             for (Book_Bai3 book_Bai3 : lstBook) {
                bw.write(book_Bai3.toString());
                bw.newLine();
            }
                System.out.println("Ghi dữ liệu thành công vào file "+ path+"!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void read(String path){
        List<Book_Bai3> lstBookFromFile = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                
                ){
            String str;
            while( (str= br.readLine()) !=null){
                String fileds[] = str.split(",");
                Book_Bai3 b = new Book_Bai3();
                    b.setIsbn(fileds[0].split("=")[1]);
                    b.setBookName(fileds[1].split("=")[1]);
                    b.setAuthor(fileds[2].split("=")[1]);
                    b.setPublisher(fileds[3].split("=")[1]);
                    b.setPrice(Float.parseFloat(fileds[4].split("=")[1]));
                lstBookFromFile .add(b);
            }
            System.out.println("Dữ liệu đọc từ file book.txt: ");
            lstBookFromFile.forEach(o -> System.out.println(o.toString()));
            
        } catch (Exception e) {
        }
    }
    static void search() {
        try (
                InputStreamReader reader = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(reader);
             ){
            Book_Bai3 book = new Book_Bai3();
            System.out.printf("Nhập tên sách cần tìm: ");
            String name = br.readLine();
            int flag = 0;
            for (Book_Bai3 f : lstBook) {
                if (f.getBookName().toLowerCase().contains(name.trim().toLowerCase())) {
                    lstBook.forEach(o -> System.out.println(o.toString()));
//                    f.toString();
                    flag++;
                    System.out.println("");
                }
            }
            if (flag == 0) {
                System.err.println("Không tìm thấy sách có tên là: " + name);
            }
        } catch (Exception e) {
        }
    }
    static void display(){
        System.out.println("Danh sách vừa nhập là: ");
        lstBook.forEach(o -> System.out.println(o.toString()));
    }
}
