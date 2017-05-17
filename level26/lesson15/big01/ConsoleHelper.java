package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by bezobid on 19.05.2016.
 */
public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {}

        if (line.equalsIgnoreCase("exit")){
            throw new InterruptOperationException();
        }

     return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String line;
        while(true){
            line = readString();
            if (line.length() == 3) {
                return line.toUpperCase();
            }
            else{
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(res.getString("choose.denomination.and.count.format"));
        String line;
        while(true){
            line = readString();
            if (line.matches("^\\d+ \\d+$")){
                return line.split(" ");
            }
            else{
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        String line;
        Operation op = null;
        while(true) {
            line = readString();
            int ordinal = Integer.parseInt(line);

            if (line.equals("1")) writeMessage(res.getString("operation.INFO"));
            else if (line.equals("2")) writeMessage(res.getString("operation.DEPOSIT"));
            else if (line.equals("3")) writeMessage(res.getString("operation.WITHDRAW"));
            else if (line.equals("4")) writeMessage(res.getString("operation.EXIT"));

            try {
                op = Operation.getAllowableOperationByOrdinal(ordinal);
                return op;
            } catch (IllegalArgumentException e){
                writeMessage(res.getString("invalid.data"));
                askOperation();
            }
            return op;
        }

    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
