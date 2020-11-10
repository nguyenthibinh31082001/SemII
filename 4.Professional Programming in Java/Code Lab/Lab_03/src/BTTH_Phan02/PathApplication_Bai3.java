/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
public class PathApplication_Bai3 {
    
    public static void main(String[] args) {
        Path pathObj = Paths.get("C:/Java/Hello.txt");
        System.out.printf("FileName is: %s%n", pathObj.getFileName());
        System.out.printf("Parent is: %s%n", pathObj.getParent());
        System.out.printf("Name count is: %d%n", pathObj.getNameCount());
        System.out.printf("Root directory is: %s%n", pathObj.getRoot());
        System.out.printf("Is Absolute: %s%n", pathObj.isAbsolute());
    }
}
