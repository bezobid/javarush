package com.javarush.test.level14;

/**
 * Created by bezobid on 09.12.2015.
 */
public class Wave {

    public static void main(String[] args) throws Exception {


        String o = "o";
        StringBuilder line = new StringBuilder(o);

        while (true) {
            for (int a = 0; a < 20; a++) {
                System.out.println(line);
                line = line.append("o");
                Thread.sleep(20);
            }

            for (int a = 20; a > 0; a--) {
                line.deleteCharAt(a-1);
                System.out.println(line);
            }

        }
    }
}
