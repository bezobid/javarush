package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File(args[0]));
        FileWriter writer = new FileWriter(new File(args[1]));

        while (scanner.hasNext())
        {
            String word = scanner.next();
            if (word.matches(".*\\d+.*"))
                writer.write(word + " ");
        }
        scanner.close();
        writer.close();
    }
}
