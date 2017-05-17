package com.javarush.test.mytests;

import java.util.Date;

/**
 * Created by bezobid on 25.11.2015.
 */
public class SpeedTests {

    public static void main(String[] args) {

        String[] fields = new String[10000];

        for (int a = 0; a < fields.length; a++)
            fields[a] = "element " + a;

        Date date1 = new Date();

        String s = "";
        for (int i = 0; i < fields.length; i++) {
            s = s + fields[i];
        }

        Date date2 = new Date();

        long time1 = date2.getTime() - date1.getTime();
        System.out.println(time1 + " ms");

        Date date3 = new Date();

        StringBuilder x = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            x.append(fields[i]);
        }

            Date date4 = new Date();

            long time2 = date4.getTime() - date3.getTime();
            System.out.println(time2 + " ms");


        }
    }
