/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HonDaFactoryImpl_Bai3 implements IHonDaFactory_Bai3{
    List<HonDa_Bai3>hondas;
    
    public HonDaFactoryImpl_Bai3() {
        hondas = new ArrayList<HonDa_Bai3>();
        HonDa_Bai3 xe1 = new HonDa_Bai3("sh150","SH 150",123);
        HonDa_Bai3 xe2 = new HonDa_Bai3("shmod","SH Mode",234);
        HonDa_Bai3 xe3 = new HonDa_Bai3("lead125","Lead 125",456);
        HonDa_Bai3 xe4 = new HonDa_Bai3("vision","Vision 125",678);
        hondas.add(xe1);
        hondas.add(xe2);
        hondas.add(xe3);
    }
    @Override
    public void HonDaThongSo() {
//        IHonDaFactory_Bai3 honda = new HonDaFactoryImpl_Bai3();
//
//        for (HonDa_Bai3 nv : honda.getAllHonDa()) {
//            System.out.println("Xe: [Mã : " + nv.getMaXe()+ ", Dòng xe : "
//            + nv.getModel()+ ", Thông số : " + nv.getThongSoXe()+ " ]");
//        }
    }
    public static void main(String[] args) {
        IHonDaFactory_Bai3 honda = new HonDaFactoryImpl_Bai3();

        for (HonDa_Bai3 nv : honda.getAllHonDa()) {
            System.out.println("Xe: [Mã : " + nv.getMaXe()+ ", Dòng xe : "
            + nv.getModel()+ ", Thông số : " + nv.getThongSoXe()+ " ]");
        }
        
        IHonDaFactory_Bai3 x1 = honda.getHonDa("shmod");
        x1.HonDaThongSo();
    }

    @Override
    public List<HonDa_Bai3> getAllHonDa() {
        return hondas;
    }

    @Override
    public void getHonDa(String maXe) {
        
    }

    
}
class run{
    public IHonDaFactory_Bai3 getHonDa(String ThongSo) {
        if (ThongSo == null) {
            return null;
        }
        if (ThongSo.equalsIgnoreCase("shmod")) {
            return new HonDaFactoryImpl_Bai3();
        }
        return null;
    }
}