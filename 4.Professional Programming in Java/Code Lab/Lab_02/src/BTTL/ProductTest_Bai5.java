/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author ADMIN
 */
public class ProductTest_Bai5 {
    Map<Integer, Product_Bai5> mapProduct = new HashMap<Integer, Product_Bai5>();
        
//    TreeSet sortYearASC = new TreeSet<Integer>();
    public void input(){
        Scanner  sc = new Scanner(System.in);
        System.out.printf("Nhập số lượng sản phẩm: ");
        int n = sc.nextInt();
       
        for(int i = 0 ; i< n; i++){
            System.out.printf("Sản phẩm %d: \n",i+1);
            Product_Bai5 bai_5 = new Product_Bai5();
            bai_5.input();
            mapProduct.put(i, bai_5);
//            sortYearASC.add(bai_5);

        
        }
        
    }
    public void display(){
        System.out.println("Danh sách sản phẩm vừa nhập:");
        System.out.println("proId\tproName\t\tproducer\tyearMaking\tprice");
        
        for (Map.Entry<Integer, Product_Bai5> entrySet : mapProduct.entrySet()) {
            Integer key = entrySet.getKey();
            Product_Bai5 value = entrySet.getValue();
            System.out.println(key + " - " + value);
        }
//        System.out.println(mapProduct);
    }
    public void sortYearASC(){
        System.out.println("Danh sách năm sản xuất tăng dần là:");
        System.out.println("isbn\t\tbookName\tauthor\t\tpublisher\tprice");
        List<Map.Entry<Integer, Product_Bai5>> list1 = new ArrayList<>(mapProduct.entrySet());
 
        // Create a comparator to sort by value
        Comparator<Entry<Integer, Product_Bai5>> valueComparator = new Comparator<Entry<Integer, Product_Bai5>>() {
            @Override
            public int compare(Entry<Integer, Product_Bai5> o1, Entry<Integer, Product_Bai5> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
 
        // Sorting a List
        Collections.sort(list1, valueComparator);
 
        // Convert List to Map
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Product_Bai5> entry : list1) {
            sortedMap.put(entry.getValue(), entry.getValue());
        }
        System.out.println("Sorted map: " + sortedMap);
//        System.out.println(sortYearASC);
        
    }
    public static void main(String[] args) {
        ProductTest_Bai5 productTest_Bai5 = new ProductTest_Bai5();
        productTest_Bai5.input();
        productTest_Bai5.display();
        productTest_Bai5.sortYearASC();
    }
}
