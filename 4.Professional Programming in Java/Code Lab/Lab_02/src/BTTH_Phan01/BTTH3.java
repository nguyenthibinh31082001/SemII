/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan01;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class BTTH3 {
    public static void main(String[] args) {
        Map<String, String> studentBKAP = new HashMap<>();
        studentBKAP.put("K1230", "Tuan");
        studentBKAP.put("K1231", "Nam");
        studentBKAP.put("K1232", "Thao");
        studentBKAP.put("K1233", "Binh");
        studentBKAP.put("K1234", "Hoang");
        
        for (Map.Entry<String, String> entrySet : studentBKAP.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            System.out.println(key + " - " + value);
        }
        System.out.println("Sinh viên có mã bằng K1231 là: " + studentBKAP.get("K1231"));
        
        studentBKAP.remove("K1233");//xóa sinh viên có mã là K1233
        System.out.println("Sau khi xóa: " + studentBKAP);
    }
}
