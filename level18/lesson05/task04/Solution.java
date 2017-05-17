package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file1 = read.readLine();
        String file2 = read.readLine();
        read.close();

        FileInputStream source = new FileInputStream(file1);
        FileOutputStream target = new FileOutputStream(file2);

        byte[] buffer = new byte[source.available()];
        source.read(buffer);

        for (int x = buffer.length-1; x >=0; x--)
        {
            target.write(buffer[x]);
        }

        source.close();
        target.close();
    }
}
