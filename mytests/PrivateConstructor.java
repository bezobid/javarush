package com.javarush.test.mytests;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by bezobid on 14.04.2016.
 */

public class PrivateConstructor {
    private PrivateConstructor() {}
    public class InnerClass{
        public void f(){
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        new PrivateConstructor().new InnerClass();
    }
}

class TestClass{
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException{
        ArrayList<String> list = new ArrayList<>();

    }

    private static PrivateConstructor.InnerClass getInnerClass() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = PrivateConstructor.class;
        Constructor[] con = clazz.getDeclaredConstructors();
        Constructor constructor = con[0];
        constructor.setAccessible(true);
        PrivateConstructor pc = (PrivateConstructor)constructor.newInstance();
        return pc.new InnerClass();
    }
}
