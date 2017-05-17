package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<File> files = new ArrayList<>();

        while (true)
        {
            String line = reader.readLine();
             if (line.equals("end")) break;
            files.add(new File(line));
        }
        reader.close();

        Collections.sort(files);

        int index = files.get(0).getName().lastIndexOf('.');
        String fileName = files.get(0).getName().substring(0, index);
        File result = new File(files.get(0).getParent(), fileName);
        FileWriter resultWriter = new FileWriter(result, true);

        char[] buffer = new char[100];
        int count;
        for (File entry : files)
        {
            FileReader source = new FileReader(entry);
            while((count = source.read(buffer)) != -1)
            {
                resultWriter.write(buffer, 0, count);
            }
            source.close();
        }
        resultWriter.close();
    }
}