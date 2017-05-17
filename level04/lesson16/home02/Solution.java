package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        int min;
        if ((a > b && c > a) || (a < b && c > a)) // cab or bac
        System.out.println(a);
        if ((a > b && b > c) || (c > b && b > a)) // abc or cba
        System.out.println(b);
        if ((a > c && c > b) || (b > c && c > a)) // acb or bca
        System.out.println(c);

    }
}
