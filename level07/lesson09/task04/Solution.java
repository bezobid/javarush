package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза");
        list.add("лира");
        list.add("лоза");
        list.add("кот");
        list.add("руль");
        list.add("лук");

        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {

        ArrayList<String> list1 = new ArrayList<String>();

        for (int a = 0; a < list.size(); a++) {
            if (list.get(a).contains("л")) {

                if (list.get(a).contains("р"))
                    list1.add(list.get(a));

                else {
                    list1.add(list.get(a));
                    list1.add(list.get(a));
                }
            } else
                if (!list.get(a).contains("р"))
                list1.add(list.get(a));
        }

        return list1;
    }
}





