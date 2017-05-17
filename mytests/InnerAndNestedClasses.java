package com.javarush.test.mytests;

/**
 * Created by bezobid on 11.02.2016.
 */

/**
 Вложенные классы — элементы содержащего их класса.
 Inner классы имеют доступ к полям содержащего класса, даже если они объявлены как private.
 Static классы не имеют доступ к членам внешнего класса.
 Как и другие поля класса, вложенные классы могут быть объявлены как private, public, protected, или package private.
 */

public class InnerAndNestedClasses {

    static int x = 1;
    private static byte b = 2;

    StaticNestedClass snc = new StaticNestedClass();

    class InnerClass
    {
        int y = x * 2;
        byte c = b;


    }

    static class StaticNestedClass
    {
        final int q = 15;
        int a = x;        // нет доступа
        static byte n = b;

        public String toString()
        {
            return "Static nested";
        }
    }
}
