package com.javarush.test.level14.lesson08.home09;

/**
 * Created by bezobid on 10.12.2015.
 */
public class USD extends Money {
    private double amount;

    public USD(double a)
    {
        super(a);
        amount = a;
    }

    public String getCurrencyName()
    {
        return "USD";
    }
}
