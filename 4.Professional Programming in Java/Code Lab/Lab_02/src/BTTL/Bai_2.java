/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class Bai_2 {
    Set<String> words = new HashSet<String>();
    
    public void input() {
        Scanner sc =  new Scanner(System.in);
        System.out.printf("Nhập số lượng thành phố: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i< n; i++){
            System.out.printf("\tThành phố %d: ",i+1);
            String m = sc.nextLine();
            words.add(m);
        }
        
    }
    public void display() {
        System.out.print("Danh sách thành phố vừa nhập:");
        System.out.println(words);
    }
    public void sortASC(){
        System.out.printf("Danh sách thành phố tăng dần là:");
        TreeSet<String> treeSet = new TreeSet<>(words);
        System.out.println(treeSet);
    }
    public static void main(String[] args) {
        Bai_2 bai_2 = new Bai_2();
        bai_2.input();
        bai_2.display();
        bai_2.sortASC();
    }
}
