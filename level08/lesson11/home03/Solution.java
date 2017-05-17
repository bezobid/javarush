package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        //напишите тут ваш код

       Map<String, String> map1 = new HashMap<String, String>();

        map1.put("Андреев", "Вова");
        map1.put("Васильев", "Вася");
        map1.put("Иванов", "Ваня");
        map1.put("Петров", "Петр");
        map1.put("Семенов", "Семен");
        map1.put("Дмитриев", "Дмитрий");
        map1.put("Александров", "Александр");
        map1.put("Павлов", "Павел");
        map1.put("Попова", "Попа");
        map1.put("Андреев", "Андрей");

        return map1;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
