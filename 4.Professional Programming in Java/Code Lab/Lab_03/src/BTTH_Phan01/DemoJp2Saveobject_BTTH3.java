/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DemoJp2Saveobject_BTTH3 {
    
    public void saveNhanVien() {
        List<NhanVien_BTHH3> lstNhanVien = new ArrayList<>();
        
        NhanVien_BTHH3 nv1 = new NhanVien_BTHH3("Nguyen Van A", 18, "HN");
        NhanVien_BTHH3 nv2 = new NhanVien_BTHH3("Elly Truong", 18, "HCM");
        NhanVien_BTHH3 nv3 = new NhanVien_BTHH3("Ngoc Trinh", 18, "DN");
        lstNhanVien.add(nv1);
        lstNhanVien.add(nv2);
        lstNhanVien.add(nv3);
        
        try {
            // Ghi xuong file
            FileOutputStream file = new FileOutputStream("data.db");
            ObjectOutputStream objOut = new ObjectOutputStream(file);
            objOut.writeObject(lstNhanVien);
            objOut.flush();
            objOut.close();
        } catch (Exception e) {
            Logger.getLogger(DemoJp2Saveobject_BTTH3.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    public void readNhanVien() {
        List<NhanVien_BTHH3> lstNhanVien = new ArrayList<>();
        
        try {
            FileInputStream file = new FileInputStream("data.db");
            ObjectInputStream objIn = new ObjectInputStream(file);
            lstNhanVien = (List<NhanVien_BTHH3>) objIn.readObject();
            objIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lstNhanVien.size(); i++) {
            System.out.println(lstNhanVien.get(i).toString());
        }
    }
    public static void main(String[] args) {
        DemoJp2Saveobject_BTTH3 demo = new DemoJp2Saveobject_BTTH3();
        demo.saveNhanVien();
        demo.readNhanVien();
    }
    
}
