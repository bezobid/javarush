package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int max = 0;
        for (int a=0; a < 5; a++){
            list.add(read.readLine());
            if (list.get(a).length() > max)
                max = list.get(a).length();
        }
        for (int a=0; a < 5; a++){
            if (list.get(a).length() == max)
                System.out.println(list.get(a));
        }
    }
}
