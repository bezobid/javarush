package com.javarush.test.level20.lesson10.home05;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by bezobid on 11.02.2016.
 */
public class test {
    public static void main(String[] args) throws Exception{

        System.out.println("creating new Person...");
        Solution.Person person1 = new Solution.Person("Vasya", "Pupkin", "Canada", Solution.Sex.MALE);
        System.out.println(person1.firstName);
        System.out.println(person1.lastName);
        System.out.println(person1.fullName);
        System.out.println(person1.greetingString);
        System.out.println(person1.country);
        System.out.println(person1.sex);
        System.out.println(person1.outputStream);
        System.out.println(person1.logger);
        System.out.println("-----------------");

        System.out.println("serializing person1...");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person1);
        baos.close();
        oos.close();
        System.out.println("finished");
        System.out.println("------------------");

        System.out.println("deserializing person1...");
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Solution.Person person2 = (Solution.Person)ois.readObject();
        System.out.println("finished");
        System.out.println("-------------------");

        System.out.println(person2.firstName);
        System.out.println(person2.lastName);
        System.out.println(person2.fullName);
        System.out.println(person2.greetingString);
        System.out.println(person2.country);
        System.out.println(person2.sex);
        System.out.println(person2.outputStream);
        System.out.println(person2.logger);

    }
}
