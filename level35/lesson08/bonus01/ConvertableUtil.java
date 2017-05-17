package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, L extends Convertable<K>> Map<K,L> convert(List<L> list) {
        Map result = new HashMap<K, L>();

        for (L item : list){
            result.put(item.getKey(), item);
        }

        return result;
    }
}
