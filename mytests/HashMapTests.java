package com.javarush.test.mytests;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bezobid on 07.07.2016.
 */
public class HashMapTests {
    public static void main(String[] args) {
        int x = 63281940;
        int n = 16;
        System.out.println(x);

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(n - 1));

        String s = null;
        Object z = null;
        System.out.println(z.hashCode());
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "odin");
    }
}
