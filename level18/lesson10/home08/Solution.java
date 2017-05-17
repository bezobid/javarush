package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String file = reader.readLine();
            if(file.equals("exit"))
                break;
            new ReadThread(file).start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run()
        {
            try {
                FileInputStream source = new FileInputStream(fileName);
                HashMap<Integer, Integer> map = new HashMap<>();

                while (source.available() > 0) {
                    int b = source.read();
                    if (map.containsKey(b))
                        map.put(b, map.get(b) + 1);
                    else map.put(b, 1);
                }

                int maxValue = 0;
                int maxKey = 0;

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxValue) {
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }

                resultMap.put(fileName, maxKey);
                source.close();
            }catch (Exception e){}
        }
    }
}
