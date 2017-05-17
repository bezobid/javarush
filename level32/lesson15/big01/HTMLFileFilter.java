package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by bezobid on 01.07.2016.
 */
public class HTMLFileFilter extends FileFilter{
    @Override
    public boolean accept(File f) {
        String fileString = f.getName().toLowerCase();
        if (f.isDirectory() || fileString.endsWith(".html") || fileString.endsWith(".htm")) return true;

        return false;

    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
