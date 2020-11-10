/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

/**
 *
 * @author ADMIN
 */
public class ChaoHoi_BTTH4 {
    public static Object ThayDo = new Object();
    public static Object XaTruong = new Object();

    private static class ThayDoChao extends Thread{
        public void run() {
            synchronized (ThayDo) {
                System.out.println("Thầy đồ: Cúi người chào...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    
                }
                System.out.println("Thầy đồ: đợi xã trưởng chào lại...");
                synchronized (XaTruong) { // Deadlock
                System.out.println("Thầy đồ: kết thúc chào hỏi...");
                }
            }
        }
    }
    private static class XaTruongChao extends Thread {
        public void run() {
            synchronized (XaTruong) {
                System.out.println("Xã trưởng: Cúi người chào...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Xã trưởng: đợi thầy đồ chào lại...");
                synchronized (ThayDo) {
                    System.out.println("Xã trưởng: kết thúc chào hỏi...");
                }
            }
        }
    }
    public static void main(String[] args) {
        ThayDoChao thayDo = new ThayDoChao();
        XaTruongChao xaTruong = new XaTruongChao();
        thayDo.start();
        xaTruong.start();
    }
}
