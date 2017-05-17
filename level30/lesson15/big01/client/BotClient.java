package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by bezobid on 19.06.2016.
 */
public class BotClient extends Client {
    private static int botCount = 0;
    public class BotSocketThread extends Client.SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if(message != null && message.contains(":")) {
                ConsoleHelper.writeMessage(message);
                String[] messageCutInPieces = message.split(": ");
                String name = messageCutInPieces[0];
                String msg = messageCutInPieces[1];

                String dateFormat = null;
                switch (msg) {
                    case "дата":
                        dateFormat = "d.MM.YYYY";
                        break;
                    case "день":
                        dateFormat = "d";
                        break;
                    case "месяц":
                        dateFormat = "MMMM";
                        break;
                    case "год":
                        dateFormat = "YYYY";
                        break;
                    case "время":
                        dateFormat = "H:mm:ss";
                        break;
                    case "час":
                        dateFormat = "H";
                        break;
                    case "минуты":
                        dateFormat = "m";
                        break;
                    case "секунды":
                        dateFormat = "s";
                        break;
                }
                if (dateFormat != null) {
                    SimpleDateFormat format = new SimpleDateFormat(dateFormat);
                    Date date = Calendar.getInstance().getTime();

                    String response = String.format("Информация для %s: %s", name, format.format(date));
                    sendTextMessage(response);
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "dateBot" + ++botCount;
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
