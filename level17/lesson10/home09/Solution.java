package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            BufferedReader read2AllLines = new BufferedReader(new FileReader(read.readLine()));
            while ((line = read2AllLines.readLine()) != null) {
                allLines.add(line);
            }
            read2AllLines.close();

            BufferedReader read2ForRemoveLines = new BufferedReader(new FileReader(read.readLine()));
            while ((line = read2ForRemoveLines.readLine()) != null) {
                forRemoveLines.add(line);
            }
            read2ForRemoveLines.close();
        } catch (IOException e) {
        }

        Solution test = new Solution();
        try {
            test.joinData();
        } catch (CorruptedDataException e) {}
    }

    public void joinData () throws CorruptedDataException {

        for (String line : forRemoveLines)
        {
            if (allLines.contains(line))
            {
                allLines.remove(line);
            }
            else
            {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
