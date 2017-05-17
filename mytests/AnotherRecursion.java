package com.javarush.test.mytests;

/**
 * Created by bezobid on 05.06.2016.
 */
public class AnotherRecursion {
    static long limit = 1000;
    public static void main(String[] args) {
        System.out.println(getSum(1, 0, limit));
    }

    static public long getSum(long x, long sum, long limit){
        if (x > limit){
            return sum;
        }
        return getSum(x + 1, sum + x, limit);
    }
}

