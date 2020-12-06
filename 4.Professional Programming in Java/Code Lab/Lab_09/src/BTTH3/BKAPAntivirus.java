/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH3;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ADMIN
 */
public class BKAPAntivirus {
    public static void main(String[] args) {
        BKAPAntivirus bkap = new BKAPAntivirus();
        bkap.printMessage(new Locale("vi", "VN"), 69, "Phim XXX");
        bkap.printMessage(new Locale("en", "US"), 69, "Phim XXX");
        bkap.printMessage(new Locale("ja", "JP"), 69, "Phim XXX");
    }

    public void printMessage(Locale locale, int numOfVirus, String diskName) {
        ResourceBundle bundle =
        ResourceBundle.getBundle("BTTH3/whatyourname", locale);
        String message = MessageFormat.format(bundle.getString("detect"),
        numOfVirus, diskName);
        System.out.println(message);
    }
}
