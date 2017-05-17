package com.javarush.test.mytests;


/**
 * Created by bezobid on 02.03.2016.
 */
public class stackTrace {
    public static void main(String[] args) {

        try{
            String a = "123";
            a.charAt(-1);
        } catch (StringIndexOutOfBoundsException e)
        {
            try
            {
                throw new RuntimeException();
            }catch (RuntimeException r)
            {
                //e.printStackTrace();
                System.out.println("---");
                for (StackTraceElement stackTraceElement : r.getStackTrace()) {
                    System.out.println(stackTraceElement.toString());
                }

            }
        }

    }
}
