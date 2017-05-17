package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        Person test = new Person("Peter", "Petrov", 99);
        test.setMother(new Person("mama", "mamina", 199));
        test.setFather(new Person("papa", "papin", 188));
        List<Person> kids = new ArrayList<>();
        kids.add(new Person("kid1", "kid12", 4));
        kids.add(new Person("kid2", "kid23", 5));
        test.setChildren(kids);

        System.out.println(test.firstName);
        System.out.println(test.lastName);
        System.out.println(test.age);
        System.out.println(test.mother.firstName);
        System.out.println(test.father.firstName);
        System.out.println(test.children.get(0).firstName);
        System.out.println(test.children.get(1).firstName);
        System.out.println("-------------------------");


        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/file"));
        test.writeExternal(out);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/file"));
        Person p = new Person();
        p.readExternal(in);
        in.close();

        System.out.println(p.firstName);
        System.out.println(p.lastName);
        System.out.println(p.age);
        System.out.println(p.mother.firstName);
        System.out.println(p.father.firstName);
        System.out.println(p.children.get(0).firstName);
        System.out.println(p.children.get(1).firstName);

    }


        public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

            public Person(){}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = in.readObject().toString();
            lastName = in.readObject().toString();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }
}
