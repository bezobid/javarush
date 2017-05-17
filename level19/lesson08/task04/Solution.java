package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream myOutput = new PrintStream(output);
        System.setOut(myOutput);
        testString.printSomething();
        System.setOut(original);
        String x = output.toString();

        int arg1 = Integer.parseInt(x.substring(0, x.indexOf(' ')));
        String sign = x.substring(x.indexOf(' ')+1, x.indexOf(' ')+2);
        int arg2 = Integer.parseInt(x.substring(x.indexOf(sign)+2, x.indexOf('=')-1));

        int result = 0;
        if(sign.equals("+"))
            result = arg1 + arg2;

        if(sign.equals("-"))
            result = arg1 - arg2;

        if(sign.equals("*"))
            result = arg1 * arg2;

        System.out.printf("%d %s %d = %d", arg1, sign, arg2, result);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

