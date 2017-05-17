package com.javarush.test.level19.lesson10.bonus01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File file1 = new File(scanner.nextLine());
        File file2 = new File(scanner.nextLine());
        scanner.close();

        ArrayList<String> source1 = file2list(file1);
        ArrayList<String> source2 = file2list(file2);


            for (int i = 0; i < 5; i++) {
                source2.add("x");
            }

            for (int i = 0; i < 5; i++) {
                source1.add("x");
            }

        int x1 = 0;
        int x2 = 0;

        int limit;
        if (source1.size() > source2.size())
            limit = source1.size() - x1;
        else limit = source2.size() - x2;

            for (int i = 0; i < limit; i++) {

                if (source1.get(i + x1).equals("x") && source2.get(i + x2).equals("x"))
                {
                    break;
                }

                else if (source1.get(i + x1).equals(source2.get(i + x2)))
                {
                    lines.add(new LineItem(Type.SAME, source1.get(i + x1)));
                } else if ((source1.get(i + x1).equals(source2.get(i + x2 + 1))) || source1.get(i + x1).equals("x"))
                {
                    lines.add(new LineItem(Type.ADDED, source2.get(i + x2)));
                    x1--;
                } else if (source1.get(i + x1 + 1).equals(source2.get(i + x2))|| source2.get(i + x2).equals("x"))
                {
                    lines.add(new LineItem(Type.REMOVED, source1.get(i + x1)));
                    x2--;
                }
            }
    }



    public static ArrayList<String> file2list(File file) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();

        while(scanner.hasNextLine())
        {
            list.add(scanner.nextLine());
        }

        scanner.close();
        return list;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
