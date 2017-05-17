package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double amount;

    public Money(double a)
    {
        amount = a;
    }

    public double getAmount()
    {
        return amount;
    }
    public abstract String getCurrencyName();
}

