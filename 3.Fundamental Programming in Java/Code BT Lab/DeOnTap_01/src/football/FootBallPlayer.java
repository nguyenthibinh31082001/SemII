/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package football;

import java.util.Date;
import java.util.Scanner;
import player.Player;
import salary.ISalary;

/**
 *
 * @author Admin
 */
public class FootBallPlayer extends Player implements ISalary{

    private String footballClub;
    private String playPosition;
    private double transferCost;
    private double salaryPerWeek;

    public FootBallPlayer() {
    }

    public FootBallPlayer(String footballClub, String playPosition, double transferCost, double salaryPerWeek, String playerId, String playerName, boolean gender, Date birthday) {
        super(playerId, playerName, gender, birthday);
        this.footballClub = footballClub;
        this.playPosition = playPosition;
        this.transferCost = transferCost;
        this.salaryPerWeek = salaryPerWeek;
    }

    public String getFootballClub() {
        return footballClub;
    }

    public void setFootballClub(String footballClub) {
        this.footballClub = footballClub;
    }

    public String getPlayPosition() {
        return playPosition;
    }

    public void setPlayPosition(String playPosition) {
        this.playPosition = playPosition;
    }

    public double getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(double transferCost) {
        this.transferCost = transferCost;
    }

    public double getSalaryPerWeek() {
        return salaryPerWeek;
    }

    public void setSalaryPerWeek(double salaryPerWeek) {
        this.salaryPerWeek = salaryPerWeek;
    }
    
    @Override
    public void display() {
        super.display();
        StringBuilder builder = new StringBuilder();
        builder.append("|\t");
        builder.append(String.format("%10s", this.footballClub));        
        builder.append("|");
        builder.append(String.format("%10s", this.playPosition));
        builder.append("|\t\t");
        builder.append(String.format("%10s", this.transferCost));
        builder.append("|\t\t");
        builder.append(String.format("%10s", this.salaryPerWeek));
        builder.append("|\t\t");
        builder.append(String.format("%10s", this.salaryForMonth()));
        builder.append("|\t\t");
        builder.append(String.format("%10s", this.salaryForYear()));
        builder.append("|");
        
        System.out.println(builder.toString());
    }

    @Override
    public void input() {
        super.input(); 
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập câu lạc bộ: ");
        this.footballClub = sc.nextLine();
        while (true) {            
            if(this.footballClub.length() > 0){
                break;
            }else{
                System.err.println("\tTên câu lạc bộ không được để trống!!!");
                System.out.printf("\tNhập lại câu lạc bộ: ");
                footballClub = sc.nextLine();
            }
        }
        System.out.printf("\tVị trí: ");
        this.playPosition = sc.nextLine();
        while (true) {            
            if(this.playPosition.length() > 0){
                break;
            }else{
                System.err.println("\tVị trí không được để trống!!!");
                System.out.printf("\tNhập lại vị trí: ");
                playPosition = sc.nextLine();
            }
        }
        
        while (true) {            
            try {
                System.out.printf("\tPhí chuyển nhượng: ");
                this.transferCost = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.err.println("\tPhí vẫn chuyển phải nhập số!!!");
                sc.nextLine();
            }
        }
        
        while (true) {            
            try {
                System.out.printf("\tLương theo tuần: ");
                this.salaryPerWeek = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tLương theo tuần phải nhập số!!!");
                sc.nextLine();
            }
        }
    }
    
    @Override
    public double salaryForMonth() {
        return this.salaryPerWeek * 4;
    }

    @Override
    public double salaryForYear() {
        return this.salaryForMonth() * 12;
    }
    
}
