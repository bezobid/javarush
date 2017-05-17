package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by bezobid on 19.07.2016.
 */
public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillOval(x, y, width, height);
    }
}
