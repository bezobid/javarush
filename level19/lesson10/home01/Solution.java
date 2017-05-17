package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (scanner.hasNext())
        {
            String name = scanner.next();
            double value = Double.parseDouble(scanner.next());

            if (map.containsKey(name))
            {
                map.put(name, map.get(name)+value);
            }
            else
            {
                map.put(name, value);
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        scanner.close();
    }
}
