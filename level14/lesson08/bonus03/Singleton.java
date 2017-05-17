package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by bezobid on 11.12.2015.
 */
public class Singleton {

    private static Singleton instance = null;
    protected Singleton(){}

    public static Singleton getInstance()
    {
        if (instance == null)
        instance = new Singleton();
        return instance;
    }
}
