package com.javarush.test.level22.lesson05.home01;

public class TooShortStringFirstThreadException extends RuntimeException {
    String message;

    @Override
    public String toString() {
        if (message != null) return message;
        return super.toString();
    }

    public TooShortStringFirstThreadException(){}
    public TooShortStringFirstThreadException(String message){
        this.message = message;
    }
}
