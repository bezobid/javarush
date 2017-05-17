package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String file1 = read.readLine();
        String file2 = read.readLine();
        FileWriter writer = new FileWriter(file2);
        Scanner scan = new Scanner(new FileReader(file1)).useLocale(Locale.ENGLISH);

        while(scan.hasNextDouble()) {
            double d = scan.nextDouble();
            int b = (int)Math.round(d);
            writer.write(String.valueOf(b));
            if (scan.hasNextDouble())
                writer.write(" ");
        }

        read.close();
        writer.close();
        scan.close();
    }
}
