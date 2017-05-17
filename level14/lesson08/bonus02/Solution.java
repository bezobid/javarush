package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(read.readLine());
        int b = Integer.parseInt(read.readLine());
        System.out.println(biggestCommon(a, b));
    }

    public static int biggestCommon(int a, int b) {

        int min;
        int max;
        int modulo;

        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        do {
            modulo = max % min;
            max = min;
            min = modulo;
        } while (modulo > 0);

        return max;
    }
}

