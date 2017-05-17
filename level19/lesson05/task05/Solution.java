package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(read.readLine());
        FileWriter writer = new FileWriter(read.readLine());

        while (reader.ready())
        {
            char x = (char)reader.read();
            if(!String.valueOf(x).matches("\\p{Punct}"))
            {
                writer.write(x);
            }
        }

        read.close();
        reader.close();
        writer.close();
    }
}
