package com.javarush.test.mytests;

/**
 * Created by bezobid on 15.06.2016.
 */
public class BitOperations {
    public static void main(String[] args) {
        {
            maxPowerOf2(140_000, 131072);   //131072
            maxPowerOf2(1026, 1024);      //1024
            maxPowerOf2(17, 16);        //16

            System.out.println();
        }
    }

    public static int maxPowerOf2(int x, int y) {

        int z = 1;
        while (z << 1 < x){
            z <<= 1;
        }

        return z;
    }
}


