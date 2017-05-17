package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        int counter = 1;
        try{

            while(true) {
                System.out.println("Some text for " + counter);
                counter++;
                Thread.sleep(500);
            }
        }
        catch (Exception e){
            System.out.printf("[%s] thread was terminated", Thread.currentThread().getName());
        }
    }
}