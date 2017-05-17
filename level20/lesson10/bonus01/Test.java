package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/**
 * Created by bezobid on 16.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        getNumbers(654321);

    }

    public static void getNumbers(int N) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int x = 0; x < N; x++) {
            int M = getLength(x);
            int[] digits = new int[M];
            int xCopy = x;

            boolean ok = true;

            for (int i = 0; i < M; i++) {
                int digit = xCopy % 10;

                if (i == 0 || digit <= digits[i - 1]) {
                    digits[i] = digit;
                    xCopy /= 10;
                } else {
                    ok = false;
                    break;
                }
            }


            if (ok) {
                System.out.println(x);
/*
                int S = 0;
                for (Integer i : digits) {
                    S += Math.pow(i, M);
                }

                if (S == x) {
                    numbers.add(S);
                    System.out.println(S);
                }

*/
            }
        }
    }



    static int getLength(int n)
    {
        return String.valueOf(n).length();
    }
}
