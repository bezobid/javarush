package com.javarush.test.mytests.Sockets;

import java.io.*;
import java.net.Socket;

/**
 * Created by bezobid on 06.10.2016.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 4444);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                String input = reader.readLine();
                System.out.println("Your message is: " + input);
                out.println(input);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
