/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vietnam;

import java.util.Scanner;
import lab_05.Bai1_Lab5;
/**
 *
 * @author ADMIN
 */
public class VietNamImportPrice extends Bai1_Lab5{
    private float taxImported;
    public float imported_price;

    public VietNamImportPrice(float taxImported, String prodId, String prodName, String manufacturer, float producerPrice) {
        super(prodId, prodName, manufacturer, producerPrice);
        this.taxImported = taxImported;
    }

    public float getTaxImported() {
        return taxImported;
    }

    public void setTaxImported(float taxImported) {
        this.taxImported = taxImported;
    }

    public float getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
//        System.out.printf("Nhập giá nhập khẩu:");
//        prodId = sc.nextLine();
        System.out.printf("Nhập thuế nhập khẩu:");
        taxImported = sc.nextFloat();
    }
    public void caculateSalePrice(){
        sale_price=(float)(imported_price+taxImported*imported_price+0.01*(imported_price+taxImported*imported_price))+taxImported;
    }
    
//    (Giá bán bằng giá nhập khẩu (giá này bằng giá mà sale_price = imported_price +
//taxImported*imported_price + 10% * (imported_price + taxImported*imported_price)
//nhà sản xuất đưa ra) cộng với thuế nhập khẩu + 5 phần trăm giá nhập và thuế cộng
//gộp (đây sẽ là tiền lãi cho công ty nhập hàng hóa về Việt Nam)).
}
