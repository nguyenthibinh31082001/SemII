/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DemoJP2SaveText_BTTH2 {

    public DemoJP2SaveText_BTTH2() {
    }
    
    
    public void writeText2File(List<NhanVien_BTTH2> lstData) throws IOException{
        String filePath = "writeText2File.txt";
        boolean isVietTiep = false;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // Ghi ra file
        for (NhanVien_BTTH2 nhanVien : lstData) {
        osw.write(nhanVien.toString());
        }
        osw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        osw.close(); // Đóng kết nối tới file
    }
    public void writeTextByLine(List<NhanVien_BTTH2> lstData) throws FileNotFoundException, IOException {
        String filePath = "writeTextByLine.txt";
        boolean isVietTiep = true;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Ghi ra file
        for (NhanVien_BTTH2 nhanVien : lstData) {
        bw.write(nhanVien.toString());
        bw.newLine(); // thêm dòng mới gọi
        }
        bw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        bw.close(); // Đóng kết nối tới file
    }
    public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "writeTextByLine.txt";
        File myFile = new File(filePath);
        FileInputStream fos = new FileInputStream(myFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fos));
        String temp;
        int cnt = 1;
        while ((temp = br.readLine()) != null) {
        System.out.println(cnt + ". \t" + temp);
        cnt++;
        }
    }
    public static void main(String[] args) {
        try {
            DemoJP2SaveText_BTTH2 demoJP2SaveText_BTTH2 = new DemoJP2SaveText_BTTH2();
            // Du lieu ao
            List<NhanVien_BTTH2> lstNhanVien = new ArrayList<>();
            NhanVien_BTTH2 nv1 = new NhanVien_BTTH2("Nguyen Van A", 18, "HN");
            NhanVien_BTTH2 nv2 = new NhanVien_BTTH2("Elly Truong", 18, "HCM");
            NhanVien_BTTH2 nv3 = new NhanVien_BTTH2("Ngoc Trinh", 18, "DN");
            lstNhanVien.add(nv1);
            lstNhanVien.add(nv2);
            lstNhanVien.add(nv3);
            demoJP2SaveText_BTTH2.writeTextByLine(lstNhanVien);
            demoJP2SaveText_BTTH2.readTextByLine();
            demoJP2SaveText_BTTH2.writeText2File(lstNhanVien);
            System.out.println("Ghi dữ liệu thành công!!!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
            Logger.getLogger(DemoJP2SaveText_BTTH2.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
