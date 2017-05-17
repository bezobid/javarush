package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        //...
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String file = reader.readLine();

        String file = "c:/1";

        Scanner scanner = new Scanner(new File(file));

        ArrayList<String> list = new ArrayList<>();

        while(scanner.hasNext())
        {
            list.add(scanner.next());
        }

        String[] words = new String[list.size()];
        list.toArray(words);

        //for(String s : words) System.out.println(s);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder sb = new StringBuilder();

        if (words == null) return sb;
        if (words.length == 0) return sb;

        String[] list1 = new String[words.length];
        System.arraycopy(words, 0, list1, 0, words.length);
        //for (String s : list1) System.out.println(s);

        ArrayList<String> result = new ArrayList<>();

        result.add(list1[0]);
        list1[0] = null;
        int count = 1;

        //System.out.println(list1[0]);
        //System.out.println(result.get(result.size()-1));

        while (count < list1.length)
        {
            for (int i = 1; i < list1.length; i++)
            {
                String word = list1[i];
                if (word != null)
                {
                    System.out.println("Current word - " + word);
                    String lastWord = result.get(result.size()-1);
                    System.out.println("Last word - " + lastWord);
                    String lastLetter = String.valueOf(lastWord.charAt(lastWord.length()-1)).toLowerCase();
                    System.out.println("Last letter - " + lastLetter);
                    String nextLetter = String.valueOf(word.charAt(0)).toLowerCase();
                    System.out.println("Next letter - " + nextLetter);

                    if (lastLetter.equals(nextLetter))
                    {
                        result.add(word);
                        list1[i] = null;
                        count++;
                        System.out.println("match! count is " + count + "/" + words.length);
                    }
                    else
                    {
                        System.out.println("no match :(");
                    }

                    System.out.println("----------");

                }
            }
        }

        for (String s : result)
        {
            if (sb.length() != 0) sb.append(" ");
            sb.append(s);
        }

        return sb;
    }
}
