package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        //напишите тут ваш код
        Object x = new Integer(1);
        System.out.println((String)x);
    }

    public void methodThrowsNullPointerException() {
        //напишите тут ваш код
        int[] t = null;
        System.out.println(t[1]);
    }
}
