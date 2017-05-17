package com.javarush.test.level14.lesson08.bonus01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try // 1
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try //2
        {
            int[] a = new int[2];
            a[3] = 0;
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //3
        {
            int[] a = new int[-1];

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //4
        {
            String s = "word";
            char a = s.charAt(6);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //5
        {
            throw new IOException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //6
        {
            throw new ArrayStoreException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new ClassCastException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new IllegalMonitorStateException());
        exceptions.add(new IllegalStateException());


    }
}
