package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name;
    int h;
    String c;

    public Dog(String name){
        this.name = name;
    }
    public Dog(String name, int h){
        this.name = name;
        this.h = h;
    }
    public Dog(String name, int h, String c){
        this.name = name;
        this.h = h;
        this.c = c;
    }
}
