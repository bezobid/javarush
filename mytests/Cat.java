package com.javarush.test.mytests;

/**
 * Created by bezobid on 03.11.2015.
 */
class Cat                   //класс
{
    String name;            //обычная переменная
    static int catCount;    //статическая переменная

    Cat(String name) {
        this.name = name;
        Cat.catCount++;   //увеличиваем значение статический переменной на 1
    }

    public static void main(String[] args) {


        System.out.println(catCount);
        Cat cat1 = new Cat("Vaska");

        System.out.println(catCount);
        Cat cat2 = new Cat("Murka");

        System.out.println(cat1.name);
        System.out.println(cat2.name);
        System.out.println(catCount);
        }
}