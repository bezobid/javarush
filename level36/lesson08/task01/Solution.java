package com.javarush.test.level36.lesson08.task01;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        FileReader reader = new FileReader(args[0]);
        Set<Character> symbols = new TreeSet<>();

        while(reader.ready()){
            Character c = (char)reader.read();
            String s = c.toString().toLowerCase();
            c = s.charAt(0);
            if (Character.isLetter(c)) {
                symbols.add(c);
            }
        }

        int count = 0;
        for (Character symbol : symbols) {
            if (count < 5){
                System.out.print(symbol);
                count++;
            }
        }

        reader.close();
    }
}
