/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien.BachKhoaAP;

/**
 *
 * @author ADMIN
 */
public class NhanVienBKAP extends nhanvien.NhanVien{
    float thuong;

    public NhanVienBKAP() {
    }

    public NhanVienBKAP(float thuong, String ten, String diaChi, float luongCoBan, int soNgayLam) {
        super(ten, diaChi, luongCoBan, soNgayLam);
        this.thuong = thuong;
    }

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }
    
    @Override
    public float tinhluong() {
        return soNgayLam * (luongCoBan / 26);
    }
    public float tinhluong(boolean coThuong) {
        if (coThuong) {
            return soNgayLam * (luongCoBan / 26) + thuong;
        } else {
            return tinhluong();
        }
    }
    @Override
    public String xeploai() {
        if (soNgayLam <= 10) {
            return "KÉM";
        } else if (soNgayLam > 10 && soNgayLam <= 20) {
            return "TRUNG BÌNH";
        } else if (soNgayLam > 20 && soNgayLam <= 24) {
            return "KHÁ";
        } else if (soNgayLam > 24 && soNgayLam <= 26) {
            return "TỐT";
        } else if (soNgayLam > 26) {
            return "XUẤT SẮC";
        } else {
            return "KHÔNG XÁC ĐỊNH";
        }
    }
    public void input() {
        System.out.printf("\tNhập họ tên nhân viên: ");
        this.ten = Inputor.getString();
        System.out.printf("\tNhập địa chỉ: ");
        this.diaChi = Inputor.getString();
        System.out.printf("\tNhập lương cơ bản (tháng): ");
        this.luongCoBan = Inputor.getFloat();
        System.out.printf("\tNhập số ngày làm: ");
        this.soNgayLam = Inputor.getInteger();
        System.out.printf("\tNhập thưởng: ");
        this.thuong = Inputor.getFloat();
    }
    @Override
    public void intro() {
        System.out.println("\tXin chào: " + this.ten);
        System.out.println("\t(" + this.diaChi + ")");
        System.out.println("\tLương cơ bản: " + this.luongCoBan);
        System.out.println("\tLương thực lĩnh: " + tinhluong());
        System.out.println("\tLương thực lĩnh (+ thưởng): " + tinhluong(true));
        System.out.println("\tXếp loại: " + xeploai());
    }
}
