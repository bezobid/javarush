package com.javarush.test.mytests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by bezobid on 28.06.2016.
 */
public class RandomAccess {
    public static void main(String[] args)  {
        try {
            RandomAccessFile file = new RandomAccessFile("c:/file.txt", "rw");

            file.read();
            file.write(0x10110110);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
