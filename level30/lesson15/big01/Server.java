package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bezobid on 17.06.2016.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    private static class Handler extends Thread {
        private Socket socket;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message nameRequest = new Message(MessageType.NAME_REQUEST);
            Message nameAccepted = new Message(MessageType.NAME_ACCEPTED);
            Message clientName;

            connection.send(nameRequest);

            while (true) {
                clientName = connection.receive();
                if (clientName != null && clientName.getType() == MessageType.USER_NAME) {
                    String name = clientName.getData();
                    if (name != null && !name.equals("") && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(nameAccepted);
                        return name;
                    } else connection.send(nameRequest);
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for(String name : connectionMap.keySet()){
                if (!name.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true) {
                Message message = connection.receive();

                if (message != null) {
                    if (message.getType() == MessageType.TEXT) {
                        sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                    } else {
                        ConsoleHelper.writeMessage("Message is not text");
                    }
                }
            }

        }

        public void run(){
            Connection connection = null;
            String name = null;
            try {
                ConsoleHelper.writeMessage("New connection established with " + socket.getRemoteSocketAddress());
                connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);

            } catch (IOException e){
                ConsoleHelper.writeMessage("Connection error: IOException");
            }catch (ClassNotFoundException e){
                ConsoleHelper.writeMessage("Connection error: ClassNotFoundException");
            }
            finally {
                try {
                    connection.close();
                } catch (IOException e) {
                }
            }

            connectionMap.remove(name);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            ConsoleHelper.writeMessage("Connection with '" + name + "' closed");


        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection con : connectionMap.values()) {
            try {
                con.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Message sending failed");
            }
        }
    }



    public static void main(String[] args) {

        ConsoleHelper.writeMessage("Input server port:");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Server started successfully");

            while (true) {
                Socket socket = serverSocket.accept();
                if (socket != null) new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error!");
            try {
                serverSocket.close();
            } catch (Exception e1) {
            }
        }
    }
}
