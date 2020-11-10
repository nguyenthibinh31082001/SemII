/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import person.Person;
import person.employee.Employee;
import person.student.Student;

/**
 *
 * @author Admin
 */
public class PersonManager {
    List<Person> lstPerson = new ArrayList<>();

    
    public PersonManager() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n người\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Sắp xếp thông tin theo tên người tăng dần và hiển thị\n");
            System.out.printf("\t4. Tìm kiếm thông tin theo tên người và đếm xem có bao nhiêu người có tên như vậy.\n");
            System.out.printf("\t5. Exit\n");
            
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
                    SortAscending();
                    break;
                case 4:
                    search(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-5!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.printf("Nhập thông tin nhân viên chọn (E), Nhập thông tin học sinh chọn (S): ");
        String str =  sc.nextLine();
         char c = ' ';
        if(str.length() >= 0){
             c = sc.nextLine().charAt(0);
        }
        System.out.printf("Số lượng người: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d:\n",i+1);
            if (c == 'E' || c == 'e') {
                Employee employee = new Employee();
                employee.input();
                lstPerson.add(employee);
                System.out.println(" ");
            } else if((c == 'S' || c == 's')){
                Student student = new Student();
                student.input();
                lstPerson.add(student);
                System.out.println(" ");
            }
        }
    }
    
    public void display() {
        for (int i = 0; i < lstPerson.size(); i++) {
            System.out.printf("Person %d:\n",i+1);
            if (lstPerson.get(i) instanceof Employee) {
                ((Employee) lstPerson.get(i)).display();
                System.out.println(" ");
            } else {
                ((Student) lstPerson.get(i)).display();
                System.out.println(" ");
            }
        }
    }
    public void SortAscending(){
        Collections.sort(lstPerson) ;
        System.out.println("Danh sách sắp xếp theo tên tăng dần là: ");
        for(Person f : lstPerson){
            System.out.println("");
            f.display();
        }
    }
    public void search(Scanner sc){
        Person searchPer;
        Person setPer = new Person();
        int i, count = 0;
       
        System.out.printf("Nhập tên cần tìm: ");
        sc.nextLine();
        String enterPer = sc.nextLine();
        setPer.setHoTen(enterPer);
        System.out.println("Dang sách tìm thấy: ");
        for ( i = 0; i < lstPerson.size(); i++){
            searchPer = lstPerson.get(i);
            if(searchPer.getHoTen().contains(enterPer)){
                count++;
                searchPer.display();
            }
        }
//        if(i == lstVehicles.size()){
//            System.out.println("Không tìm thấy loại xe này " +enterVeh);
//        }
        System.out.println("Số người có tên như vậy là: "+count);
    }
        
    public static void main(String[] args) {
        PersonManager app = new PersonManager();
        app.run();
    }
}
