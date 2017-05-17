package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by bezobid on 19.07.2016.
 */
public class Wall extends CollisionObject{
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(x, y, width, height);
        graphics.setColor(Color.LIGHT_GRAY);
    }
}
