package com.javarush.test.level20.lesson10.bonus01;

import java.util.Date;

/**
 * Created by bezobid on 17.02.2016.
 */
public class tst {
    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().totalMemory();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long start = new Date().getTime();
        int[][] matrix = Solution.getMatrix(10, 11);
        for(int x = 0; x < Integer.MAX_VALUE; x++)
        {
            //Solution.isOK(x);
            //Solution.getLength(x);
            //Solution.getSum(x);
        }

        long end = new Date().getTime();

        System.out.println(end - start + " ms");
        System.out.println((memoryStart - memoryEnd) / 1024 + " kb");

        System.out.println((int)Math.pow(10, 9));
    }
}
