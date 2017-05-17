package com.javarush.test.mytests;

import java.lang.*;
import java.lang.Exception;
import java.util.concurrent.Phaser;


/**
 * Created by bezobid on 05.06.2016.
 */
class PhaserTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        phaser.register();

        for (int x = 0; x < 5; x++){
            new PhaserThread(phaser, "Thread #" + (x+1)).start();
        }

        phaser.arriveAndDeregister();
        System.out.println(Thread.currentThread().getName() + " deregistered");
    }

    public static class PhaserThread extends Thread{
        Phaser phaser;
        String name;

        public PhaserThread(Phaser p, String n) {
            phaser = p;
            name = n;
            p.register();
            this.setName(n);
            System.out.println(n + " created");
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " run()");
            phaser.arriveAndAwaitAdvance();
            System.out.println(name + " after waiting");
        }
    }
}
