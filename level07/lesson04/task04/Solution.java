package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] ar = new int[10];
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        for (int a = 0; a < ar.length; a++){
            ar[a] = Integer.parseInt(read.readLine());
            }

        int[] ar1 = new int [10];
        for (int a = 0; a < ar.length; a++){
            ar1[a] = ar[ar.length - 1 - a];
            System.out.println(ar1[a]);
        }
    }
}
