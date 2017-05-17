package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayList<String> fileList = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();
        File rootdDir = new File(root);

        for (File file : rootdDir.listFiles()){
            if (file.isFile()){
                fileList.add(file.getAbsolutePath());
            }
            else if (file.isDirectory()){
                queue.offer(file);
            }
        }

        while(!queue.isEmpty()){
            File file = queue.poll();
            if (file.isDirectory()){
                for(File f : file.listFiles()){
                    queue.offer(f);
                }
            }

            else if (file.isFile()){
                fileList.add(file.getAbsolutePath());
            }

        }

        return fileList;

    }
}
