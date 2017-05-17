package com.javarush.test.mytests;

/**
 * Created by bezobid on 24.12.2015.
 */
public class Sync {
    static double d = Math.random();
    double i = Math.random();
    private static double p = Math.random();
    static double pa = Math.random();



    public static void main(String[] args) {
        System.out.println(d);
        System.out.println(d);
        Sync sync = new Sync();
        System.out.println(sync.i);
    }

}


