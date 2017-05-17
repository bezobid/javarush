package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat("KOT1", 2, 5, 4);
        Cat cat2 = new Cat("KOT2", 4, 7, 6);
        Cat cat3 = new Cat("KOT3", 3, 4, 5);

        boolean f1 = cat1.fight(cat2);
        if (f1) System.out.println("Бой 1: Победил " + cat1.name);
        else System.out.println("Бой 1: Победил " + cat2.name);
        boolean f2 = cat1.fight(cat3);
        if (f2) System.out.println("Бой 2: Победил " + cat1.name);
        else System.out.println("Бой 2: Победил " + cat3.name);
        boolean f3 = cat2.fight(cat3);
        if (f3) System.out.println("Бой 3: Победил " + cat2.name);
        else System.out.println("Бой 3: Победил " + cat3.name);

    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
