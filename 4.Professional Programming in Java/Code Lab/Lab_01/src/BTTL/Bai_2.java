    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Bai_2 {

    String rollNo;
    String fullname;
    String deskphone;
    String cellphone;
    String email;
    String yearOfBirth;
    
    String regExpRollNo = "^C[0-9]{7}$";
    String regExpFullname = "^[a-zA-Z0-9 ]{1,64}$";
    String regExpDeskphone = "[0-9]{3}.[0-9]{6,7}$";
    String regExpCellphone = "[0-9]{10,11}$";
    private static final String regExpEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    String regExpYearOfBirth = "^19([7-8][0-9])|(9[0-6])$";

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDeskphone() {
        return deskphone;
    }

    public void setDeskphone(String deskphone) {
        this.deskphone = deskphone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    
    
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\tNhập rollNo:");
            this.rollNo = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpRollNo);
            Matcher matcher = pattern.matcher(rollNo);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tRollNo phải gồm 8 ký tự và bắt đầu bằng chữ C!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập fullname:");
            this.fullname = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpFullname);
            Matcher matcher = pattern.matcher(fullname);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tFullname chỉ tối đa 64 ký tự!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập deskphone:");
            this.deskphone = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpDeskphone);
            Matcher matcher = pattern.matcher(deskphone);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tDeskphone phải là định dạng mã vùng 3 ký tự + dấu . + tối thiểu 6 và tối đa 7 số!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập cellphone:");
            this.cellphone = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpCellphone);
            Matcher matcher = pattern.matcher(cellphone);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tCellphone phải định dạng gồm toàn số, tối thiểu 10 số và tối đa 11 số!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập email:");
            this.email = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpEmail);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tEmail sai định dạng!");
            }
        } while (true);
        do {
            System.out.printf("\tNhập yearOfBirth:");
            this.yearOfBirth = sc.nextLine();
            Pattern pattern = Pattern.compile(regExpYearOfBirth);
            Matcher matcher = pattern.matcher(yearOfBirth);
            if (matcher.matches()) {
                break;
            } else {
                System.err.println("\tYearOfBirth phải tối thiểu là 1970 và tối đa là 1996!");
            }
        } while (true);
    }

//    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2s",this.rollNo));
        builder.append("|\t");
        builder.append(String.format("%10s", this.fullname));
        builder.append("|\t");
        builder.append(String.format("%10s",this.deskphone));
        builder.append("|\t");
        builder.append(String.format("%10s", this.cellphone));
        builder.append("|\t");
        builder.append(String.format("%10s", this.email));
        builder.append("|\t");
        builder.append(String.format("%10s", this.yearOfBirth));
        builder.append("|\t");
        
        System.out.print(builder.toString());
    }
//    @Override
//    public String toString() {
//        return "Bai_2{" + "RollNo=" + RollNo + ", Fullname=" + Fullname + ", Deskphone=" + Deskphone + ", Cellphone=" + Cellphone + ", YearOfBirth=" + YearOfBirth + '}';
//    }
}
