package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()); // вводим N
        int maximum = Integer.parseInt(reader.readLine()); // maximum равен первому из введенных чисел
        for (int x = n - 1; x > 0; x--)
        {
            int in = Integer.parseInt(reader.readLine());
            if (in > maximum) maximum = in;
        }
        System.out.println(maximum);
    }
}
