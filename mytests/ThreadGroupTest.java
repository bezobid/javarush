package com.javarush.test.mytests;

import java.lang.*;
import java.lang.Exception;
import java.lang.Override;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by bezobid on 05.06.2016.
 */
public class ThreadGroupTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("My group");

        for (int x = 0; x < 10; x++){
            final int id = x;

            new Thread(group, new Runnable() {
                @Override
                public void run() {
                    try {
                        if(id % 2 == 0) {
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //ThreadLocalRandom.current().nextLong(100000);
                }
            }, "thread #" + (x + 1)).start();
        }

        group.list();
        System.out.println(Thread.currentThread().getThreadGroup());
    }

}
