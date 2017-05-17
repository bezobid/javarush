package com.javarush.test.level38.lesson06.home01;

/**
 * Created by bezobid on 12.09.2016.
 */
public class ExceptionFactory {
    public static Throwable getException(Enum e){

        if (e != null) {
            String name = e.name();
            String letter1 = name.substring(0, 1);
            String rest = name.substring(1).replaceAll("_", " ").toLowerCase();
            name = letter1 + rest;

            if (e instanceof ExceptionApplicationMessage) return new Exception(name);
            else if (e instanceof ExceptionDBMessage) return new RuntimeException(name);
            else if (e instanceof ExceptionUserMessage) return new Error(name);
        }

        return new IllegalArgumentException();
    }
}
