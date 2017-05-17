package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream source = new FileInputStream(read.readLine());
        int min = source.read();

        while (source.available() > 0)
        {
            int x = source.read();
            if (x < min)
                min = x;
        }
        System.out.println(min);
        read.close();
        source.close();
    }
}

