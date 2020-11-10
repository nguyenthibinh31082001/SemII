/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL2;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class GiaoDich {
    private int MaGD;
    private String TenGD;
    private LocalDate NgayGD;
    private int MaDM;

    public GiaoDich() {
    }

    public GiaoDich(int MaGD, String TenGD, LocalDate NgayGD, int MaDM) {
        this.MaGD = MaGD;
        this.TenGD = TenGD;
        this.NgayGD = NgayGD;
        this.MaDM = MaDM;
    }

    public int getMaGD() {
        return MaGD;
    }

    public void setMaGD(int MaGD) {
        this.MaGD = MaGD;
    }

    public String getTenGD() {
        return TenGD;
    }

    public void setTenGD(String TenGD) {
        this.TenGD = TenGD;
    }

    public LocalDate getNgayGD() {
        return NgayGD;
    }

    public void setNgayGD(LocalDate NgayGD) {
        this.NgayGD = NgayGD;
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int MaDM) {
        this.MaDM = MaDM;
    }
    public void display() {
        System.out.printf("%d %13s %15s %15d\n",
        this.MaGD, this.TenGD, this.NgayGD, this.MaDM);
    }
}
