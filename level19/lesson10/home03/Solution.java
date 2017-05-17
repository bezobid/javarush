package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File(args[0]));

        while(scanner.hasNext())
        {
            StringBuilder nameBuilder = new StringBuilder();

            while (!scanner.hasNextInt())
            {
                if(nameBuilder.length() != 0)
                {
                    nameBuilder.append(" ");
                }
                nameBuilder.append(scanner.next());
            }

                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                String dateString = String.format("%d %d %d", day, month, year);
                SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                Date date = format.parse(dateString);
                PEOPLE.add(new Person(nameBuilder.toString(), date));
            }

        scanner.close();
    }
}
