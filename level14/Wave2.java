package com.javarush.test.level14;

/**
 * Created by bezobid on 09.12.2015.
 */
public class Wave2 {

    public static void main(String[] args) throws Exception {
        String x = line('o', 30);
        draw(x);

    }

    public static String line(char ch, int length)
    {
        StringBuilder string = new StringBuilder(ch);

        for (int a = 0; a < length; a++)
        {
            string = string.append(ch);
        }
        return string.toString();
    }

    public static void draw(String s) throws Exception
    {
        for (int b = 0; b < 5; b++) {
            for (int a = s.length()-1; a >= 0; a--) {
                System.out.println(s.substring(a));
                Thread.sleep(50);
            }

            for (int a = 1; a < s.length()-1; a++) {
                System.out.println(s.substring(a));
                Thread.sleep(50);
            }

        }



    }
}
