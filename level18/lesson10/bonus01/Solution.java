package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        File source = new File(args[1]);
        File target = new File(args[2]);

        if(args[0].equals("-e"))
        {
            encrypt(source, target);
        }

        if(args[0].equals("-d"))
        {
            decrypt(source, target);
        }
    }

    public static void encrypt(File source, File target) throws IOException
    {
        FileInputStream sourceReader = new FileInputStream(source);
        FileOutputStream targetWriter = new FileOutputStream(target);

        while(sourceReader.available() > 0)
        {
            targetWriter.write(sourceReader.read()+1);
        }

        sourceReader.close();
        targetWriter.close();
    }

    public static void decrypt(File source, File target) throws IOException
    {
        FileInputStream sourceReader = new FileInputStream(source);
        FileOutputStream targetWriter = new FileOutputStream(target);

        while(sourceReader.available() > 0)
        {
            targetWriter.write(sourceReader.read()-1);
        }

        sourceReader.close();
        targetWriter.close();
    }

    }

