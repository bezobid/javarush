package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file = read.readLine();
        read.close();
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\\W");
        int count = 0;

        StringBuilder sb = new StringBuilder();
        while(scanner.hasNext())
        {
            sb.append(scanner.next());
            sb.append("\n");
        }

        Scanner lines = new Scanner(sb.toString());

        while (lines.hasNextLine())
        {
            if (lines.nextLine().equals("world"))
                count++;
        }

        System.out.println(count);

        scanner.close();
        lines.close();
    }
}
