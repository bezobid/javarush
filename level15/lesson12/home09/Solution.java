package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String URL = read.readLine();
        String URLcut = URL.substring(URL.indexOf('?')+1);
        String[] parts = URLcut.split("&");
        List<String> obj = new ArrayList<>();

        for (String x : parts)
        {
            if (x.startsWith("obj="))
            {
                obj.add(x.substring(x.indexOf('=')+1));
            }
        }

        for (int a = 0; a < parts.length; a++)
        {
            if (parts[a].contains("="))
            parts[a] = parts[a].substring(0, parts[a].indexOf('='));
        }

        for (String x : parts)
        {
            if (!x.equals(parts[0]))
                System.out.print(" ");
            System.out.print(x);
        }

        if (obj.size()>0)
            System.out.println("");

        for (String x : obj) {
            try
            {
                    alert(Double.parseDouble(x));
            }

            catch (Exception e)
            {
                alert(x);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
