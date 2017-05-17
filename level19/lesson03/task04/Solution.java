package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;
        PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        public void close()
        {
            this.scanner.close();
        }

        public Person read()
        {
            String[] words = scanner.nextLine().split(" ");
            String lastName = words[0];
            String firstName = words[1];
            String middleName = words[2];
            String date = String.format("%s/%s/%s", words[3], words[4], words[5]);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date birth = null;
            try {
                birth = format.parse(date);
            }catch (ParseException e){}



            return new Person(firstName, middleName, lastName, birth);

        }

    }

}
