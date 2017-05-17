package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileInputStream file1reader = new FileInputStream(file1);
        FileInputStream file2reader = new FileInputStream(file2);

        byte[] buffer = new byte[file1reader.available()];
        file1reader.read(buffer);
        file1reader.close();

        FileWriter file1writer1 = new FileWriter(file1);
        while (file2reader.available() > 0)
            file1writer1.write(file2reader.read());

        file2reader.close();
        file1writer1.close();
        FileWriter file1writer2 = new FileWriter(file1, true);
        for (Byte x : buffer)
            file1writer2.write(x);
        file1writer2.close();
    }
}
