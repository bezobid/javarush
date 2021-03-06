package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String phrase = read.readLine();

        ArrayList<Character> glas = new ArrayList<>();
        ArrayList<Character> other = new ArrayList<>();

        char[] arr = phrase.toCharArray();

        for (Character x : arr){
            if(isVowel(x))
                glas.add(x);
            else {
                if (!Character.isWhitespace(x))
                other.add(x);
            }
        }

        for (Character x : glas)
            System.out.print(x + " ");
        System.out.println("");
        for (Character x : other)
            System.out.print(x + " ");
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
