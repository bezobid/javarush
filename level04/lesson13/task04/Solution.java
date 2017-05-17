package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        for(int a = 20; a > 0; a--){
            if (a > 11)
            System.out.print('8');
            else
            System.out.println('8');
        }
    }
}
