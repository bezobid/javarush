package com.javarush.test.level14.lesson06.home01;

/**
 * Created by bezobid on 08.12.2015.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 666;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
