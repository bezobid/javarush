package com.javarush.test.mytests;

import java.lang.*;
import java.lang.Override;
import java.util.Date;

/**
 * Created by bezobid on 28.06.2016.
 */
public class Multithreading {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }

    static class MyThread extends Thread{

        static int counter = 0;

        public MyThread() {
            this.setName("Thread " + ++counter);
        }

        @Override
        public void run() {
            long start = new Date().getTime();
            count(1);
            long finish = new Date().getTime();
            System.out.println(getName() + " finished in " + (finish-start) +"ms");

        }

        void count(long number){
            System.out.println(this.getName() + ": " + number);

            for (int i = 0; i < 1_000_00; i++){
                Math.random();
            }

            if (number*2 < 0){
                return;
            }

             count(number * 2);
        }
    }
}
