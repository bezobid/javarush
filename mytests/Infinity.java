package com.javarush.test.mytests;

/**
 * Created by bezobid on 20.06.2016.
 */
public class Infinity {
    public static void main(String[] args) {
        double result = 1.0 / 0.0;
        System.out.println(result == Double.POSITIVE_INFINITY);
    }
}
