package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream source = new FileInputStream(read.readLine());
        read.close();

        ArrayList<Integer> list = new ArrayList<>();

        while (source.available() > 0)
        {
            int x = source.read();
            if(!list.contains(x))
            {
                list.add(x);
            }
        }

        source.close();

        Collections.sort(list);
        for (Integer x : list)
            System.out.print(x + " ");
    }
}
