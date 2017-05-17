package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ar = new ArrayList<String>();

        for (int a = 0; a < 5; a++) {
            ar.add(read.readLine());
        }

        for (int a = 0; a < 13; a++) {
        ar.add(0, ar.get(ar.size() - 1));
        ar.remove((ar.size() - 1));
        }

        for (int a=0; a < ar.size(); a++){
            System.out.println(ar.get(a));
        }
    }
}