/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class Bai_3 {
    public static void main(String[] args) {
        Map<Integer, String> quocGia = new HashMap<Integer, String>();
    
        TreeSet sortASC = new TreeSet<Integer>();
        
        Scanner sc =  new Scanner(System.in);
        System.out.printf("Nhập số lượng quốc gia: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i< n; i++){
            System.out.printf("\tQuốc gia %d: ",i+1);
            String m = sc.nextLine();
            quocGia.put(i, m);
            sortASC.add(m);
        }
        
        System.out.print("Danh sách thành phố vừa nhập:");
        System.out.println(quocGia);
        
        System.out.printf("Danh sách thành phố tăng dần là:");
        System.out.println(sortASC);
    }
}
