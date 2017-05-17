package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код

        Human ded1 = new Human();
        ded1.name = "Ded1";
        ded1.sex = true;
        ded1.age = 99;

        Human ded2 = new Human();
        ded2.name = "Ded2";
        ded2.sex = true;
        ded2.age = 100;

        Human bab1 = new Human();
        bab1.name = "Babka1";
        bab1.sex = false;
        bab1.age = 88;

        Human bab2 = new Human();
        bab2.name = "Babka2";
        bab2.sex = false;
        bab2.age = 89;

        Human father = new Human();
        father.name = "Otets";
        father.sex = true;
        father.age = 45;
        father.father = ded1;
        father.mother = bab1;

        Human mother = new Human();
        mother.name = "Mat";
        mother.sex = false;
        mother.age = 35;
        mother.father = ded2;
        mother.mother = bab2;

        Human son1 = new Human();
        son1.name = "Son1";
        son1.sex = true;
        son1.age = 2;
        son1.father = father;
        son1.mother = mother;

        Human son2 = new Human();
        son2.name = "Son2";
        son2.sex = true;
        son2.age = 5;
        son2.father = father;
        son2.mother = mother;

        Human son3 = new Human();
        son3.name = "Son3";
        son3.sex = true;
        son3.age = 5;
        son3.father = father;
        son3.mother = mother;

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(bab1);
        System.out.println(bab2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);




    }

    public static class Human
    {
        //напишите тут ваш код

        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
