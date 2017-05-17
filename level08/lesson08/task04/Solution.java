package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, Date> list= createMap();
        for (Map.Entry<String, Date> pair : list.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        System.out.println("-----------------------------------");
        removeAllSummerPeople(list);
        for (Map.Entry<String, Date> pair : list.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());


    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone0", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("MARCH 1 1980"));
        map.put("Stallone2", new Date("MARCH 1 1980"));
        map.put("Stallone3", new Date("MARCH 1 1980"));
        map.put("Stallone4", new Date("MARCH 1 1980"));
        map.put("Stallone5", new Date("JULY 1 1980"));
        map.put("Stallone6", new Date("MARCH 1 1980"));
        map.put("Stallone7", new Date("MARCH 1 1980"));
        map.put("Stallone8", new Date("AUGUST 1 1980"));
        map.put("Stallone9", new Date("MARCH 1 1980"));

        //напишите тут ваш код

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> copy = new HashMap<String, Date>(map);

        for (Map.Entry<String, Date> pair : copy.entrySet()){
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8)
                map.remove(pair.getKey());
        }


    }
}
