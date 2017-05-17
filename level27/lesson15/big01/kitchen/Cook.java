package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by bezobid on 01.06.2016.
 */
public class Cook extends Observable implements Observer{
    String name;
    boolean changed;
    List<Observer> observers = new ArrayList<>();


    @Override
    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer observer : observers){
            observer.update(this, arg);
        }
    }

    @Override
    protected synchronized void setChanged() {
        changed = true;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order +  ", cooking time "
                + ((Order)order).getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
    }
}
