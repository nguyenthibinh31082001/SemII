/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO {

    Connection conn;
    public CategoryDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Category> getAll(){
        List<Category> lst = new ArrayList<>();
        
        CallableStatement st;
        try {
            st = this.conn.prepareCall("{call proc_category_getall()}");
            ResultSet rs = st.executeQuery();
            Category cat;
            while(rs.next()){
                cat = new Category();
                cat.setCateId(rs.getInt("CateId"));
                cat.setCateName(rs.getNString("CateName"));
                cat.setImgUrl(rs.getNString("ImgUrl"));
                cat.setParentId(rs.getInt("ParentId"));
                cat.setStatus(rs.getBoolean("Status"));
                lst.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst;
    }
    
    public Category getById(int id){
        Category cat = null;
        try {
            CallableStatement st = this.conn.prepareCall("{call proc_category_getbyid(?)}");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                cat = new Category();
                cat.setCateId(rs.getInt("CateId"));
                cat.setCateName(rs.getNString("CateName"));
                cat.setImgUrl(rs.getNString("ImgUrl"));
                cat.setParentId(rs.getInt("ParentId"));
                cat.setStatus(rs.getBoolean("Status"));
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return cat;
    }
    
    public void create(Category cat){
        try {
            CallableStatement st = this.conn.prepareCall("{call proc_category_insert(?,?,?,?,?,?)}");
            st.setInt(1, cat.getCateId());
            st.setNString(2, cat.getCateName());
            st.setInt(3, cat.getParentId());
            st.setNString(4, cat.getImgUrl());
            st.setBoolean(5, cat.isStatus());
            
            // Dang ky tham so dau ra
            st.registerOutParameter("Error", Types.NVARCHAR);
            
            st.executeUpdate();
            
            String err = st.getNString("Error");
            if(err != ""){
                System.out.println(err);
            }else{
                System.out.println("Them thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
