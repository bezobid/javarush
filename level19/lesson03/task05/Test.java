package com.javarush.test.level19.lesson03.task05;

/**
 * Created by bezobid on 13.01.2016.
 */
public class Test
{
    String[] name = "Ivanov, Ivan".split(", ");

    public static void main(String[] args) {
        System.out.println(new Test().getContactFirstName());
        System.out.println(new Test().getContactLastName());
        System.out.println(new Test().getDialString());
    }

    public String getContactFirstName()
    {
        return name[1];
    }

    public String getContactLastName()
    {
        return name[0];
    }

    public String getDialString()
    {
        StringBuilder sb = new StringBuilder("callto://+");
        char[] symbols = "+38(050)123-45-67".toCharArray();
        for(Character x : symbols){
            if (Character.isDigit(x))
            {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}

