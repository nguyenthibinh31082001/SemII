/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author ADMIN
 */
public class BTTH2 {
    
    public static void main(String[] args) {
        int count[] = {34, 22, 10, 60, 30, 22};
        System.out.println("Mảng đầu tiên: " + Arrays.toString(count));
        
        TreeSet sortedSet = new TreeSet<Integer>();
        for (int i = 0; i < 5; i++) {
            sortedSet.add(count[i]);
        }
        System.out.println("Danh sách được sắp xếp là:");
        System.out.println(sortedSet);
        
        System.out.println("Phần tử đầu tiên của mảng là: "
        + (Integer) sortedSet.first());
        System.out.println("Phần tử cuối cùng của mảng là: "
        + (Integer) sortedSet.last());
    }
    
}
