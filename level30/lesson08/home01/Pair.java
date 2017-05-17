package com.javarush.test.level30.lesson08.home01;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));
        x = x ^ y;
        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));


        y = x ^ y;
        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));


        x = x ^ y;
        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));


    }
}
