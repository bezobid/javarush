package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        Scanner scanner = new Scanner(new File(file));
        ArrayList<String> source = new ArrayList<>();

        while(scanner.hasNext())
        {
            source.add(scanner.next());
        }

        HashSet<String> ok = new HashSet<>();

        for (int i = 0; i < source.size(); i++)
        {
            String word1 = source.get(i);

            for(int x = 0; x < source.size(); x++)
            {
                if (i != x)
                {
                    String word2 = source.get(x);
                    String reverse = new StringBuilder(word2).reverse().toString();
                    if (word1.equals(reverse) && !ok.contains(word2))
                    {
                        ok.add(word1);
                    }
                }

            }
        }

        // for (String s :ok) System.out.println(s);

        for (String s : ok)
        {
            Pair p = new Pair();
            p.first = s;
            p.second = new StringBuilder(s).reverse().toString();
            result.add(p);
        }

        for(Pair p : result) System.out.println(p.toString());

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
