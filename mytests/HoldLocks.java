package com.javarush.test.mytests;

import java.lang.*;

/**
 * Created by bezobid on 20.06.2016.
 */
public class HoldLocks {
    public static void main(String[] args) throws InterruptedException {
        final String s = "lock";
        new Thread(){
            public void run() {
                synchronized (s) {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(System.currentTimeMillis());
                        System.out.println(Thread.holdsLock(s));


                    }
                }
            }
        }.start();

        Thread.sleep(2000);

    }
}
