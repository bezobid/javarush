package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;


/**
 * Created by bezobid on 31.05.2016.
 */
public class Order {
    Tablet tablet;
    List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";

        StringBuilder dishes = new StringBuilder();

        for (int x = 0; x < this.dishes.size(); x++){
            if (x != 0) dishes.append(", ");
            dishes.append(this.dishes.get(x).toString());
        }

        return String.format("Your order: [%s] of %s", dishes, tablet);
    }

    public int getTotalCookingTime(){
        int time = 0;
        for (Dish dish : dishes){
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty(){
        return dishes.size() == 0;
    }
}
