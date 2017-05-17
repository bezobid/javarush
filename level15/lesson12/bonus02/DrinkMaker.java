package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by bezobid on 17.12.2015.
 */
public abstract class DrinkMaker {

   abstract void getRightCup();
   abstract void putIngredient();
   abstract void pour();

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
