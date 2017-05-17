package com.javarush.test.level07.lesson09.task01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> big = new ArrayList<Integer>();

        for (int a = 0; a < 20; a++) {
            big.add(Integer.parseInt(read.readLine()));
        }

        ArrayList<Integer> x2 = new ArrayList<Integer>();
        ArrayList<Integer> x3 = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();

        for (int a = 0; a < big.size(); a++){

            if (big.get(a) % 2 == 0)
                    x2.add(big.get(a));

            if (big.get(a) % 3 == 0)
                    x3.add(big.get(a));

            if ((big.get(a)%2 != 0) && (big.get(a)%3 != 0))
                other.add(big.get(a));
        }

        printList(x3);
        printList(x2);
        printList(other);

    }

    public static void printList(List<Integer> list)
    {
        for (int a = 0; a < list.size(); a++){
            System.out.println(list.get(a));
        }
    }
}
