package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String d = reader.readLine();
        String e = reader.readLine();
        String f = reader.readLine();

        int a = Integer.parseInt(d);
        int b = Integer.parseInt(e);
        int c = Integer.parseInt(f);

        if (a > b && a > c && b > c)
            System.out.println(a + " " + b + " " + c);

        if (a > b && a > c && b < c)
            System.out.println(a + " " + c + " " + b);

        if (a > b && a < c && b < c)
            System.out.println(c + " " + a + " " + b);

        if (a < b && a < c && b < c)
            System.out.println(c + " " + b + " " + a);

        if (a < b && a > c && b > c)
            System.out.println(b + " " + a + " " + c);

        if (a < b && a < c && b > c)
            System.out.println(b + " " + c + " " + a);

    }
}
