package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));


        Scanner scanner = new Scanner(new File(read.readLine()));


        ArrayList<Integer> nums = new ArrayList<>();

        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());

        }

        Collections.sort(nums);

        for (Integer i : nums) {
            if (i % 2 == 0)
                System.out.println(i);

        }

    }
}
