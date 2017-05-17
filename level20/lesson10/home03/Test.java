package com.javarush.test.level20.lesson10.home03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by bezobid on 11.02.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception{

        Solution sol = new Solution();
        Solution.B b = sol.new B("qwerty");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(b);
        oos.close();

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);

        Object o = ois.readObject();
        Solution.B b1 = null;
        if (o instanceof Solution.B)
            b1 = (Solution.B) o;
        System.out.println(b1);
    }
}
