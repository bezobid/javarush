package com.javarush.test.mytests;

/**
 * Created by bezobid on 05.10.2016.
 */
public class EmailTest {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            Email.sendEmail("Subject string", "Message body", "sugubo@gmail.com");
        }
    }
}
