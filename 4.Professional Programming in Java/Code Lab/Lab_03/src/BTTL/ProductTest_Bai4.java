/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import BTTH_Phan01.DemoJp2Saveobject_BTTH3;
import BTTH_Phan01.NhanVien_BTHH3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductTest_Bai4 {
    List<Product_Bai4> lstProduct = new ArrayList<>();
    
    public void saveProduct() {
        Scanner sc  = new Scanner(System.in);
            System.out.printf("Nhập số lượng sản phẩm: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.printf("Sản phẩm %d:\n", i+1);
                Product_Bai4 product_Bai4 = new Product_Bai4();
                product_Bai4.input();
                lstProduct.add(product_Bai4);
            }
        try {
            // Ghi xuong file
            FileOutputStream file = new FileOutputStream("product.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(file);
            objOut.writeObject(lstProduct);
            objOut.flush();
            objOut.close();
        } catch (Exception e) {
            Logger.getLogger(ProductTest_Bai4.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    public void readProduct() {
        try {
            FileInputStream file = new FileInputStream("product.dat");
            ObjectInputStream objIn = new ObjectInputStream(file);
            lstProduct = (List<Product_Bai4>) objIn.readObject();
            objIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lstProduct.size(); i++) {
            System.out.println(lstProduct.get(i).toString());
        }
    }
     private void search() {
         Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập tên sản phẩm cần tìm: ");
        sc.nextLine();
        String name = sc.nextLine();
        int flag = 0;
        
        for (Product_Bai4 f : lstProduct) {
            if (f.getProName().toLowerCase().contains(name.trim().toLowerCase())) {
                f.toString();
                flag++;
                System.out.println("");
            }
        }

        if (flag == 0) {
            System.err.println("Không tìm thấy sản phẩm có tên là: " + name);
        }
    }
    public static void main(String[] args) {
        ProductTest_Bai4 demo = new ProductTest_Bai4();
        demo.saveProduct();
        demo.readProduct();
        demo.search();
    }
}
