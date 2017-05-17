package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код

        ArrayList<int[]> list = new ArrayList<>();
        int x = (int)(Math.random()*10);

        int[] five = new int[5];
        for (int a = 0; a < five.length; a++)
            five[a] = (int)(Math.random()*10);

        int[] two = new int[2];
        for (int a = 0; a < two.length; a++)
            two[a] = (int)(Math.random()*10);

        int[] four = new int[4];
        for (int a = 0; a < four.length; a++)
            four[a] = (int)(Math.random()*10);

        int[] seven = new int[7];
        for (int a = 0; a < seven.length; a++)
            seven[a] = (int)(Math.random()*10);

        int[] zero = new int[0];

        list.add(five);
        list.add(two);
        list.add(four);
        list.add(seven);
        list.add(zero);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
