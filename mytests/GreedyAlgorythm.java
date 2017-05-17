package com.javarush.test.mytests;

import java.lang.*;
import java.lang.Override;
import java.util.*;

/**
 * Created by bezobid on 20.05.2016.
 */
public class GreedyAlgorythm {
    static Map<Integer, Integer> denominations = new HashMap<>();

    static {
        denominations.put(1, 9);
        denominations.put(2, 4);
        denominations.put(5, 6);
        denominations.put(10, 7);
        denominations.put(20, 5);
        denominations.put(50, 3);
        denominations.put(100, 2);
    }


    public static void main(String[] args) {
        Map<Integer, Integer> result = withdraw(366);

        for (Integer i : result.keySet()) {
            System.out.println(i + " x " + result.get(i));
        }

        System.out.println("----------\n");

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }
    }

    static Map<Integer, Integer> withdraw(int expectedAmount) {

        TreeSet<Integer> keys = new TreeSet<>(denominations.keySet());
        HashMap<Integer, Integer> result = new HashMap<>();
        int toWithdraw = expectedAmount;

        while(true){
            Integer max = keys.floor(toWithdraw);
            Integer maxAvailable = denominations.get(max);

            int countRequired = toWithdraw / max;

            if (countRequired > maxAvailable){
                System.out.println(toWithdraw + " - " + max + " * " + maxAvailable);
                result.put(max, maxAvailable);
                toWithdraw -= max * maxAvailable;
            }

            else {
                System.out.println(toWithdraw + " - " + max + " * " + countRequired);
                result.put(max, countRequired);
                toWithdraw -= max * countRequired;
            }

            keys.remove(max);

            if (toWithdraw == 0)
            {
                System.out.println("Success!\n");

                for (Map.Entry<Integer, Integer> entry : result.entrySet()){
                    if (entry.getValue() < denominations.get(entry.getKey())) {
                        denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
                    }
                    else{
                        denominations.remove(entry.getKey());
                    }
                }

                break;
            }

            if (keys.isEmpty()){
                System.out.println("No such combination\n");
                break;
            }
        }
        return result;
}
}
