package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals("-c")) {

            StringBuilder nameBuilder = new StringBuilder();
            for (int x = 1; x < args.length - 2; x++) {
                nameBuilder.append(args[x]);
                nameBuilder.append(" ");
            }
            String name = nameBuilder.toString();
            String price = args[args.length - 2];
            String quantity = args[args.length - 1];

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(br.readLine());
            br.close();

            Scanner reader = new Scanner(file);

            int maxId = 0;
            while (reader.hasNextLine()) {
                String idString = reader.nextLine().substring(0, 8);
                int id;
                if (idString.contains(" ")) {
                    idString = idString.substring(0, idString.indexOf(' '));
                }
                id = Integer.parseInt(idString);
                if (id > maxId) maxId = id;
            }
            reader.close();
            int id = maxId + 1;

            String result = String.format("%n%-8d%-30.30s%-8.8s%-4.4s", id, name, price, quantity);
            FileWriter writer = new FileWriter(file, true);
            writer.write(result);
            writer.close();
        }
    }
}
