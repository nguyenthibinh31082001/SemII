/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

/**
 *
 * @author Admin
 */
public interface IEmployee {
    public void input();
    public void display();
    public double calculateBonus();
    public double calculateSalary();
    public static final double basicSalay = 1600000;
}
