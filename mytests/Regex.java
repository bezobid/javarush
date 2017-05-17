package com.javarush.test.mytests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String EXAMPLE_TEST = "<span>Turanga Leela </span></b></span><span>Super</span><span>girl</span>";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<span.*?>.*?</span>");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
