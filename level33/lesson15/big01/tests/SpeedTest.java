package com.javarush.test.level33.lesson15.big01.tests;

import com.google.common.base.Strings;
import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bezobid on 09.07.2016.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String>strings, Set<Long> ids){

        long start = new Date().getTime();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        long finish = new Date().getTime();


        return finish - start;
    }

    public long getTimeForGettingStrings(Shortener shortener,Set<Long> ids, Set<String> strings){
        long start = new Date().getTime();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        long finish = new Date().getTime();


        return finish - start;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>(10000);

        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids = new HashSet<>(10000);

        long time1 = getTimeForGettingIds(shortener1, origStrings, ids);
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids);

        Assert.assertTrue(time1 > time2);

        Set<String> strings = new HashSet<>(10000);

        long time3 = getTimeForGettingStrings(shortener1, ids, strings);
        long time4 = getTimeForGettingStrings(shortener2, ids, strings);

        Assert.assertEquals(time3, time4, 5);

    }



}
