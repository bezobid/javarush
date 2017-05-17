package com.javarush.test.level14.lesson06.home01;

/**
 * Created by bezobid on 08.12.2015.
 */

    abstract class Hen implements Country
    {
        abstract int getCountOfEggsPerMonth();

        String getDescription()
        {
            return "Я курица.";
        }
    }

