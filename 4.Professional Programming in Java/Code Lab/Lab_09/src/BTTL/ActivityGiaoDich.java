/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ActivityGiaoDich {
    ETranslator eTran;
    
    private int showMenu() {
        System.out.println("\t.: " + eTran.getText(ELanguage.menu) + " :.");
        System.out.println("1. " + eTran.getText(ELanguage.importc));
        System.out.println("2. " + eTran.getText(ELanguage.display));
        System.out.println("3. " + eTran.getText(ELanguage.update));
        System.out.println("4. " + eTran.getText(ELanguage.delete));
        System.out.println("5. " + eTran.getText(ELanguage.search));
        System.out.println("6. " + eTran.getText(ELanguage.transactiondate));
        System.out.println("7. " + eTran.getText(ELanguage.change));
        System.out.println("8. " + eTran.getText(ELanguage.exit));
        System.out.println(eTran.getText(ELanguage.plzchoose));
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    private void nhap() {
        GiaoDich gd = new GiaoDich();
        gd.input();
        ManagerGiaoDich giaoDich = new ManagerGiaoDich(eTran);
        giaoDich.Created(gd);
    }
    private void hienthi() {
        ManagerGiaoDich giaoDich = new ManagerGiaoDich(eTran);
        giaoDich.getAll().forEach(o -> o.output());
    }
    private void capNhat() {
        GiaoDich gd = new GiaoDich();
        gd.input();
        ManagerGiaoDich giaoDich = new ManagerGiaoDich(eTran);
        giaoDich.Update(gd);
    }
    private void xoa() {
        ManagerGiaoDich giaoDich = new ManagerGiaoDich(eTran);
        giaoDich.Delete(0);
    }
     private void timkiem() {
        ManagerGiaoDich giaoDich = new ManagerGiaoDich(eTran);
        giaoDich.searchByName();
     }
    private void doiNgonNgu() {
        System.out.println(eTran.getText(ELanguage.clanguage) + ":");
        System.out.println("1. English");
        System.out.println("2. Japanese");
        System.out.println("3. Tiếng Việt");
        Scanner s = new Scanner(System.in);
        System.out.printf("Mời chọn ngôn ngữ 1-3: ");
        int c = s.nextInt();
        switch (c) {
            case 1:
                eTran.setLocale(ELanguage.US);
                break;
            case 2:
                eTran.setLocale(ELanguage.JAPAN);
                break;
            case 3:
                eTran.setLocale(ELanguage.VIET_NAM);
                break;
        }
    }
    public static void main(String[] args) {
        ActivityGiaoDich main = new ActivityGiaoDich();
        main.eTran = new ETranslator();
        main.eTran.setLocale(ELanguage.US);
        
        Scanner s = new Scanner(System.in);
        int luaChon = 0;
        while (true) {
//            System.out.println("\t.: Mục lục :.");
//            System.out.println("1. Nhập giao dịch");
//            System.out.println("2. Danh sách giao dịch");
//            System.out.println("3. Sửa giao dịch");
//            System.out.println("4. Xóa giao dịch");
//            System.out.println("5. Tìm kiếm giao dịch ");
//            System.out.println("6. Giao dịch trong ngày ");
//            System.out.println("7. Đổi ngôn ngữ ");
//            System.out.println("8. Thoát");
            luaChon = main.showMenu();

            try {
//                System.out.printf("Mời chọn từ 1 -> 8: ");
//                int choose = s.nextInt();
                
                switch (luaChon) {
                    case 1:
                        main.nhap();
                        break;
                    case 2:
                        main.hienthi();
                        break;
                    case 3:
                        main.capNhat();
                        break;
                    case 4:
                        main.xoa();
                        break;
                    case 5:
                        main.timkiem();
                        break;
                    case 6:
                        
                        break;
                    case 7:
                        main.doiNgonNgu();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-8!!!");
                }
            } catch (Exception e) {
                System.err.println("Vui lòng nhập từ 1-8!!!");
                s.nextLine();
            }
            
        }
    }
}
