package com.javarush.test.level04.lesson13.task03;

import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int digits = 1;
        for (int lines = 10; lines > 0; lines--)
        {
            for (int a = digits; a > 0; a--)
            {
                System.out.print('8');
            }
            System.out.println("");
            digits++;
        }
    }
}