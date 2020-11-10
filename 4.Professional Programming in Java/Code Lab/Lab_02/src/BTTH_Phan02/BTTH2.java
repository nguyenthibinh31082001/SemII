/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;

/**
 *
 * @author ADMIN
 */
public class BTTH2 {
    public static < E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        //Bước 4: Gọi hàm printArray() và truyền dữ liệu.
        System.out.println("Mảng số nguyên intArray:");
        printArray(intArray); // pass an Integer array
        System.out.println("\nMảng doubleArray:");
        printArray(doubleArray); // pass a Double array
        System.out.println("\nMảng characterArray:");
        printArray(charArray); // pass a Character array
    }
}
