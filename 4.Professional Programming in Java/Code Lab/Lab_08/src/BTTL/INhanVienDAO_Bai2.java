/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface INhanVienDAO_Bai2 {
    public List<NhanVien_Bai2>getAllNhanVien();
    public NhanVien_Bai2 getNhanVien(int id);
    public void updateNhanVien(NhanVien_Bai2 nhanvien);
    public void deleteNhanVien(NhanVien_Bai2 nhanvien);
}
