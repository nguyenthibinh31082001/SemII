/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BTTH2 {
    String tenSinhVien;
    int tuoi;
    float diemJava;
    
    public static void main(String[] args) {
        BTTH2 btth2  = new BTTH2();
        btth2.getTime();
        btth2.copyArray();
        
        System.out.println("Tên class là: "+btth2.getClass().getName());
        Field arrField[] = btth2.getClass().getDeclaredFields();
        System.out.println("Bài thực hành 2 có các biến: ");
        for (int i = 0; i < arrField.length; i++) {
            Field thuocTinh = arrField[i];
            System.out.println(thuocTinh.getName());
        }
        
        Method arrMethod[] = btth2.getClass().getDeclaredMethods();
        System.out.println("Bài thực hành 2 có các hàm: ");
        for (int i = 0; i < arrMethod.length; i++) {
            Method thuocTinh = arrMethod[i];
            System.out.println(thuocTinh.getName());
        }
    }
    
    
    private void getTime() {
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        System.out.println("CurrentTimeMillis = "+time);
        Format format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println("Date = "+format.format(date));
    }

    private void copyArray() {
        int arrSoNguyen[] = new int[]{1,6,5,9,8};
        int temp[] = new int[5];
        System.arraycopy(arrSoNguyen,0,temp,0,arrSoNguyen.length);
        for (int i = 0; i < temp.length; i++) {
            System.out.println("#" + temp[i]);
        }
    }
}
