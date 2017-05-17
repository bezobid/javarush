package com.javarush.test.mytests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by bezobid on 16.01.2016.
 */
public class SystemOutReplace {
    public static void main(String[] args) {
        PrintStream real = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        System.out.println("Получилось?");
        System.setOut(real);
        System.out.println(output.toString());
    }
}
