package com.javarush.test.mytests;

import java.lang.*;
import java.lang.Exception;
import java.lang.Override;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by bezobid on 28.06.2016.
 */
public class Bingo {
    static final int number = new Random().nextInt(100);
    static CyclicBarrier barrier = new CyclicBarrier(3);
    static boolean isGameOver = false;

    public static void main(String[] args) {
        System.out.println("The number is " + number);
        System.out.println("The game starts now!");

        for (int i = 0; i < 3; i++){
            new Player().start();
        }
    }

    static class Player extends Thread{
        static int counter;

        public Player() {
            setName("Player " + ++counter);
        }

        @Override
        public void run() {

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            Random guess = new Random();

            while(!isGameOver){
                int x = guess.nextInt(100);
                System.out.println(getName() + " guessed " + x);
                if (x == number){
                    isGameOver = true;
                    System.out.println(getName() + " guessed right!");
                }

            }
        }
    }
}
