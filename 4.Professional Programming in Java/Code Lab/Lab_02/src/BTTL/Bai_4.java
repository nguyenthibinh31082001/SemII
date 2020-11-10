/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Bai_4 {
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private float price;

    public Bai_4() {
    }

    public Bai_4(String isbn, String bookName, String author, String publisher, float price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void input(){
        
    }
    String regExpisbn = "^[a-zA-Z0-9 ]{1,}$";
    String regExpbookName = "^[a-zA-Z0-9 ]{1,}$";
    String regExpauthor = "^[a-zA-Z0-9 ]{1,}$";
    String regExppublisher = "^[a-zA-Z0-9 ]{1,}$";
    String regExpprice = "^[0-9]{1,}$";
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\tNhập isbn:");
            this.isbn = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpisbn);
            Matcher matcher = pattern.matcher(isbn);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tIsbn không được để trống!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập bookName:");
            this.bookName = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpbookName);
            Matcher matcher = pattern.matcher(bookName);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tBookName không được để trống!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập author:");
            this.author = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpauthor);
            Matcher matcher = pattern.matcher(author);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tAuthor không được để trống!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập publisher:");
            this.publisher = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpauthor);
            Matcher matcher = pattern.matcher(publisher);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tPublisher không được để trống!");
            }
        } while (true);
         System.out.printf("\tNhập price:");
         this.price = sc.nextFloat();
//        do {
//            System.out.printf("\tNhập price:");
//            this.price = sc.nextFloat();
//            Pattern pattern = Pattern.compile(regExpprice);
//            Matcher matcher = pattern.matcher(sc.nextLine());
//            if (matcher.matches()) {
//                break;
//            } else {
//                System.err.println("\tPrice không được để trống!");
//            }
//        } while (true);
    }
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.isbn));
        builder.append("|\t");
        builder.append(String.format("%10s", this.bookName));
        builder.append("|\t");
        builder.append(String.format("%10s",this.author));
        builder.append("|\t");
        builder.append(String.format("%10s", this.publisher));
        builder.append("|\t");
        builder.append(String.format("%10s", this.price));
        builder.append("|\t");
        
        System.out.print(builder.toString());
    }
    
//    public static void main(String[] args) {
//        Bai_4 bai_4 = new Bai_4();
//        bai_4.nhap();
//        
//        System.out.println("Danh sách book vừa nhập:");
//        System.out.println("isbn\t\tbookName\tauthor\t\tpublisher\tprice");
//        bai_4.display();
//    }
    
}
