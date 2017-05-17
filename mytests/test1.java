package com.javarush.test.mytests;
import java.util.Scanner;

/**
 * Created by bezobid on 26.10.2015.
 */
public class test1
{
    public static void main(String[] args)
    {
        int res = 0;
       do
       {
           Scanner scan = new Scanner(System.in);

        System.out.println("Введите целое число");

        if (scan.hasNextInt())
        {
            res = scan.nextInt();
            if (res % 2 != 0)
                System.out.println("Нечетное число");
            else System.out.println("Четное число");
        } else System.out.println("Не целое число!");
       }
       while (res > 0);
    }
}
