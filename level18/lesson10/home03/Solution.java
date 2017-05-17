package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        reader.close();

        FileReader file2stream = new FileReader(file2);
        FileReader file3stream = new FileReader(file3);
        FileWriter file1stream1 = new FileWriter(file1);

        int a;

       while ((a = file2stream.read()) != -1) // 2 -> 1
       {
           file1stream1.write(a);
       }
        file1stream1.close();

        FileWriter file1stream2 = new FileWriter(file1, true);

        while ((a = file3stream.read()) != -1) // 3 -> 1
       {
           file1stream2.write(a);
       }
        file1stream2.close();
        file2stream.close();
        file3stream.close();
    }
}
