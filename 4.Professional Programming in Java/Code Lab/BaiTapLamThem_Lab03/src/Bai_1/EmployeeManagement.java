/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class EmployeeManagement {

    Map<Integer, Employee> lstEmployee = new HashMap<Integer, Employee>();
    
    public EmployeeManagement() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n nhân viên\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Sắp xếp danh sách giảm dần theo tổng lương và hiển thị .\n");
            System.out.printf("\t4. Thống kê mỗi quê có bao nhiêu người cùng quê với nhau .\n");
            System.out.printf("\t5. Thoát lưu thông tin vào tệp tin .\n");
            
            System.out.printf("Chọn chức năng 1-5: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortPriceDESC();
                    break;
                case 4:
                    thongKeQue();
                    break;
                case 5:
                    saveFile();
                    readFile();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-5!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Nhân viên %d: \n",i+1);
            Employee employee = new Employee();
            employee.input();
            lstEmployee.put(i, employee);
//            sortYearASC.add(bai_5);

        
        }
    }
    
    public void display() {
        System.out.println("----- Danh sách nhân viên vừa nhập -----");
//        System.out.println("Id\t\tName\tGiới tính\t\tNgày\tprice");
        for (Map.Entry<Integer, Employee> entrySet : lstEmployee.entrySet()) {
            Integer key = entrySet.getKey();
            Employee value = entrySet.getValue();
            System.out.println(key + " ==> " + value);
        }
    }
    private void sortPriceDESC() {
        List<Employee> employee = new ArrayList<Employee>(lstEmployee.values());
        Collections.sort(employee, new Comparator<Employee>() {
           public int compare(Employee o1, Employee o2) {
               return (int) (o2.getTongLuong()- o1.getTongLuong());
           }
        });
        System.out.println("----- Danh sách nhân viên sau khi sắp xếp -----");
        int i = 0;
        for (Employee e : employee) {
//           System.out.println(e.getId()+", "+e.getName()+", "+e.getGender()+e.getBirthday()+", "+e.getQueQuan()+", "+e.getPhongBan()+", "+e.getViTri()+", "+ e.getTongLuong());
           System.out.println(i+++" ==> " +e.toString());
        }
    }
    private void thongKeQue() {
        List<Employee> emple = new ArrayList<Employee>(lstEmployee.values());
        Employee e = new Employee();
//        int count = 0;
//        for (int i = 0; i < employee.size(); i++) {
//            if (e.getQueQuan() == e.getQueQuan()) {
//                count++;
//                System.out.println(e.getQueQuan());
//            }
//        }
//        System.out.println("sl" +count);
        
        
//        System.out.printf("Nhập tên sách cần tìm: ");
//        sc.nextLine();
//        String name = sc.nextLine();
            String que = e.getQueQuan();
        int flag = 0;
        
        for (Employee f : emple) {
            if (f.getQueQuan().toLowerCase().contains(que.trim().toLowerCase())) {
                f.toString();
                flag++;
                System.out.println("");
            }
        }
            System.out.println("sl = "+flag);
//        if (flag == 0) {
//            System.err.println("Không tìm thấy sách có tên là: " + name);
//        }
    }
    private void saveFile(){
        List<Employee> emple = new ArrayList<Employee>(lstEmployee.values());
        try (
                FileOutputStream fos = new FileOutputStream("Empoyee.txt");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                
                ){
             for (Employee emp : emple) {
                bw.write(emp.toString());
                bw.newLine();
            }
                System.err.println("Ghi dữ liệu thành công vào file 'Empoyee.txt'!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void readFile(){
        List<Employee> lstBookFromFile = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("Empoyee.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                
                ){
            String str;
            while( (str= br.readLine()) !=null){
                String fileds[] = str.split(",");
                Employee b = new Employee();
                    b.setId(fileds[0].split("=")[1]);
                    b.setName(fileds[1].split("=")[1]);
                    b.setGender(Boolean.parseBoolean(fileds[2].split("=")[1]));
                    b.setBirthday(LocalDate.parse(fileds[3].split("=")[1]));
                    b.setQueQuan(fileds[4].split("=")[1]);
                    b.setPhongBan(fileds[5].split("=")[1]);
                    b.setViTri(fileds[6].split("=")[1]);
                    b.setTongLuong(Float.parseFloat(fileds[7].split("=")[1]));
                lstBookFromFile .add(b);
            }
            System.err.println("Dữ liệu đọc từ file Employee.txt: ");
            lstBookFromFile.forEach(o -> System.out.println(o.toString()));
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.run();
    }
    
}
