package com.javarush.test.level22.lesson18.big01;

import java.util.Arrays;

/**
 * Created by bezobid on 15.03.2016.
 */
public class test {
    public static void main(String[] args) {
        Field test = new Field(5, 10);
        int w = test.getWidth();
        int h = test.getHeight();
        int[][] mat = test.getMatrix();

        mat[2] = new int[]{1,1,1,1,1};
        mat[5] = new int[]{1,1,1,1,1};
        mat[1] = new int[]{0,1,1,1,1};
        mat[7] = new int[]{0,1,1,0,1};
        mat[9] = new int[]{1,1,1,1,1};



        for (int x=0; x < h; x++)
        {
            for (int y = 0; y < w; y++)
            {
                if (mat[x][y] == 0) System.out.print(".");
                else System.out.print("x");
            }
            System.out.println("");
        }

        System.out.println("---------------");


        test.removeFullLines();

        mat = test.getMatrix();

        for (int x=0; x < h; x++)
        {
            for (int y = 0; y < w; y++)
            {
                if (mat[x][y] == 0) System.out.print(".");
                else System.out.print("x");
            }
            System.out.println("");
        }

    }


}
