/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class ListDirApplication_Bai4 {
    
    public static void main(String[] args) {
        Path pathObj = Paths.get("test");
        
        try (DirectoryStream<Path> dirStreamObj = Files.newDirectoryStream(pathObj)){
            for (Iterator<Path> itrObj = dirStreamObj.iterator(); itrObj.hasNext();) {
                Path fileObj = itrObj.next();
                System.out.println(fileObj.getFileName());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
