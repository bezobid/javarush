package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by bezobid on 27.02.2016.
 */
public class Hippodrome {

    public static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse h1 = new Horse("horse1", 3, 0);
        Horse h2 = new Horse("horse2", 3, 0);
        Horse h3 = new Horse("horse3", 3, 0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();
    }

    ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try{
            Thread.sleep(200);}
            catch (InterruptedException e){}
        }
    }

     public void move()
    {
        for (Horse horse : horses) {
            horse.move();
        }

    }

     public void print()
    {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        double dis=0;
        Horse winner = null;
        for (Horse horse : horses){
            if (horse.getDistance()>dis) {
                dis=horse.getDistance();
                winner=horse;
            }
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
