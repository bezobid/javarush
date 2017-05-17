package com.javarush.test.level08;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bezobid on 12.11.2015.
 */
public class hashMap {
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("first", "Mama");
        map.put("second", "Mila");
        map.put("third", "Ramu");

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
    }
}
