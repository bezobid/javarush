package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String line1 = read.readLine();
        String line2 = read.readLine();
        int m = Integer.parseInt(line1);
        int n = Integer.parseInt(line2);

        for (int b = m; b > 0; b--)
        {
            for (int a = n; a > 0; a--)
            {
                System.out.print('8');
            }
            System.out.println("");
        }
    }
}
