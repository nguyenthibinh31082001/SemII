/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CategoryDAO categoryDAO = new CategoryDAO(DbUtil.getConnection());
//        List<Category> lst = categoryDAO.getAll();
//        lst.forEach(o -> System.out.println(o));

//          Category cat = categoryDAO.getById(3);
//          System.out.println(cat);
        
          
          categoryDAO.create(new Category(13, "TEST", 0, "http", true));
    }
    
}
