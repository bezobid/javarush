package com.javarush.test.mytests;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bezobid on 01.06.2016.
 */
public class Recursion {
    public static void main(String[] args){
        String[] arr = {"A","B","C","D","E","F"};
        combinations2(arr, 2, 0, new String[6]);
    }

    static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }
}
