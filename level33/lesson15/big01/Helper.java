package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by bezobid on 07.07.2016.
 */
public class Helper {
    public static String generateRandomString(){
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(130,  secureRandom).toString(32);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

}
