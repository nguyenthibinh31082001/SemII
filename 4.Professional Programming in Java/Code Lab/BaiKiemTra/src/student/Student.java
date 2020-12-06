/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student implements Serializable{
    private int id;
    private String ten;
    private boolean gioitinh;
    private int tuoi;
    private float toan;
    private float ly;
    private float hoa;
    private float trungbinh;

    public Student() {
    }

    public Student(int id, String ten, boolean gioitinh, int tuoi, float toan, float ly, float hoa, float trungbinh) {
        this.id = id;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.tuoi = tuoi;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.trungbinh = trungbinh;
    }

    public Student(String ten, boolean gioitinh, int tuoi, float toan, float ly, float hoa, float trungbinh) {
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.tuoi = tuoi;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.trungbinh = trungbinh;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }
    public String getGioiTinh(){
        return gioitinh == true ? "Nam":"Nữ";
    }
    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getTrungbinh() {
        trungbinh = (toan+ly+hoa)/3;
        return trungbinh;
    }

    public void setTrungbinh(float trungbinh) {
        this.trungbinh = trungbinh;
    }

    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.print("\tNhập tên sinh viên: ");
        this.ten = s.nextLine();
        while(true){
            if(this.ten.length() > 0 ){
                  break;
              }else{
                  System.err.println("\tTên sinh viên không được để trống !!!");  
                  System.out.printf("\tNhập lại tên sinh viên: ");
                  ten = s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("\tNhập giới tính(true:Nam/false:Nữ):");
                this.gioitinh = s.nextBoolean();
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập true/false!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("\tNhập tuổi:");
                this.tuoi = s.nextInt();
                while(tuoi < 0 ){
                    System.err.println("\tTuổi phải lớn hơn 0!!!");  
                    System.out.printf("\tNhập lại tuổi: ");
                    tuoi = s.nextInt();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm toán: ");
                this.toan = s.nextFloat();
                while(toan < 0 || toan > 20){
                    System.err.println("\tĐiểm toán là thang 20đ!!!");  
                    System.out.printf("\tNhập điểm toán: ");
                    toan = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm lý: ");
                this.ly = s.nextFloat();
                while(ly < 0 || ly > 20){
                    System.err.println("\tĐiểm lý là thang 20đ!!!");  
                    System.out.printf("\tNhập điểm lý: ");
                    ly = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập điểm hóa: ");
                this.hoa = s.nextFloat();
                while(hoa < 0 || hoa > 20){
                    System.err.println("\tĐiểm hóa là thang 20đ!!!");  
                    System.out.printf("\tNhập điểm hóa: ");
                    hoa = s.nextFloat();
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tPhải nhập số!!!");
                  s.nextLine();
            }
        }
    }
    public void output(){
        System.out.printf("%-5d %-20s %-15s %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n",
        this.id,this.ten, getGioiTinh(), this.tuoi, this.toan, this.ly, this.hoa, this.trungbinh);
    }
}
