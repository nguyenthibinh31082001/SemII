/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static java.lang.Float.max;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Run_City {
    List<City> lstCity = new ArrayList<>();
    
    public Run_City() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n tỉnh\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Tính tổng diện tích của tất cả các tỉnh trong dslk. \n");
            System.out.printf("\t4. Tìm địa chỉ của node chứa tỉnh có diện tích lớn nhất trong danh sách. \n");
            System.out.printf("\t5. Tìm một tỉnh có dân số lớn nhất trong dslk đơn\n");
            System.out.printf("\t6. Sắp xếp danh sách tăng dần theo diện tích. \n");
            System.out.printf("\t7. Ghi, đọc dữ liệu ra tệp và thoát chương trình\n");
            
            System.out.printf("Chọn chức năng 1-7: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    tongDienTich();
                    break;
                case 4:
                    dienTichMax();
                    break;
                case 5:
//                    thongKeQue();
                    break;
                case 6:
                    sortDienTichASC();
                    break;
                case 7:
                    saveFile();
                    readFile();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-7!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng tỉnh: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Tỉnh %d: \n",i+1);
            City city = new City();
            city.input();
            lstCity.add(city);
        }
    }
    
    public void display() {
        System.out.println("----- Danh sách các tỉnh vừa nhập -----");
        System.out.println("Tên\tDiện tích\tDân số");
        for (City cty : lstCity) {
            cty.toString();
            System.out.println("");
        }
    }
    public void tongDienTich() {
        float tong = 0;
        for (int i = 0; i < lstCity.size(); i++) {
            City c = ((City) lstCity.get(i));
            tong += c.getDienTich();
        }
        System.out.println("Tổng diện tích các tỉnh là: "+tong);
    }
    public void dienTichMax() {
        City c =new City(); 
        float s = c.getDienTich();
        float max= 0;
        for (City i : lstCity) {  
            if (max < s) { 
                max = s; 
            } 
        } 
//        City max = lstCity.get(0);  
//        for (int i = 1; i < lstCity.size(); i++) {
//            if (lstCity.get(i).compareTo(max) > 0) {
//                max = lstCity.get(i);
//            }
//	}
//        System.out.println("Tỉnh có diện tích lớn nhất: "+max);
        System.out.println("Max = " + s);
    }
    private void sortDienTichASC() {
        Collections.sort(lstCity, new Comparator<City>() {
           public int compare(City o1, City o2) {
               return (int) (o1.getDienTich()- o2.getDienTich());
           }
        });
        System.out.println("----- Danh sách diện tích tăng dần là -----");
        System.out.println("Tên\tDiện tích\tDân số");
        int i = 0;
        for (City c : lstCity) {
//           System.out.println(e.getId()+", "+e.getName()+", "+e.getGender()+e.getBirthday()+", "+e.getQueQuan()+", "+e.getPhongBan()+", "+e.getViTri()+", "+ e.getTongLuong());
//           System.out.println(i+++" ==> " +c.toString());
            c.toString();
            System.out.println("");
        }
    }
    private void saveFile(){
        try (
                FileOutputStream fos = new FileOutputStream("City.txt");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                
                ){
             for (City cty : lstCity) {
                bw.write(cty.toString());
                bw.newLine();
            }
                System.err.println("Ghi dữ liệu thành công vào file 'City.txt'!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void readFile(){
        List<City> lstCty = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("City.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                
                ){
            String str;
            while( (str= br.readLine()) !=null){
                String fileds[] = str.split(",");
                City c = new City();
                    c.setTen(fileds[0].split("=")[1]);
                    c.setDienTich(Float.parseFloat(fileds[2].split("=")[1]));
                    c.setDanSo(Long.parseLong(fileds[3].split("=")[1]));
                lstCty .add(c);
            }
            System.err.println("Dữ liệu đọc từ file City.txt là: ");
            lstCty.forEach(o -> System.out.println(o.toString()));
            System.out.println("");
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Run_City run_City = new Run_City();
        run_City.run();
    }
}
