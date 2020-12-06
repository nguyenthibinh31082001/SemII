/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVientDaoImpl_Bai2 implements INhanVienDAO_Bai2{
    List<NhanVien_Bai2>nhanviens;
    
    public NhanVientDaoImpl_Bai2() {
        nhanviens = new ArrayList<NhanVien_Bai2>();
        NhanVien_Bai2 nv1 = new NhanVien_Bai2(001,"Nguyễn Văn A",2001,"HN","0369982341",100);
        NhanVien_Bai2 nv2 = new NhanVien_Bai2(002,"Nguyễn Văn B",2002,"HN","0369982342",200);
        NhanVien_Bai2 nv3 = new NhanVien_Bai2(003,"Nguyễn Văn C",2003,"HN","0369982343",300);
        nhanviens.add(nv1);
        nhanviens.add(nv2);
        nhanviens.add(nv3);
    }
    
    
    @Override
    public List<NhanVien_Bai2> getAllNhanVien() {
        return nhanviens;
    }

    @Override
    public NhanVien_Bai2 getNhanVien(int id) {
        return nhanviens.get(id);
    }

    @Override
    public void updateNhanVien(NhanVien_Bai2 nhanvien) {
        nhanviens.get(nhanvien.getId()).setName(nhanvien.getName());
        System.out.println("Nhân viên : Id " + nhanvien.getId()+ ", updated in the database");
    }

    @Override
    public void deleteNhanVien(NhanVien_Bai2 nhanvien) {
        nhanviens.remove(nhanvien.getId());
        System.out.println("Nhân viên : Id " + nhanvien.getId()+ ", deleted from database");
    }
    
    
    public static void main(String[] args) {
        NhanVientDaoImpl_Bai2 b2 = new NhanVientDaoImpl_Bai2();
        b2.hienthi();
        b2.capnhat();
        b2.xoa();
        
    }
    public void hienthi(){
        INhanVienDAO_Bai2 NhanVienDao = new NhanVientDaoImpl_Bai2();

        for (NhanVien_Bai2 nv : NhanVienDao.getAllNhanVien()) {
            System.out.println("NhanVien: [Id : " + nv.getId()+ ", Name : "
            + nv.getName() + "," + nv.getYearOfBirth()+ "," + nv.getAddress()+ "," + nv.getPhone()+ ","
                    + nv.getSalary()+ " ]");
        }
    }
    public void xoa(){
        INhanVienDAO_Bai2 NhanVienDao = new NhanVientDaoImpl_Bai2();
        NhanVien_Bai2 nv = NhanVienDao.getAllNhanVien().get(0);
        nv.setId(2);
        NhanVienDao.deleteNhanVien(nv);

        NhanVienDao.getNhanVien(0);
        System.out.println("NhanVien: [Id : " + nv.getId()+ ", Name : "
            + nv.getName() + "," + nv.getYearOfBirth()+ "," + nv.getAddress()+ "," + nv.getPhone()+ ","
                    + nv.getSalary()+ "]");
    }
    public void capnhat(){
        INhanVienDAO_Bai2 NhanVienDao = new NhanVientDaoImpl_Bai2();
         NhanVien_Bai2 nv = NhanVienDao.getAllNhanVien().get(0);
        nv.setName("Nguyễn Văn D");
        NhanVienDao.updateNhanVien(nv);

        NhanVienDao.getNhanVien(0);
        System.out.println("NhanVien: [Id : " + nv.getId()+ ", Name : "
            + nv.getName() + "," + nv.getYearOfBirth()+ "," + nv.getAddress()+ "," + nv.getPhone()+ ","
                    + nv.getSalary()+ " ]");
       
    }
}
