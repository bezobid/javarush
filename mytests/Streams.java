package com.javarush.test.mytests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.*;

/**
 * Created by bezobid on 04.01.2016.
 */
public class Streams {
    public static void main(String[] args) throws java.lang.Exception
    {
        FileInputStream source = new FileInputStream("c:/data.txt");
        FileOutputStream result = new FileOutputStream("c:/result.txt");

        while (source.available() > 0)
        {
            result.write(source.read());
        }
        source.close();
        result.close();
    }

}
