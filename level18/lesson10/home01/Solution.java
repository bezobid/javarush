package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{

        FileReader source = new FileReader(args[0]);
        int count = 0;
        while (source.ready())
        {
            char symbol = (char)source.read();
            if (String.valueOf(symbol).matches("[a-zA-Z]"))
                count++;
        }
        System.out.println(count);
        source.close();
    }
}
