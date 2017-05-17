package com.javarush.test.mytests;

/**
 * Created by bezobid on 21.11.2015.
 */
public class Exception extends Throwable {

    public static void main(String[] args) {

        try {
            int a = (int) (Math.random() * 3);
            System.out.println(a);
            if (a == 1)
                throw new java.lang.Exception("a is " + a);

            if (a == 2)
                throw new java.lang.Exception("a is " + a);
        }

        catch (java.lang.Exception e){
            System.out.println(e.getMessage());
        }

    }
}
