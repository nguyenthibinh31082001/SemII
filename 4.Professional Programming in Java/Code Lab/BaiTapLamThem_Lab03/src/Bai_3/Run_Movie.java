/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Run_Movie {
    List<Movie> lstMovie = new ArrayList<>();
    
    public Run_Movie() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("\t************MENU**********\n");
            System.out.printf("\t1. Nhập thông tin cho n vé\n");
            System.out.printf("\t2. Hiển thị thông tin vừa nhập\n");
            System.out.printf("\t3. Tính tổng giá tiền của tất cả các vé trong danh sách\n");
            System.out.printf("\t4. Sắp xếp các phần tử trong mảng tăng dần theo ngày xem và xuất chiếu\n");
            System.out.printf("\t5. Thoát chương trình ghi dữ liệu ra tệp VE.txt & Tự động đọc dữ liệu khi chạy chương trình \n");
            
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
                    tongGia();
                    break;
                case 4:
//                    dienTichMax();
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
        System.out.print("Nhập số lượng vé xem phim: ");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.printf("Vé %d: \n",i+1);
            Movie movie = new Movie();
            movie.input();
            lstMovie.add(movie);
        }
    }
    
    public void display() {
        System.out.println("----- Danh sách các vé vừa nhập -----");
        for (Movie m : lstMovie) {
            m.toString();
            System.out.println("");
        }
    }
    public void tongGia() {
        float tong = 0;
        for (int i = 0; i < lstMovie.size(); i++) {
            Movie c = ((Movie) lstMovie.get(i));
            tong += c.getGia();
        }
        System.out.println("Tổng giá tiền của tất cả các vé là: "+tong);
    }
    private void saveFile(){
        try (
                FileOutputStream fos = new FileOutputStream("VE.txt");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                
                ){
             for (Movie m : lstMovie) {
                bw.write(m.toString());
                bw.newLine();
            }
                System.err.println("Ghi dữ liệu thành công vào file 'VE.txt'!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void readFile(){
        List<Movie> lstVE = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream("City.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                
                ){
            String str;
            while( (str= br.readLine()) !=null){
                String fileds[] = str.split(",");
                Movie m = new Movie();
                    m.setTen(fileds[0].split("=")[1]);
                    m.setGia((fileds[1].split("=")[1]));
                    m.setXuatChieu((fileds[2].split("=")[1]));
                    m.setNgayXem((fileds[3].split("=")[1]));
                lstVE .add(m);
            }
            System.err.println("Dữ liệu đọc từ file City.txt là: ");
            lstVE.forEach(o -> System.out.println(o.toString()));
            System.out.println("");
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Run_Movie run_Movie = new Run_Movie();
        run_Movie.run();
    }
}
