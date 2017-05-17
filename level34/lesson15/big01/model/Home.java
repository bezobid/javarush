package com.javarush.test.level34.lesson15.big01.model;


import java.awt.*;

/**
 * Created by bezobid on 19.07.2016.
 */
public class Home extends GameObject {

    public Home(int x, int y) {
        super(x, y);
    }

    @Override

    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(x+Model.FIELD_SELL_SIZE/2, y+Model.FIELD_SELL_SIZE/2, 2, 2);
    }
}
