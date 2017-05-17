package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

        Human son1 = new Human();
        son1.name = "son1";
        son1.sex = true;
        son1.age = 22;

        Human son2 = new Human();
        son2.name = "son2";
        son2.sex = true;
        son2.age = 11;

        Human son3 = new Human();
        son3.name = "son3";
        son3.sex = true;
        son3.age = 1;

        Human dad = new Human();
        dad.name = "dad";
        dad.sex = true;
        dad.age = 44;
        dad.children.add(son1);
        dad.children.add(son2);
        dad.children.add(son3);


        Human mom = new Human();
        mom.name = "mom";
        mom.sex = false;
        mom.age = 33;
        mom.children.add(son1);
        mom.children.add(son2);
        mom.children.add(son3);

        Human ded1 = new Human();
        ded1.name = "ded1";
        ded1.sex = true;
        ded1.age = 99;
        ded1.children.add(dad);

        Human ded2 = new Human();
        ded2.name = "ded2";
        ded2.sex = true;
        ded2.age = 88;
        ded2.children.add(mom);

        Human bab1 = new Human();
        bab1.name = "bab1";
        bab1.sex = false;
        bab1.age = 77;
        bab1.children.add(dad);

        Human bab2 = new Human();
        bab2.name = "bab2";
        bab2.sex = false;
        bab2.age = 66;
        bab2.children.add(mom);






        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(ded1);
        System.out.println(bab1);
        System.out.println(ded2);
        System.out.println(bab2);

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
