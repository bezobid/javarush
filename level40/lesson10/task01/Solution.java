package com.javarush.test.level40.lesson10.task01;

/* Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответсвии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1
AM или PM: 1
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1

3) Для "17:33:40":
AM или PM: 1
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код

        SimpleDateFormat format;
        Date d;

        try {
            if (date.matches("^\\d{1,2}.\\d{1,2}.\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                d = format.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(d);

                System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH) + "\n" +
                        "День недели: " + calendar.get(Calendar.DAY_OF_WEEK) + "\n" +
                        "День месяца: " + calendar.get(Calendar.DAY_OF_MONTH) + "\n" +
                        "День года: " + calendar.get(Calendar.DAY_OF_YEAR) + "\n" +
                        "Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH) + "\n" +
                        "Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR) + "\n" +
                        "Месяц: " + calendar.get(Calendar.MONTH) + "\n" +
                        "Год: " + calendar.get(Calendar.YEAR) + "\n" +
                        "Эра: " + calendar.get(Calendar.ERA) + "\n" +
                        "AM или PM: " + calendar.get(Calendar.AM_PM) + "\n" +
                        "Часы: " + calendar.get(Calendar.HOUR) + "\n" +
                        "Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY) + "\n" +
                        "Минуты: " + calendar.get(Calendar.MINUTE) + "\n" +
                        "Секунды: " + calendar.get(Calendar.SECOND));

            } else if (date.matches("^\\d{1,2}.\\d{1,2}.\\d{4}$")) {
                format = new SimpleDateFormat("dd.MM.yyyy");
                d = format.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(d);

                System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH) + "\n" +
                        "День недели: " + calendar.get(Calendar.DAY_OF_WEEK) + "\n" +
                        "День месяца: " + calendar.get(Calendar.DAY_OF_MONTH) + "\n" +
                        "День года: " + calendar.get(Calendar.DAY_OF_YEAR) + "\n" +
                        "Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH) + "\n" +
                        "Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR) + "\n" +
                        "Месяц: " + calendar.get(Calendar.MONTH) + "\n" +
                        "Год: " + calendar.get(Calendar.YEAR) + "\n" +
                        "Эра: " + calendar.get(Calendar.ERA) + "\n");

            } else if (date.matches("^\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                format = new SimpleDateFormat("HH:mm:ss");
                d = format.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(d);

                System.out.println(
                        "AM или PM: " + calendar.get(Calendar.AM_PM) + "\n" +
                        "Часы: " + calendar.get(Calendar.HOUR) + "\n" +
                        "Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY) + "\n" +
                        "Минуты: " + calendar.get(Calendar.MINUTE) + "\n" +
                        "Секунды: " + calendar.get(Calendar.SECOND));

            }
        } catch (ParseException e){
            e.printStackTrace();
        }



    }
}
