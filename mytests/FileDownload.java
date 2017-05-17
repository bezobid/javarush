package com.javarush.test.mytests;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 * Created by bezobid on 04.10.2016.
 */
public class FileDownload {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://web4host.net/5MB.zip");


            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream("c:/file.zip");

            byte[] buffer = new byte[1024];

            int count = 0;
            int size = 0;

            while ((count = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, count);
                size += count;
                System.out.println(size + " kb read");
            }

            inputStream.close();
            outputStream.close();

//            Files.copy(inputStream, new File("c:/5mb.zip").toPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
