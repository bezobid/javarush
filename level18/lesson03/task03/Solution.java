package com.javarush.test.level18.lesson03.task03;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream source = new FileInputStream(read.readLine());
        read.close();

        HashMap<Integer, Integer> map = new HashMap<>();

        while (source.available() > 0)
        {
            int x = source.read();
            if (map.containsKey(x))
            {
                map.put(x, map.get(x)+1);
            }
            else map.put(x, 1);
        }

        source.close();

        int max = 0;

        for (Integer value : map.values())
        {
            if (value > max) max = value;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue().equals(max))
            {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
