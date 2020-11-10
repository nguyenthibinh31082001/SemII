/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nhanvien.BachKhoaAP.NhanVienBKAP;

/**
 *
 * @author ADMIN
 */
public class QLNhanVien {
//    NhanVienBKAP arrNV[] = new NhanVienBKAP[3];
      List<NhanVienBKAP> lstNhanVienBKAP = new ArrayList<>();


    
    public QLNhanVien() {
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);

        do{
            System.out.printf("************MENU**********\n");
            System.out.printf("\t1. Nhập\n");
            System.out.printf("\t2. Hiển thị\n");
            System.out.printf("\t3. Tìm kiếm theo tên nhân viên\n");
            System.out.printf("\t4. Sắp xếp mức lương cơ bản giảm dần\n");
            System.out.printf("\t5. Xếp loại - khen thưởng\n");
            System.out.printf("\t6. Exit\n");
            
            System.out.printf("Chọn chức năng 1-6: ");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    searchName(sc);
                    break;
                case 4:
                    SortDescending();
                    break;
                case 5:
                    xepLoai();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-6!!!");
            }
        }while(true);
    }
    public void input(Scanner sc){
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
//        Car car;
        for(int i = 0 ; i< n; i++){
            System.out.printf("Nhân viên %d: \n",i+1);
//            car = new Car();
            NhanVienBKAP nhanVienBKAP = new NhanVienBKAP();
            nhanVienBKAP.input();
            lstNhanVienBKAP.add(nhanVienBKAP);
        }
    }
    
    public void display() {
        System.out.println("Danh sách nhân viên vừa nhập:");
        for(NhanVienBKAP f : lstNhanVienBKAP){
            f.intro();
            System.out.println("\t------------------------------");
            System.out.println(" ");
            
        }
//        System.out.println(" ");
    }
    public void searchName(Scanner sc){
        NhanVienBKAP searchNhanVien;
        System.out.printf("Nhập tên nhân viên muốn tìm: ");
        String timKiem = Inputor.getString().toLowerCase();
        boolean isNull = true;
        for (int i = 0; i < lstNhanVienBKAP.size(); i++) {
            searchNhanVien = lstNhanVienBKAP.get(i);
            if (searchNhanVien.getTen().toLowerCase().contains(timKiem)) {
                searchNhanVien.intro();
                isNull = false;
            }
        }
        if (isNull) {
            System.err.println("Không tìm thấy nhân viên bạn muốn tìm");
        }
        
    }
    public void SortDescending(){
    Collections.sort(lstNhanVienBKAP, new Comparator<NhanVienBKAP>() {
            @Override
            public int compare(NhanVienBKAP o1, NhanVienBKAP o2) {
                if (o1.getLuongCoBan() < o2.getLuongCoBan()) {
                    return 1;
                } else {
                    if (o1.getLuongCoBan() == o2.getLuongCoBan()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    System.out.println("Danh sách mức lương cơ bản giảm dần là: ");
        for (int i = 0; i < lstNhanVienBKAP.size(); i++) {
            lstNhanVienBKAP.get(i).intro();
            System.out.println("\t------------------------------");
            System.out.println(" ");
        }
    }
    public void xepLoai(){
        List<NhanVienBKAP> lstNhanVienBKAP = new ArrayList<>();
        
        List<NhanVienBKAP> lstXuatSac = lstNhanVienBKAP.stream().filter((nv) -> {
            return nv.getSoNgayLam() > 26;
        }).collect(Collectors.toList());
        List<NhanVienBKAP> lstTot = lstNhanVienBKAP.stream().filter((nv) -> {
            return nv.getSoNgayLam() > 24 && nv.getSoNgayLam() <= 26;
        }).collect(Collectors.toList());
        System.out.println("\t *** KHEN THƯỞNG NHÂN VIÊN ***");
        if (lstXuatSac.size() > 0) {
            System.out.println("XUẤT SẮC");
            for (NhanVienBKAP xs : lstXuatSac) {
                xs.intro();
//                System.out.println("Khen thưởng nhân viên xuất sắc!!!");
                System.out.println("------------------------------");
            }
        } else if (lstTot.size() > 0) {
            System.out.println("TỐT");
            for (NhanVienBKAP xs : lstTot) {
                xs.intro();
//                System.out.println("Khen thưởng nhân viên tốt!!!");
                System.out.println("------------------------------");
            }
        } else {
        System.err.println("(Khiển trách toàn bộ nhân viên do số ngày nghỉ làm quá nhiều)");
        }
    }
    public static void main(String[] args) {
        QLNhanVien app = new QLNhanVien();
        app.run();
    }
}
