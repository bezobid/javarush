package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        String path = args[0];

        ArrayList<File> files = deleteBigFiles(new File(path), new ArrayList<File>());

        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        File oldResult = new File(args[1]);
        File newResult = new File(oldResult.getParent() + "/allFilesContent.txt");

        oldResult.renameTo(newResult);

        copy(files, newResult);

        deleteEmptyDirs(path);
        deleteEmptyDirs(path);
    }

    static void copy(ArrayList<File> files, File dst) {
        FileWriter out = null;
        try {
            out = new FileWriter(dst, true);

            for (File file : files) {
                FileReader in = null;
                try {
                    in = new FileReader(file);
                    if (file != files.get(0)) out.write('\n');

                    char[] buf = new char[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }
            }
        }catch (Exception e){}
        finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {}
        }
    }

    static ArrayList<File> deleteBigFiles(File file, ArrayList<File> list) {
            for (File f : file.listFiles()) {
                if (f.isFile()) {
                    if (f.length() > 50) {
                        f.delete();
                    } else {
                        list.add(f);
                    }
                } else if (f.isDirectory()) {
                    deleteBigFiles(f, list);
                }
            }
        return list;
    }

    static void deleteEmptyDirs(String path) {
        File rootDir = new File(path);
        int deleted = rootDir.list().length;
        while (deleted > 0) {
            deleted = 0;
            for (File file : rootDir.listFiles()) {
                if (file.isDirectory()) {
                    if (file.list().length == 0) {
                        file.delete();
                        deleted++;
                    } else {
                        deleteEmptyDirs(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
