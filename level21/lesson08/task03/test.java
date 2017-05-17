package com.javarush.test.level21.lesson08.task03;

import com.javarush.test.level21.lesson08.task03.Solution.*;
/**
 * Created by bezobid on 22.02.2016.
 */
public class test {
    public static void main(String[] args) throws CloneNotSupportedException{
        A a = new A(1, 2);
        B b = new B(3, 4, "name");
        C c = new C(5, 6, "namename");

        A aa = a.clone();
        System.out.println(aa.getI() + " " + aa.getJ());
        C cc = c.clone();
        System.out.println(cc.getI() + " " + cc.getJ());
        System.out.println(cc.getName());
        B bb = b.clone();


    }
}
