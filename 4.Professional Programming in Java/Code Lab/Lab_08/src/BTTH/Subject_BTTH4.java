/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Subject_BTTH4 {
    private List<Observer>observers = new ArrayList<Observer>();
    
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    
    public void notifyAllObservers() {
        for (Observer observer : observers) {
        observer.update();
    }
}

    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public static void main(String[] args) {
        Subject_BTTH4 subject = new Subject_BTTH4();
        
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
    
}
abstract class Observer {

    protected Subject_BTTH4 subject;

    public abstract void update();
}
class BinaryObserver extends Observer {

    public BinaryObserver(Subject_BTTH4 subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    
    @Override
    public void update() {
        System.out.println("Binary String: " +
        Integer.toBinaryString(subject.getState()));
    }
}
class OctalObserver extends Observer {

    public OctalObserver(Subject_BTTH4 subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
class HexaObserver extends Observer {
    public HexaObserver(Subject_BTTH4 subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
