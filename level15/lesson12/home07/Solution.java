package com.javarush.test.level15.lesson12.home07;


/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_NAME));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        }

        catch (Exception e){}
    }



    public static void main(String[] args) {
        System.out.println(lines);
    }
}
