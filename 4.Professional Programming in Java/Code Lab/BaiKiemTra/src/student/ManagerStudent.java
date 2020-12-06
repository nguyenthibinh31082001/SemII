/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ManagerStudent {
    private Connection conn;
    ArrayList<Student> lstStudent = new ArrayList<>();
    public ManagerStudent() {
        conn = Connect.getConnection();
        if (conn != null) {
            System.err.println("Kết nối thành công!!!");
        } else {
            System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    public static void main(String[] args) {
        ManagerStudent manager = new ManagerStudent();
        
        
        while (true) {
            System.out.println("\t.: MENU :.");
            System.out.println("1. Nhập vào danh sách N sinh viên");
            System.out.println("2. Xuất danh sách N sinh viên sắp xếp theo họ tên");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm sinh viên");
            System.out.println("6. Xuất danh sách N sinh viên ra file sinhvien.txt");
            System.out.println("7. Thoát");

            Scanner s = new Scanner(System.in);
            try {
                System.out.printf("Mời chọn từ 1 -> 7: ");
                int choose = s.nextInt();
                switch (choose) {
                    case 1:
                        manager.insert();
                        break;
                    case 2:
                        manager.getAllStudent();
                        break;
                    case 3:
                        Student st = new Student();
                        st.input();
                        manager.Update(st);
                        break;
                    case 4:
                        manager.Delete(choose);
                        break;
                    case 5:
                        manager.StudentByName();
                        break;
                    case 6:
                        manager.XuatFile();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-7!!!");
                }
//                break;
            } catch (Exception e) {
                System.err.println("Vui lòng nhập từ 1-7!!!");
                  s.nextLine();
            }
        }
    }
//    public void getAllStudent() {
//        lstStudent.removeAll(lstStudent);
//        try {
//            CallableStatement cs = conn.prepareCall("{CALL proc_getAllStudent}");
//            ResultSet rs = cs.executeQuery();
//            System.out.println("                              .....:Danh sách sinh viên:.....");
//            System.out.printf("%2s %6s %25s %10s %16s %13s %16s %20s\n",
//                    "Id", "Tên", "Giới tính","Tuổi","Toán","Lý","Hóa","Trung bình");
//            while (rs.next()) {
//                Student st = new Student(
//                        rs.getInt("id"),
//                        rs.getString("ten"), 
//                        rs.getBoolean("gioitinh"),
//                        rs.getInt("tuoi"),
//                        rs.getFloat("toan"),
//                        rs.getFloat("ly"),
//                        rs.getFloat("hoa"),
//                        rs.getFloat("trungbinh"));
//                lstStudent.add(st);
//                st.output();
//            }
//            if (lstStudent.size() == 0) {
//                System.err.println("KHÔNG TÌM THẤY DỮ LIỆU");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE,null, ex);
//        }
//    }
    public void getAllStudent() {
        lstStudent.removeAll(lstStudent);
        try {
        String sql = "{CALL proc_getAllStudent}";
        CallableStatement cs = conn.prepareCall(sql);
        ResultSet rs = cs.executeQuery();
        System.out.println("                              .....:Danh sách sinh viên:.....");
            System.out.printf("%2s %6s %25s %10s %16s %13s %16s %20s\n",
                    "Id", "Tên", "Giới tính","Tuổi","Toán","Lý","Hóa","Trung bình");
        while (rs.next()) {
                Student st = new Student(
                        rs.getInt("id"),
                        rs.getString("ten"), 
                        rs.getBoolean("gioitinh"),
                        rs.getInt("tuoi"),
                        rs.getFloat("toan"),
                        rs.getFloat("ly"),
                        rs.getFloat("hoa"),
                        rs.getFloat("trungbinh"));
                lstStudent.add(st);
                st.output();
            }
        if (lstStudent.size() == 0) {
            System.out.println("KHÔNG TÌM THẤY DỮ LIỆU");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
     public void insert() {
        try {
            Student s = new Student();
            s.input();
            CallableStatement cs = conn.prepareCall("{CALL proc_addStudent(?,?,?,?,?,?,?)}");
            cs.setNString(1, s.getTen());
            cs.setBoolean(2, s.isGioitinh());
            cs.setInt(3, s.getTuoi());
            cs.setFloat(4, s.getToan());
            cs.setFloat(5, s.getLy());
            cs.setFloat(6, s.getHoa());
            cs.setFloat(7, s.getTrungbinh());
            
            int result = cs.executeUpdate();
            if(result > 0){
                System.err.println("Cập nhật hàng thành công!!!");
            }else {
                System.err.println("Lỗi, cập nhật không thành công!!!");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: "+ex.getMessage());
        }
    }
//    public void create() {
//        try {
//            Student s = new Student();
//            s.input();
//            CallableStatement cs = conn.prepareCall("{CALL proc_addStudent(?,?,?,?,?,?,?)}");
//            cs.setString(1, s.getTen());
//            cs.setBoolean(2, s.isGioitinh());
//            cs.setInt(3, s.getTuoi());
//            cs.setFloat(4, s.getToan());
//            cs.setFloat(5, s.getLy());
//            cs.setFloat(6, s.getHoa());
//            cs.setFloat(7, s.getTrungbinh());
//           
//            cs.executeUpdate();
//            
//            int result = cs.executeUpdate();
//           
//            if(result > 0){
//                System.err.println("Cập nhật hàng thành công!!!");
//            }else {
//                System.err.println("Lỗi, cập nhật không thành công!!!");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE,null, ex);
//        }
//    }
    public void Delete(int id){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_deleteStudent(?)}");
            Scanner s = new Scanner(System.in);
            System.out.printf("Nhập mã sinh viên cần xóa: ");
            cs.setInt(1, s.nextInt());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Xóa dữ liệu thành công!!!");
            }
            
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void XuatFile() {
        FileOutputStream fos = null;
        try {
            String filePath = "sinhvien.txt";
            fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ManagerStudent sm = new ManagerStudent();
            sm.getAllStudent();
            oos.writeObject(sm.lstStudent);
            oos.flush();
            oos.close();
            fos.close();
            System.err.println("Ghi dữ liệu thành công!!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE,null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void Update(Student st){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_UpdateStudent(?,?,?,?,?,?,?,?)}");
            Scanner s = new Scanner(System.in);
            // Dang ky tham so dau vao
            System.out.printf("Nhập mã sinh viên cần sửa: ");
            int code = s.nextInt();
            cs.setInt(1, code);
            cs.setNString(2, st.getTen());
            cs.setBoolean(3, st.isGioitinh());
            cs.setInt(4, st.getTuoi());
            cs.setFloat(5, st.getToan());
            cs.setFloat(6, st.getLy());
            cs.setFloat(7, st.getHoa());
            cs.setFloat(8, st.getTrungbinh());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.err.println("Cập nhật thành công!!!");
            }else {
                System.err.println("Lỗi, cập nhật không thành công!!!");
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    public void StudentByName() {
        lstStudent.removeAll(lstStudent);
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_SearchByName(?)}");
            System.out.printf("Nhập tên sinh viên cần tìm: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            System.out.println("                          .....:Danh sách sinh viên có tên " +name+ " tìm thấy:.....");
            System.out.printf("%2s %8s %20s %14s %25s\n",
                    "Id", "Name", "Price","Year","Description");
            while (rs.next()) {
                Student st = new Student(
                        rs.getInt("id"),
                        rs.getString("ten"), 
                        rs.getBoolean("gioitinh"),
                        rs.getInt("tuoi"),
                        rs.getFloat("toan"),
                        rs.getFloat("ly"),
                        rs.getFloat("hoa"),
                        rs.getFloat("trungbinh"));
                lstStudent.add(st);
                st.output();
            }
            if (lstStudent.size() == 0) {
                System.err.println("KHÔNG TÌM THẤY DỮ LIỆU");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerStudent.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
}
