package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] big = new int[20];

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        for (int a = 0; a < big.length; a++){
            big[a] = Integer.parseInt(read.readLine());
        }

        int[] s1 = new int[big.length/2];
        int[] s2 = new int[big.length/2];

        for (int a = 0; a < (big.length/2); a++){
            s1[a] = big[a];
            s2[a] = big [a+big.length/2];
            System.out.println(s2[a]);
        }


    }
}
