/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập x = ");
        double x = sc.nextDouble();
        
        double a = 2*(sin(2*x)) - 3*(cos(2*x)) + 5*(sin(x))*(cos(x)) - 2;
        System.out.println("a, 2sin2x-3cos2x+5sinxcosx-2 = "+a);
        
//        double b1 = ((Math.cos(x)) - 2*(Math.sin(x))*(Math.cos(x)))/(2*((Math.cos(x))*(Math.cos(x))) + (Math.sin(x)) - 1);
//        System.out.println("b1, (cosx-2sinxcosx)/2cosxcosx+sinx-1 = "+b1);
        double b = ((cos(x)) - 2*(sin(x))*(cos(x)))/(2*(pow(cos(x), 2)) + (sin(x)) - 1);
        System.out.println("b, (cosx-2sinxcosx)/2(cosx)^2+sinx-1 = "+b);
        
//        double c2 = ((Math.sin(x))*(Math.sin(x))) + (Math.sin(2*x)) - 2*((Math.cos(Math.PI))*(Math.cos(Math.PI))*(Math.cos(Math.PI)));
//        System.out.println("c2, sin^2x+sin2X-2cos^x = "+c2);
        double c = (pow((sin(x)), 2)) + (sin(2*x)) - 2*pow(cos(Math.PI), x);
        System.out.println("c, sin^2x+sin2X-2cos^x = "+c);
        
//        double d3 = 4*(Math.sin(x))*(Math.sin(x))*(Math.sin(x))+3*Math.sin(Math.PI)*Math.sin(Math.PI)*(Math.cos(x))-(Math.sin(x))-(Math.cos(x))*(Math.cos(x))*(Math.cos(x));
//        System.out.println("d3, 4sin^3x+3sin^2cosx-sinx-cos^3x = "+d3);
        double d = 4*pow((sin(x)), 3)+3*(pow(sin(Math.PI), 2))*(cos(x))-(sin(x))-pow((cos(x)), 3);
        System.out.println("d, 4sin^3x+3sin^2cosx-sinx-cos^3x = "+d);
    }
}