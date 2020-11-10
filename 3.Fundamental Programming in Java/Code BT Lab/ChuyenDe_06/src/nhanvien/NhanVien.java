/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;

/**
 *
 * @author ADMIN
 */
public class NhanVien implements INhanvien{
    
    protected String ten; // Tên nhân viên
    protected String diaChi; // Địa chỉ
    protected float luongCoBan; // Lương cơ bản hàng tháng (VD: 970.000)
    protected int soNgayLam;

    public NhanVien() {
    }

    public NhanVien(String ten, String diaChi, float luongCoBan, int soNgayLam) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.luongCoBan = luongCoBan;
        this.soNgayLam = soNgayLam;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    
    public void intro(){
        System.out.println("\tXin chào: " + this.ten);
        System.out.println("\t(" + this.diaChi + ")");
        System.out.println("\tLương cơ bản: " + this.luongCoBan);
        System.out.println("\tLương thực lĩnh: " + tinhluong());
        System.out.println("\tXếp loại: " + xeploai());
    }   
    @Override
    public float tinhluong() {
        return soNgayLam * (luongCoBan / 24);
        
    }

    @Override
    public String xeploai() {
        if (soNgayLam <= 10) {
            return "KÉM";
        } else if (soNgayLam > 10 && soNgayLam <= 20) {
            return "TRUNG BÌNH";
        } else if (soNgayLam > 20 && soNgayLam <= 22) {
            return "KHÁ";
        } else if (soNgayLam > 22) {
            return "TỐT";
        } else {
            return "KHÔNG XÁC ĐỊNH";
        }
    }
    
}
