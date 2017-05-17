package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bezobid on 07.07.2016.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = new HashSet<>();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Date start1 = new Date();
        Set<Long> keys = getIds(shortener, strings);
        Date finish1 = new Date();
        Helper.printMessage(String.valueOf(finish1.getTime() - start1.getTime()));

        Date start2 = new Date();
        Set<String> values = getStrings(shortener, keys);
        Date finish2 = new Date();
        Helper.printMessage(String.valueOf(finish2.getTime() - start2.getTime()));

        Helper.printMessage(strings.equals(values) ? "Тест пройден." : "Тест не пройден.");


    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        //testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }
}
