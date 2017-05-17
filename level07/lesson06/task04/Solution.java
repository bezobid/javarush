package com.javarush.test.level07.lesson06.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 10 строчек в начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(read.readLine());
        for (int a = 1; a < 10; a++){
            ar.add(0,read.readLine());
        }
        for (int a = 0; a < 10; a++){
            System.out.println(ar.get(a));
        }

    }
}
