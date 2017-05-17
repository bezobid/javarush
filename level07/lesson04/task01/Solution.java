package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int i = 0;
        for(int a = array.length; a > 0; a--) {
            array[i] = Integer.parseInt(reader.readLine());
            i++;
                 }
        return array;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int a = 1; a < array.length; a++){
            if (array[a] > max)
                max = array[a];
        }
        return max;
    }
}
