package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
    String message;

    @Override
    public String toString() {
        if (message != null) return message;
        return super.toString();
    }

    public TooShortStringSecondThreadException(){}
    public TooShortStringSecondThreadException(String message){
        this.message = message;
    }

}
