package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class WorkingNotChecking
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код

        int[] bin = new int[array.length];
        ArrayList<String> w = new ArrayList<>();
        ArrayList<String> n = new ArrayList<>();

        for (int a = 0; a < array.length; a++){
            if (isNumber(array[a])) {
                bin[a] = 0;
                n.add(array[a]);
            }
            else {
                bin[a] = 1;
                w.add(array[a]);
            }
        }


        String[] numbersUnsorted = n.toArray(new String[n.size()]);
        Arrays.sort(numbersUnsorted);
        String[] numbers = new String[numbersUnsorted.length];
        for (int a = 0; a < numbersUnsorted.length; a++)
            numbers[a] = numbersUnsorted[numbersUnsorted.length - a - 1];

        String[] words = w.toArray(new String[w.size()]);
        for (int a = 0; a < words.length; a++) {
            String tmp;
            for (int b = 0; b < words.length; b++) {
                if (isGreaterThan(words[b].toLowerCase(), words[a].toLowerCase())){
                    tmp = words[a];
                    words[a] = words[b];
                    words[b] = tmp;
                }
            }
        }

        int numCount = 0;
        int wordCount = 0;

        for (int a = 0; a < bin.length; a++){
            if (bin[a] == 0){
                array[a] = numbers[numCount];
                numCount++;}
            else {
                array[a] = words[wordCount];
                wordCount++;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
