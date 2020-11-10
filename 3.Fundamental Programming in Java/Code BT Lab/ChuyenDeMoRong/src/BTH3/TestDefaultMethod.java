/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH3;

/**
 *
 * @author Admin
 */
public class TestDefaultMethod {
    public static void main(String[] args) {
        // Gọi class OldClass
        OldClassImpl oci = new OldClassImpl();
        oci.oldMethod();
        oci.newMethod1(); // Override phương thức ở interface (nếu cần)
        oci.newMethod2(); // Có thể sử dụng trực tiếp phương thức mới dc thêm
    }
}
