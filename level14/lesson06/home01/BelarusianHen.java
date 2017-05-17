package com.javarush.test.level14.lesson06.home01;

/**
 * Created by bezobid on 08.12.2015.
 */
public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 999;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
