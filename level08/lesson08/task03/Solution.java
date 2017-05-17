package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Андрей"));
        System.out.println(getCountTheSameLastName(map, "Иванов"));

    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map1 = new HashMap<String, String>();

        map1.put("Андреев", "Андрей");
        map1.put("Пупкин", "Вася");
        map1.put("Иванов", "Ваня");
        map1.put("Петров", "Петр");
        map1.put("Семенов", "Семен");
        map1.put("Дмитриев", "Дмитрий");
        map1.put("Александров", "Александр");
        map1.put("Павлов", "Павел");
        map1.put("Попова", "Попа");
        map1.put("Цымбал", "Андрей");

    return map1;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int firstNameCount = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name))
                firstNameCount++;
        }
        return firstNameCount;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String last)
    {
        int lastNameCount = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(last)) {
                lastNameCount++;
            }
        }
        return lastNameCount;

    }
}
