package com.javarush.test.mytests.Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bezobid on 06.10.2016.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server running. Waiting for input connections...");

                Socket socket = serverSocket.accept();
                System.out.println("Input connection established!");
                InputStream inputStream = socket.getInputStream();
            while (true){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String message = bufferedReader.readLine();

                System.out.println("Incoming message: " + message.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
