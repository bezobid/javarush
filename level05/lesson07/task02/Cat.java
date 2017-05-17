package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String cat = null;
    int weight = 5;
    int age = 3;
    String name = null;
    String address = null;
    String color = null;


    public void initialize(String name)
    {
        cat = name;
    }

    public void initialize(String name, int weight, int age)
    {
        cat = name + weight + age;
    }

    public void initialize(String name, int age)
    {
        cat = name + weight + age;
    }

    public void initialize(int weight, String color)
    {
        cat = weight + color + name + address + age;
    }

    public void initialize(int weight, String color, String address)
    {
        cat = weight + color + address;
    }
}


