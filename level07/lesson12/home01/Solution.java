package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[10];
        int[] rev = new int[10];

        for (int i = 0; i < 10; i++) {
            list[i] = Integer.parseInt(reader.readLine());
            rev[rev.length - i - 1] = list[i];
        }

        for (int i = 0; i < 10; i++)
            System.out.println(rev[i]);

    }
}
