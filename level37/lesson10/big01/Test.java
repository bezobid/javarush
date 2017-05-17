package com.javarush.test.level37.lesson10.big01;

import java.io.*;
import java.util.Set;

/**
 * Created by bezobid on 07.09.2016.
 */
public class Test {
    public static void main(String[] args) {
        AmigoSet<Integer> amigo = new AmigoSet<>();
        amigo.add(1);
        amigo.add(2);
        amigo.add(3);

        AmigoSet cloned = amigo.clone();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\file"));
            oos.writeObject(amigo);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:\\file"));
            AmigoSet<Integer> restored = (AmigoSet)(ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
