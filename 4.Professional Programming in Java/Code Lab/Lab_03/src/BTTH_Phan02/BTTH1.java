/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

import java.io.Console;

/**
 *
 * @author ADMIN
 */
public class BTTH1 {
    
    public static void main(String[] args) {
        Console console = System.console();
        
        if(console == null){
            System.err.println("Hệ thống của bạn không hỗ trợ thiết bị Console");
        }else{
            try {
                String username = console.readLine("Nhập Username: ");
                char[] password = console.readPassword("Nhập Password: ");

                System.out.println("Username" + username);
                System.out.println("Password" + new String(password));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
