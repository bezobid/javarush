package com.javarush.test.mytests;

import java.lang.reflect.Method;

/**
 * Created by bezobid on 14.04.2016.
 */
class Private {
    private int x = 1;
    int y = 2;

    public void print1() {
        System.out.println("Parent class public method");
    }

    private void print2() {
        System.out.println("Parent class private method");
    }

    public int getX() {
        return this.x;
    }

}

class Child extends Private {
    private int x = 10;

    public int getX() {
        return x;
    }

}

class Test {
    public static void main(String[] args) {
        Child child = new Child();

        System.out.println(child.y);
        System.out.println(child.getX());
        child.print1();
        Method[] methods = child.getClass().getMethods();
        for (Method m : methods) {
            System.out.println(m.toString());
        }
    }
}
