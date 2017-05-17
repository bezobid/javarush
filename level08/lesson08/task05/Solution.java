package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    public static void main(String[] args) throws Exception {

        HashMap<String, String> map = createMap();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        System.out.println("--------------------------");

        removeTheFirstNameDuplicates(map);

        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
//        System.out.println(map.size());
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map1 = new HashMap<String, String>();

        map1.put("Андреев", "Андрей");
        map1.put("Пупкин", "Вася");
        map1.put("Иванов", "Ваня");
        map1.put("Петров", "Ваня");
        map1.put("Семенов", "Семен");
        map1.put("Дмитриев", "Дмитрий");
        map1.put("Александров", "Александр");
        map1.put("Павлов", "Павел");
        map1.put("Попова", "Попа");
        map1.put("Цымбал", "Андрей");

        return map1;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
      HashMap<String, String> Copy1 = new HashMap<String, String>(map);
      HashMap<String, String> Copy2 = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : Copy1.entrySet())
        {
            Copy2.remove(pair.getKey());
            if (Copy2.containsValue(pair.getValue())) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
