/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_03;

/**
 *
 * @author Admin
 */
public class Demo_Student {
    public static void main(String[] args) {
        Bai2_Student st = new Bai2_Student(); 
        st.studentInput(); 
        st.studentInfo(); 
        
        Demo_Student demo = new Demo_Student();
        System.out.println(demo.printRank(st.gettMark(), st.getpMark()));
    }
      
     private String printRank(float theory, float pracical) {
        if (theory < 40 && pracical < 40) {
            return "Thi lại môn Java";
        } else if (theory < 40 && pracical >= 40) {
            return "Thi lại lý thuyết môn Java";
        } else if (theory >= 40 && pracical < 40) {
            return "Thi lại thực hành môn Java";
        } else {
            return "Pass môn Java";
        }
    }   
}
