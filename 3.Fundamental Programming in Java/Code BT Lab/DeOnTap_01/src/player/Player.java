/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import person.IPerson;

/**
 *
 * @author Admin
 */
public class Player implements IPerson{
//    - private String playerId : Cố định 3 kí tự
//    - private String playerName : Không được rỗng
//    - private Boolean gender : Chỉ được nhập true/false
//    - private Date birthday : Không được sau ngày hiện tại
    private String playerId;
    private String playerName;
    private boolean gender;
    private Date birthday;

    public Player() {
    }

    public Player(String playerId, String playerName, boolean gender, Date birthday) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isGender() {
        return gender;
    }

    public String getGender(){
        return gender? "Nam":"Nữ";
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthdayString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã:");
        playerId = sc.nextLine();
        while(true){
            if(this.playerId.length() == 3){
                  break;
              }else{
                  System.err.println("\tMã phải đủ 3 ký tự!!!");  
                  System.out.printf("\tNhập lại mã: ");
                  playerId = sc.nextLine();
              }
        }
        System.out.printf("\tNhập tên:");
        playerName = sc.nextLine();
        while(true){
            if(this.playerName.length() > 0 ){
                  break;
              }else{
                  System.err.println("\tTên không được để trống!!!");  
                  System.out.printf("\tNhập lại tên: ");
                  playerName = sc.nextLine();
              }
        }
        while(true){
            try {
                System.out.printf("\tNhập giới tính: ");
                this.gender = sc.nextBoolean();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập(true/false)!!!");
                sc.nextLine();
            }
        }
        
        while(true){
            try {
                System.out.printf("\tNhập ngày sinh: ");
                String d = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 this.birthday = sdf.parse(d);
                 Date now = new Date(System.currentTimeMillis());
                 if(birthday.getYear() < now.getYear()){
                      break;
                 }
               
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng (dd/MM/yyyy)");
//                sc.nextLine();
            }
        }
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.playerId));
        builder.append("|");
        builder.append(String.format("%10s", this.playerName));
        builder.append("|\t");
        builder.append(String.format("%5s",this.getGender()));
        builder.append("|\t\t");
        builder.append(String.format("%10s", this.getBirthdayString()));
        
        System.out.print(builder.toString());
    }
    
    
}
