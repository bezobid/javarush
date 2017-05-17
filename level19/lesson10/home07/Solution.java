package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File(args[0]));
        FileWriter writer = new FileWriter(new File(args[1]));

        int count = 0;
        while (scanner.hasNext())
        {
            String word = scanner.next();

            if (word.length() > 6)
            {
                count++;
                if (count != 1)
                    writer.write(",");
                writer.write(word);

            }
        }
        scanner.close();
        writer.close();
    }
}
