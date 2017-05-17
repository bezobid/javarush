package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) {

        if (args.length < 2) return;

        String resultFileName = args[0];
        String[] partNames = new String[args.length - 1];
        System.arraycopy(args, 1, partNames, 0, args.length - 1);
        Arrays.sort(partNames);

        FileInputStream reader = null;
        ZipInputStream zipInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            byte[] buffer = new byte[1024];
            int count;

            for (String filePart : partNames) {
                reader = new FileInputStream(filePart);

                while ((count = reader.read(buffer)) > 0) {
                    if (count == buffer.length) {
                        byteArrayOutputStream.write(buffer);
                    } else {
                        byteArrayOutputStream.write(buffer, 0, count);
                    }
                }
            }

            zipInputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            while(zipInputStream.available() > 0) {
                zipInputStream.getNextEntry();
                Path result = Paths.get(resultFileName);
                if (Files.exists(result)) {
                    Files.delete(result);
                }
                Files.copy(zipInputStream, result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                byteArrayOutputStream.close();
                reader.close();
                zipInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
