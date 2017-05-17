package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws Exception{

        Solution sol = new Solution();
        System.out.println("creating new B...");
        B b = sol.new B(" qwerty");
        System.out.println("b name is " + b.name);
        System.out.println("-------------");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(b);
        oos.close();

        System.out.println("Deserializing b...");
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);

        Object o = ois.readObject();
        B b1 = (B) o;
        System.out.println("b1 name is " + b1.name);
    }

    public static class A {
        public A(){}
        protected String name = "A";

        public A(String name) {
            System.out.println("inside A constructor");
            this.name += name;
            System.out.println(this.name);
            System.out.println("-----------------");
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
            System.out.println("inside B constructor");
            System.out.println(this.name);
            System.out.println("------------------");
        }

        private void writeObject(ObjectOutputStream oos) throws IOException
        {
            oos.defaultWriteObject();
            oos.writeObject(this.name);
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException
        {
            ois.defaultReadObject();
            System.out.println("name after deser is " + this.name);
            this.name = (String) ois.readObject();
            System.out.println("restored name is " + this.name);
        }
    }
}
