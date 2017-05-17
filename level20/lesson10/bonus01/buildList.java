package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/**
 * Created by bezobid on 19.02.2016.
 */
public class buildList {

    public static void main(String[] args) {

        long timeStart = System.currentTimeMillis();
        ArrayList<Integer> list = buildList(Integer.MAX_VALUE);
        //for(ArrayList<String> al : list) System.out.println(al);

        long timeEnd = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().totalMemory();
        long memoryEnd = Runtime.getRuntime().freeMemory();

        System.out.println("----------");
        System.out.println(timeEnd - timeStart + " ms");
        System.out.println((memoryStart - memoryEnd) / 1024 + " kb");


    }

    static ArrayList<Integer> buildList (int n)
    {
        String N = String.valueOf(n);
        ArrayList<String>[] listOfLists = new ArrayList[String.valueOf(n).length()];

        for (int i = 0; i < listOfLists.length; i++) {
            listOfLists[i] = new ArrayList<>();
        }


        for (int a = 0; a < 10; a++)                                // level 0
        {
            listOfLists[0].add(String.valueOf(a));
        }

        for (int level = 1; level < listOfLists.length; level++)
        {
            ArrayList<String> prevLevel = listOfLists[level-1];
            ArrayList<String> currentLevel = listOfLists[level];

            for (String number : prevLevel) {

                for (int j = 0; j < 10; j++)
                {
                    int last = Integer.parseInt(String.valueOf(number.charAt(number.length()-1)));
                    if (j >= last)
                    {
                        String num = number+j;
                        if ((level == listOfLists.length - 1) && num.compareTo(N) > 0)
                        {
                            ArrayList<Integer> allNumbers = new ArrayList<>();
                            for (ArrayList<String> list : listOfLists)
                            {
                                for (String string : list)
                                {
                                    allNumbers.add(Integer.parseInt(string));
                                }
                            }

                            System.out.println(allNumbers.size());
                            return allNumbers;
                        }
                        else
                        {
                            currentLevel.add(number + j);
                        }
                    }
                }
            }
        }

        return null;
    }
}
