package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        cat1.name = "vasya";
        cat1.age = 3;
        cat1.weight = 6;
        cat1.strength = 10;

        Cat cat2 = new Cat();
        cat2.name = "murzik";
        cat2.age = 1;
        cat2.weight = 7;
        cat2.strength = 9;

        boolean x = cat1.fight(cat2);
        if (x)
            System.out.println("Победил " + cat1.name);

        else
            System.out.println("Победил " + cat2.name);


    }

    public boolean fight(Cat anotherCat)
    {
        int c1 = 0;
        int c2 = 0;

        if (this.age > anotherCat.age)
            c2++;
        if (this.age < anotherCat.age)
            c1++;

        if (this.weight > anotherCat.weight)
            c1++;
        if (anotherCat.weight > this.weight)
            c2++;

        if (this.strength > anotherCat.strength)
            c1++;
        if (anotherCat.strength > this.strength)
            c2++;

        System.out.println(this.name + " набрал " + c1 + " очков");
        System.out.println(anotherCat.name + " набрал " + c2 + " очков");

        return c1 > c2;
    }
}
