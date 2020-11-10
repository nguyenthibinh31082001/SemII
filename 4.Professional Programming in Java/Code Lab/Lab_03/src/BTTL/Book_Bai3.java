/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Book_Bai3 implements Serializable{
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private float price;

    public Book_Bai3() {
    }

    public Book_Bai3(String isbn, String bookName, String author, String publisher, float price) {
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
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập isbn: ");
        this.isbn = sc.nextLine();
        System.out.printf("\tNhập bookName: ");
        this.bookName = sc.nextLine();
        System.out.printf("\tNhập author: ");
        this.author = sc.nextLine();
        System.out.printf("\tNhập publisher: ");
        this.publisher = sc.nextLine();
        System.out.printf("\tNhập price: ");
        this.price = sc.nextFloat();
    }
    @Override
    public String toString() {
        return "isbn=" + isbn + ", bookName=" + bookName + ", author=" + author + ", publisher=" + publisher + ", price=" + price;
    }
    
    
}
