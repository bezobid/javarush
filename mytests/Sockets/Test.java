package com.javarush.test.mytests.Sockets;

import com.javarush.test.mytests.Email;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by bezobid on 07.10.2016.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final Thread server = new Thread(new ServerThread());

        Thread watcher = new Thread(){
            public void run(){
                while (true){
                    System.out.println("Server thread state: " + server.getState());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        watcher.setDaemon(true);
        watcher.start();

        Thread.sleep(3000);
        server.start();
    }

    static class ServerThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(800);
                ServerSocket serverSocket = new ServerSocket(4444);
                System.err.println("ServerSocket created. Now sleeping for 3 sec");
                Thread.sleep(3500);
                //serverSocket.setSoTimeout(3500);
                System.err.println("Waiting for incoming connections");

                while (true) {
                    Socket accept = serverSocket.accept();
                    System.err.println("Client connection established. Client address is: " + accept.getInetAddress() + ":" + accept.getPort());
                    System.out.println("Sending email");
                    Email.sendEmail("Attempt to connnect", "Alarm!!!", "sugubo@gmail.com");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
