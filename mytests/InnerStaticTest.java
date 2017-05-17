package com.javarush.test.mytests;

/**
 * Created by bezobid on 11.02.2016.
 */
public class InnerStaticTest {
    public static void main(String[] args) {

        InnerAndNestedClasses.StaticNestedClass t = new InnerAndNestedClasses.StaticNestedClass();
        System.out.println(t.q);

        InnerAndNestedClasses.InnerClass b = new InnerAndNestedClasses().new InnerClass();
        System.out.println(b.c);
        System.out.println(b.y);
    }
}
