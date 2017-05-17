package com.javarush.test.mytests.Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by bezobid on 07.10.2016.
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int port = Integer.parseInt(reader.readLine());

        Socket socket = new Socket("localhost", port);

    }
}
