package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bezobid on 31.05.2016.
 */
public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException{
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> list = new ArrayList<>();
        writeMessage("Выберите блюдо: " + Dish.allDishesToString());
        String dish;

        while(true){
            dish = readString();
            if(dish.equals("exit")) break;
            try {
                list.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException ex){
                writeMessage(dish + " is not detected");
            }
        }
        return list;
    }
}
