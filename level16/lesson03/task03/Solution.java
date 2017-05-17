package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        list.add(new Thread(new SpecialThread(1)));
        list.add(new Thread(new SpecialThread(2)));
        list.add(new Thread(new SpecialThread(3)));
        list.add(new Thread(new SpecialThread(4)));
        list.add(new Thread(new SpecialThread(5)));
        list.get(0).start();
        list.get(1).start();
        list.get(2).start();
        list.get(3).start();
        list.get(4).start();
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }

        public SpecialThread(int num)
        {
            System.out.println("Thread " + num + " created");
        }
    }
}
