/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH2;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class MainClass {
    public void printInvoice(int amount, double priceOfProd, Date purchDate, Locale locale) {
        System.out.println("Thông tin hóa đơn: " + locale.getDisplayCountry());
        System.out.println("Số lượng sản phẩm: " +
        NumberFormat.getNumberInstance(locale).format(amount));
        System.out.println("Tổng tiền: " +
        NumberFormat.getCurrencyInstance(locale).format(amount * priceOfProd));
        System.out.println("Ngày thanh toán: " +
        DateFormat.getDateInstance(DateFormat.FULL, locale).format(purchDate));
        System.out.println("--------------------------------------------------\n\n");
    }
    public static void main(String[] args) {
        MainClass main = new MainClass();
        main.printInvoice(1200, 35.5, Calendar.getInstance().getTime(),
        Locale.FRANCE);
        main.printInvoice(1200, 35.5, Calendar.getInstance().getTime(),
        Locale.GERMANY);
        main.printInvoice(1200, 35.5, Calendar.getInstance().getTime(), Locale.JAPAN);
        main.printInvoice(1200, 35.5, Calendar.getInstance().getTime(),
        Locale.KOREA);
        main.printInvoice(1200, 35.5, Calendar.getInstance().getTime(), Locale.ITALY);
    }
}
