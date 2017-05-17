package com.javarush.test.level08;

import java.util.Arrays;

/**
 * Created by bezobid on 19.11.2015.
 */
public class StringArraySort {

    public static void main(String[] args) {


        String[] list = {"one", "two", "three", "four", "five"};

        Arrays.sort(list);
        for (String a : list)
            System.out.println(a);

    }
}
