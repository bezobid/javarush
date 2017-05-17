package com.javarush.test.level12.lesson09.task03;

/* Fly, Move, Eat для классов Dog, Car, Duck, Airplane
Есть public интерфейсы Fly(летать), Move(передвигаться), Eat(есть).
Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Move
    {
        public void move();
    }

    public interface Eat
    {
        public void eat();
    }

    public class Dog implements Move, Eat
    {
        public void move()
        {
            System.out.println("Move");
        }

        public void eat()
        {
            System.out.println("Eat");
        }
    }

    public class Duck implements Fly, Move, Eat
    {
        public void move()
        {
            System.out.println("Move");
        }

        public void eat()
        {
            System.out.println("Eat");
        }

        public void fly()
        {
            System.out.println("Fly");
        }
    }

    public class Car implements Move
    {
        public void move()
        {
            System.out.println("Move");
        }
    }

    public class Airplane implements Fly, Move
    {
        public void fly()
        {
            System.out.println("Fly");
        }

        public void move()
        {
            System.out.println("Move");
        }

    }
}
