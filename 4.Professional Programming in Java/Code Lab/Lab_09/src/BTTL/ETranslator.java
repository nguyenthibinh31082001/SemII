/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class ETranslator {
    private final String proPath = "BTTL/giaodich";
    private Locale locale;
    public void setLocale(Enum lang) {
        if (lang == ELanguage.US) {
            locale = Locale.US;
            // System.out.println("English");
        } else if (lang == ELanguage.JAPAN) {
            locale = Locale.JAPAN;
            // System.out.println("Japan");
        } else if (lang == ELanguage.VIET_NAM) {
            locale = new Locale("vi", "VN");
            // System.out.println("Vietnam");
        }
    }
    public String getText(Enum text) {
        ResourceBundle rb = ResourceBundle.getBundle(proPath, locale);
        // System.out.println("MINHVT: " + text.name());
        return rb.getString(text.name());
    }
    public String getNumber(double num) {
        NumberFormat format = NumberFormat.getNumberInstance(locale);
        return format.format(num);
    }
    public String getCurrency(double num) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(num);
    }
    public String getDateformat(String date) {
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d = sdf.parse(date);
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
        DateFormat.MEDIUM, locale);
        return df.format(d);
        } catch (ParseException ex) {
        Logger.getLogger(ETranslator.class.getName()).log(Level.SEVERE, null,
        ex);
        }
    return "----";
    }
}
