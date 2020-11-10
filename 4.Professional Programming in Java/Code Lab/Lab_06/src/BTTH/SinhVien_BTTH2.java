/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SinhVien_BTTH2 {
    private int id;
    private String rollNumber;
    private String name;
    private String address;
    private String phoneNumber;
    private boolean gender;

    public SinhVien_BTTH2() {
    }

    public SinhVien_BTTH2(int id, String rollNumber, String name, String address, String phoneNumber, boolean gender) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SinhVien_BTTH2{" + "id=" + id + ", rollNumber=" + rollNumber + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", gender=" + gender + '}';
    }
    
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=lab_06","sa","123456789");
            if(con!=null)
            System.out.println("Kết nối tới CSDL thành công!");
            else
            System.out.println("Không kết nối vào CSDL được");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BTTH1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(BTTH1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = con.prepareStatement("select * from tblsinhvien");
            rs = pstmt.executeQuery();
            while (rs.next()) {
            System.out.println("Sinh vien:");
            System.out.println("\tId:" + rs.getInt(1));
            System.out.println("\tRollnumber:" + rs.getString(2));
            System.out.println("\tName:" + rs.getString(3));
            System.out.println("\tAddress:" + rs.getString(4));
            System.out.println("\tPhone no:" + rs.getString(5));
            System.out.println("\tGender:" + (rs.getBoolean(6) ? "Male" : "Female"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien_BTTH2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            pstmt = con.prepareStatement("update tblsinhvien set name=?, address=?,phone=? where id=?");
            pstmt.setString(1, "Lưu Bị");
            pstmt.setString(2, "Thục quốc");
            pstmt.setString(3, "0123989898");
            pstmt.setInt(5, 3);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("Da cap nhat du lieu cho ban ghi co id =3");
            } else {
                System.out.println("Khong cap nhat duoc du lieu");
            }
            
        } catch (Exception e) {
        }
        
        try {
            pstmt = con.prepareStatement("insert into tblsinhvien values (?,?,?,?,?)");
            pstmt.setString(1, "C1505004");
            pstmt.setString(2, "Tào Tháo");
            pstmt.setString(3, "Ngụy quốc");
            pstmt.setString(4, "19001080");
            pstmt.setBoolean(5, true);
            int i = pstmt.executeUpdate();
            if (i > 0) {
            System.out.println("Da them du lieu vao bang");
            } else {
            System.out.println("Khong them duoc du lieu vao bang");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien_BTTH2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            pstmt = con.prepareStatement("delete from tblsinhvien where id=3");
            int i = pstmt.executeUpdate();
            if (i > 0) {
            System.out.println("Da xoa du lieu cua ban ghi co id=3");
            } else {
            System.out.println("Khong xoa duoc du lieu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien_BTTH2.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
                pstmt.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVien_BTTH2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
