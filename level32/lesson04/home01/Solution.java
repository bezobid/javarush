package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/file.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        if (is == null) return new StringWriter();
        StringWriter sw = null;
        BufferedReader br = null;

        try {
            sw = new StringWriter();
            char[] buffer = new char[is.available()];
            int count;

            br = new BufferedReader(new InputStreamReader(is));


            while ((count = br.read(buffer)) > 0) {
                if (count < buffer.length){
                    sw.write(buffer, 0 , count);
                }
                else {
                    sw.write(buffer);
                }
            }

        }catch (Exception e){
            if (sw == null) return new StringWriter();
            else return sw;
        }finally {
            br.close();
        }

        return sw;
    }
}
