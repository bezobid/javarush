package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        FileWriter out = new FileWriter(read.readLine());
        ArrayList<String> list = new ArrayList<>();
        while (true){
            String line = read.readLine();
            list.add(line);
            if (line.equals("exit"))
                break;
            }



        for (String s : list){
            out.write(s);
            out.write("\n");
        }

        read.close();
        out.close();
    }
}
