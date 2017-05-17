package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by bezobid on 19.07.2016.
 */
public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillOval(x, y, width, height);

    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
