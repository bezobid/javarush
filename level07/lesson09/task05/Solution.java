package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Считать строки с консоли и объявить ArrayList list тут

        ArrayList<String> list = new ArrayList<String>();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        for (int a = 0; a < 10; a++) list.add(read.readLine());


        ArrayList<String> result = doubleValues(list);

        //Вывести на экран result

        for (int a = 0; a < result.size(); a++)
            System.out.println(result.get(a));
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list)
    {
        //напишите тут ваш код

        ArrayList<String> res = new ArrayList<String>();
        for (int a = 0; a < list.size(); a++){
            res.add(list.get(a));
            res.add(list.get(a));
        }
        return res;
    }
}
