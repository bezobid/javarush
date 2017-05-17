package com.javarush.test.mytests;

import java.io.File;
import java.io.IOException;

/**
 * Created by bezobid on 08.01.2016.
 */
public class FilesAndPaths {
    public static void main(String[] args) throws IOException {

        File file = new File("c:/TEMP/dummy.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getParent());
        System.out.println(file.getPath());

        File file1 = new File(file.getParent(), "file2.part.com");
        System.out.println(file1.getPath());
        System.out.println(file1.getName());

        int index = file1.getName().lastIndexOf('.');
        String name = file1.getName().substring(0, index);
        System.out.println(name);


    }

}
