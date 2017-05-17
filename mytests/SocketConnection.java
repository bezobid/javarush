package com.javarush.test.mytests;

import java.io.IOException;
import java.lang.*;
import java.lang.Exception;
import java.lang.Override;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bezobid on 20.06.2016.
 */
public class SocketConnection {
    public static void main(String[] args) throws IOException {

        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        Socket s = new Socket("localhost", 123);
                        s.getOutputStream().write(123);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        ServerSocket serverSocket = new ServerSocket(123);
        System.out.println("awaiting connection...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInputStream().read());
            System.out.println(socket.toString() + " CONNECTED!");

        }
    }



    }

