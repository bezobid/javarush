package com.javarush.test.mytests;

/**
 * Created by bezobid on 11.01.2016.
 */
public class StringFormatWithSubstrings {
    public static void main(String[] args) {
        String number = "501234567";
        String code = "38";

        String sum = String.format("+%s(0%s)%s-%s-%s", code, number.substring(0,2), number.substring(2,5), number.substring(5,7), number.substring(7,9));
        System.out.println(sum);
    }
}
