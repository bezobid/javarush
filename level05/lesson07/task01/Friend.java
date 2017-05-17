package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String friend = null;
    public void initialize(String name){
        friend = name;
    }

    public void initialize(String name, int age){
        friend = name + age;
        }

    public void initialize(String name, int age, String sex){
        friend = name + age + sex;
    }
}

