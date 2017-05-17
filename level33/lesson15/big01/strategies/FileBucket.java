package com.javarush.test.level33.lesson15.big01.strategies;


import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by bezobid on 08.07.2016.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        long size = 0;
        try {
            size = Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return size;
    }

    public void putEntry(Entry entry){
        if (entry == null) return;

        try(FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fos)){

            Entry current = entry;

            while(current != null){
                out.writeObject(current);
                current = current.next;
            }

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry(){

        Entry entry = null;
        try(FileInputStream fis = new FileInputStream(path.toFile());
            ObjectInputStream ois = new ObjectInputStream(fis)){
            if (Files.size(path) == 0) return null;

            ArrayList<Entry> entries = new ArrayList<>();

            try{
                while(true){
                    Entry e = (Entry)ois.readObject();
                    entries.add(e);
                }
            }catch (Exception e){
                entry = entries.get(0);
                if (entries.size() > 1){
                    for (int i = 0; i < entries.size()-1; i++) {
                        entries.get(i).next = entries.get(i+1);
                    }
                }
            }

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

}
