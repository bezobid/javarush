package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {

        Arrays.sort(array);

        double mediana;
        if (array.length % 2 != 0) mediana = array[array.length /2];
        else mediana = (array[array.length /2] + array[array.length /2 - 1]) * 0.5;

        final double m = mediana;

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                double dis1 = Math.abs(o1 - m);
                double dis2 = Math.abs(o2 - m);

                if (dis1 == dis2) return o1 - o2;
                else return (int)(dis1 - dis2);
            }
        });

        return array;
    }
}
