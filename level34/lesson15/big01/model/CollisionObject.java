package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by bezobid on 19.07.2016.
 */
public abstract class CollisionObject extends GameObject{

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){

        int newX = this.getX();
        int newY = this.getY();

        switch (direction){
            case UP: newY -= Model.FIELD_SELL_SIZE;
                break;
            case DOWN: newY += Model.FIELD_SELL_SIZE;
                break;
            case LEFT: newX -= Model.FIELD_SELL_SIZE;
                break;
            case RIGHT: newX += Model.FIELD_SELL_SIZE;
        }

        return gameObject.getX() == newX && gameObject.getY() == newY;
    }

}
