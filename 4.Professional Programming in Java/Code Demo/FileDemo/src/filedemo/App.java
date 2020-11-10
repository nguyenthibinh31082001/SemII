/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedemo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ADMIN
 */
public class App {

    static List<Person> lst = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        App objApp = new App();
        String pathName = "database";
        String pathFileName = pathName + "/person.abc";
        String pathFileObjectName = pathName + "/person.object";
        
        
        objApp.initData();
        
        
        //*
        objApp.createFolder(pathName);
        // Gọi hàm tạo file
        objApp.createFile(pathFileName);
        
        
        objApp.writeDataFile(pathFileName, lst);
        //*/
         objApp.readDataFile(pathFileName);
        objApp.writeObjectFile(pathFileObjectName, lst);
        
        objApp.readObjectFile(pathFileObjectName);
    }
    
    public void createFolder(String pathName){
        File objFile = new File(pathName);
       // Kiem tra duong dan co ton tai?
       if(objFile.exists()){
           System.out.println("Đường dẫn đã tồn tại");
           if(objFile.isDirectory()){
               System.out.println("Thư mục đã tồn tại");
           }           
       }else{
           objFile.mkdir();
           System.out.println("Thư mục không tồn tại. Đã tạo thư mục");
       }
    }
    
    public void createFile(String pathName){
        File objFile = new File(pathName);
        if(objFile.exists()){
            System.out.println("Đã tồn tại tệp tin này: " + pathName);
        }else{
            try {
                  objFile.createNewFile();
                  System.out.println("Tạo tệp tin thành công!");
            } catch (IOException e) {
                System.out.println("Có lỗi tạo tệp tin " + e.getMessage());
            }
        }
        
    }
    
    /**
     * Phương thức ghi dữ liệu dạng chuỗi
     * @param pathName
     * @param data 
     */
    public void writeDataFile(String pathName, List<Person> data){
        File ojbFile = new File(pathName);
        //try-with-resource
        try(
                // Tạo đối tượng quản lý luồng kết nối dữ liệu
                FileOutputStream fos = new FileOutputStream(ojbFile);
                // Lớp ghi dữ liệu
                BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(fos));
            ){
            for (Person p : data) {
                bw.write(p.toString());
                bw.newLine();
            }
            System.out.println("Ghi thành công");
        }catch (IOException e){
            System.out.println("Lỗi ghi dữ liệu ra tệp "+ pathName);
        }
    }
    
    public void readDataFile(String pathName){
        File objFile = new File(pathName);
        
        try {
            FileInputStream fis = new FileInputStream(objFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            
            int numLine = 1;
            String line;
            
            while ((line = br.readLine()) != null) {
                System.out.println(numLine + ": "+ line);
                numLine++;
            }
            
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        
    }
    
    public void writeObjectFile(String pathName, List<Person> lstPersons){
        try {
             FileOutputStream fos = new FileOutputStream(pathName);
             ObjectOutputStream os = new ObjectOutputStream(fos);
             
             os.writeObject(lstPersons);
             System.out.println("Ghi du lieu thanh cong");
        } catch (IOException e) {
            
        }
       
    }

    private void readObjectFile(String pathFileObjectName) {
        try (
                FileInputStream fis = new FileInputStream(pathFileObjectName);
                ObjectInputStream is = new ObjectInputStream(fis);
                ){
            
           List<Person> lstPerson = (List<Person>)is.readObject();
            for (Person p : lstPerson) {
                System.out.println(p.toString());
            }
            System.out.println("======================");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void initData(){
        Person p = new Person(1, "Trần Quang Đạo", true, LocalDate.of(2002, 1, 1));
        lst.add(p);
        p = new Person(2, "Trần Duy Tiến", true, LocalDate.of(2002, 7, 8));
        lst.add(p);
    }
}
