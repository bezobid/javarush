package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file1 = read.readLine();
        String file2 = read.readLine();

        Scanner scanner = new Scanner(new File(file1));
        FileWriter writer = new FileWriter(file2);

        while (scanner.hasNext())
        {
            if (scanner.hasNextInt())
            {
                writer.write((scanner.next()));
            }
            else scanner.next();
            if (scanner.hasNextInt())
            {
                writer.write(" ");
            }
        }
        read.close();
        scanner.close();
        writer.close();
    }
}
