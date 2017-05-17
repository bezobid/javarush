package com.javarush.test.level14.lesson06.home01;

/**
 * Created by bezobid on 08.12.2015.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 888;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}