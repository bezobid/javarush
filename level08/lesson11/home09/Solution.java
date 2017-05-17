package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 2 2000"));
    }

    public static boolean isDateOdd(String date)
    {
        Date day = new Date(date);
        Date ny = new Date(date);
        ny.setDate(0);
        ny.setMonth(0);
        long diff = (day.getTime() - ny.getTime());
        long a = diff / (1000*60*60*24);

        return (a+1) % 2 == 0;
    }
}
