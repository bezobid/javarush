package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by bezobid on 31.05.2016.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);


    Dish(int duration) {
        this.duration = duration;
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        Dish[] dishes = Dish.values();
        StringBuilder result = new StringBuilder();

        for(Dish dish : dishes){
            result.append(dish.toString());
            if (dish != dishes[dishes.length -1 ]){
                result.append(", ");
            }
        }
        return result.toString();
    }


}