package com.javarush.test.mytests;

import java.lang.*;

/**
 * Created by bezobid on 08.12.2015.
 */
public class ClassFromString {

    public static void main(String[] args) throws java.lang.Exception {
        String x = "com.javarush.test.mytests.test1";
        Object y = Class.forName(x).newInstance();
        System.out.println(y.getClass().getSimpleName());
        //test1 rew = (test1)y;
        //System.out.println(rew.getClass().getSimpleName());

    }

    public class test1 {}

}
