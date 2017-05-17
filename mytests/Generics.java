package com.javarush.test.mytests;

/**
 * Created by bezobid on 07.08.2016.
 */
public class Generics {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        test(1);
    }

    public static <T> void test(T t) throws IllegalAccessException, InstantiationException {
        System.out.println(t.getClass().getSimpleName());
    }
}
