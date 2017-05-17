package com.javarush.test.level31.lesson06.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileNamePath = args[0];
        String zipFilePath = args[1];
        String fileName = Paths.get(fileNamePath).getFileName().toString();

        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);

        HashMap<String, byte[]> entries = new HashMap<>();
        boolean replaced = false;

        while (zis.available() > 0) {
            ZipEntry entry = zis.getNextEntry();
            byte[] entryBytes;

            if (entry != null) {

                if (Paths.get(entry.getName()).getFileName().toString().equals(fileName)) {
                    entryBytes = Files.readAllBytes(Paths.get(fileNamePath));
                    replaced = true;
                }
                else{
                    entryBytes = new byte[(int) entry.getSize()];
                    zis.read(entryBytes);
                }
                entries.put(entry.getName(), entryBytes);
            }
        }

        zis.close();
        fis.close();

        FileOutputStream fos = new FileOutputStream(zipFilePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        if (!replaced) {
            zos.putNextEntry(new ZipEntry("new/" + fileName));
            zos.write(Files.readAllBytes(Paths.get(fileNamePath)));
        }

        for (Map.Entry<String, byte[]> entry : entries.entrySet()) {
            zos.putNextEntry(new ZipEntry(entry.getKey()));
            zos.write(entry.getValue());
        }

        zos.close();
        fos.close();
    }
}
