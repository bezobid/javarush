package com.javarush.test.level25.lesson07.home01;

/**
 * Created by bezobid on 19.04.2016.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread("A thread"){
            {
                System.out.println("new thread created");
            }
        };
        Thread.sleep(1000);
        System.out.println(a.getState().toString());

        Thread.sleep(1000);
        a.start();
        //a.interrupt();
        //System.out.println("interrupted");

        System.out.println(a.getState().toString());

        Thread.sleep(1000);
        System.out.println(a.isInterrupted());
        System.out.println(a.getState().toString());
    }
}
