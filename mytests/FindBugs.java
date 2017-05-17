package com.javarush.test.mytests;

/**
 * Created by bezobid on 09.06.2016.
 */
public class FindBugs {
    public static void main(String[] args) {
        boolean flag = false;
        Number n = flag ? new Integer(1) : new Double(2.0);
    }
}
