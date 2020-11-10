/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_session8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai6 {
     private String ten;
    public void nhapDuLieu() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tên thành phố: ");
        this.ten = input.nextLine();
    }
    @Override
    public String toString() {
        return "Tên thành phố: " + ten ;
    }
}
