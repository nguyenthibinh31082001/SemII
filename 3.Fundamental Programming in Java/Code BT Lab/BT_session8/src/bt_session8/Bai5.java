/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_session8;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai5 {
    private String ten;
    public void nhapDuLieu() {
        System.out.println("\t===Danh sách các quốc gia===");
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tên quốc gia: ");
        this.ten = input.nextLine();
    }
    @Override
    public String toString() {
        return "Tên quốc gia: " + ten ;
    }
}
