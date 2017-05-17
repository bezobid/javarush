package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/**
 * Created by bezobid on 10.02.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception{

        Solution solution = new Solution();
        Solution.A b = solution.new B();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(b);
        oos.close();

        solution.getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())));

    }
}
