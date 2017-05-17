package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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

        double max = 0;
        for (Double value : map.values())
        {
            if (value > max)
            {
                max = value;
            }
        }


        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if (entry.getValue() == max)
            {
                System.out.println(entry.getKey());
            }
        }

        scanner.close();
    }
}
