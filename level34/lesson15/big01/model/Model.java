package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

/**
 * Created by bezobid on 19.07.2016.
 */
public class Model {
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    GameObjects gameObjects;
    int currentLevel = 60;
    LevelLoader levelLoader = new LevelLoader(Paths.get("src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {

        for (Wall w : gameObjects.getWalls()) {
            if (gameObject.isCollision(w, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {
        Player player = gameObjects.getPlayer();
        for (Box box : gameObjects.getBoxes()) {
            if (player.isCollision(box, direction)) {
                for (Box anotherBox : gameObjects.getBoxes()) {
                    if (box.isCollision(anotherBox, direction) || checkWallCollision(box, direction)) {
                        return true;
                    }
                }

                int newX = 0;
                int newY = 0;

                switch (direction) {
                    case UP:
                        newY -= Model.FIELD_SELL_SIZE;
                        break;
                    case DOWN:
                        newY += Model.FIELD_SELL_SIZE;
                        break;
                    case LEFT:
                        newX -= Model.FIELD_SELL_SIZE;
                        break;
                    case RIGHT:
                        newX += Model.FIELD_SELL_SIZE;
                }

                box.move(newX, newY);
            }

        }
        return false;
    }

    public void checkCompletion(){
        Set<Home> homes = gameObjects.getHomes();
        int filled = 0;

        for (Home home : homes) {
            for (Box box : gameObjects.getBoxes()){
                if (home.getX() == box.getX() && home.getY() == box.getY()){
                    filled++;
                }
            }
        }

        if (filled == homes.size()) eventListener.levelCompleted(currentLevel);
    }

    public void move(Direction direction){
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollision(direction)) return;


        int newX = 0;
        int newY = 0;

        switch (direction) {
            case UP:
                newY -= Model.FIELD_SELL_SIZE;
                break;
            case DOWN:
                newY += Model.FIELD_SELL_SIZE;
                break;
            case LEFT:
                newX -= Model.FIELD_SELL_SIZE;
                break;
            case RIGHT:
                newX += Model.FIELD_SELL_SIZE;
        }

        player.move(newX, newY);
        checkCompletion();
    }
}


