/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BTTH1 {
    List<String> lstSinhVien = new ArrayList<>();
    
    public void input() {
        lstSinhVien.add("Tuấn");
        lstSinhVien.add("Hà");
        lstSinhVien.add("Linh");
        System.out.println("ArrayList Student");
        System.out.print("\t" + lstSinhVien + "\n");
    }
    
    public void updateList() {
        lstSinhVien.set(1, "Hồng Hà");
        System.out.println("Update ArrayList Student");
        System.out.print("\t" + lstSinhVien + "\n");
    }
    
    public void deleteList() {
        lstSinhVien.remove(0);
        System.out.println("Delete ArrayList Student");
        System.out.print("\t" + lstSinhVien + "\n");
    }
    
    public static void main(String[] args) {
        BTTH1 btth1 = new BTTH1();
        btth1.input();
        btth1.updateList();
        btth1.deleteList();
    }
}
