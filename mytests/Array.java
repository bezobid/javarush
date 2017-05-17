package com.javarush.test.mytests;
import java.util.Arrays;

/**
 * Created by bezobid on 03.11.2015.
 */
public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        int x = 0;
        for (int a = array.length; a > 0; a--){
          array[x] = (int)(Math.random()*100);
            x++;
        }

      Arrays.sort(array);

        int y = 0;
        for(int a = array.length; a > 0; a--){
            System.out.println("Element #" + y + " is " + array[y]);
            y++;
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] < min)
                min = array[i];
        }

        System.out.println ('\n' + "Min is " + min);

        System.out.println('\n' + "Array length is " + array.length + '\n');

        String[][] names = {{"Mister ", "Missis "}, {"Jones", "Smith"}};

        System.out.println(names[0][1] + names[1][0]);
        System.out.println(names[0][0] + names[1][1]);

    }
}