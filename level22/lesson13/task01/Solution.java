package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {


    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer st = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();
        while (st.hasMoreTokens())
        {
            list.add(st.nextToken());
        }
        String[] tokens = new String[list.size()];
        list.toArray(tokens);

        return tokens;
    }
}
