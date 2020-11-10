/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.io.File;

/**
 *
 * @author ADMIN
 */
public class BTTH1 {

    void createFolder(String path){
        File folder = new File(path);
        
        if(folder.exists()){
            System.out.println("Đã tồn tại đường dẫn này!");
            if(folder.isDirectory()){
                System.out.println("Đã tồn tại thư mục này");
            }
        }else{
            folder.mkdirs();
            System.err.println("Không tồn tại đường dẫn này!");
        }
    }
    void createFlie(String path){
        File file = new File(path);
        
        if(file.exists()){
            System.out.println("Đã tồn tại file này!");
        }else{
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.err.println("Lỗi tạo file: "+e.toString());
            }
            System.err.println("Không tồn tại file này!");
        }
    }
    public static void main(String[] args) {
        BTTH1 btth1 = new BTTH1();
        btth1.createFolder("bkap/slide");
        btth1.createFlie("bkap/slide/sinhvien.db");
    }
}
