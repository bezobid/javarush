package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file1 = read.readLine();
        String file2 = read.readLine();

        FileInputStream source = new FileInputStream(file1);
        FileOutputStream target = new FileOutputStream(file2);

        int count = 0;
        while(source.available() > 0)
        {
            int x = source.read();
            count++;
            if(count % 2 == 0)
                target.write(x);
        }
        source.close();
        target.close();
    }
}
