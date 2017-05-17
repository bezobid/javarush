package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String dog = null;

    public void initialize(String name){
        dog = name;
    }

    public void initialize(String name, int height){
        dog = name + height;
    }

    public void initialize(String name, int height, String color){
        dog = name + height + color;
    }
}
