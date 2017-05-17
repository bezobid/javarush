package com.javarush.test.mytests;

import java.util.Locale;

/**
 * Created by bezobid on 10.01.2016.
 */
public class StringFormat {
    static String text1 = "text1";
    static int int1 = 123;
    static String text2 = "text2";
    static double flo = 123365635.45465456;


    public static void main(String[] args) {
        System.out.printf(Locale.US, "Строка №1 содержит %,.3f, а строка №2 содержит %.3s", flo, text2);
    }
}
