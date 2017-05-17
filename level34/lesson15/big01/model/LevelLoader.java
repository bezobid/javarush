package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bezobid on 19.07.2016.
 */
public class LevelLoader {
    Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){

        int cellSize = Model.FIELD_SELL_SIZE;

        Player player = null;
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))){

            int currentLine = 0;

            while(reader.ready()){
                String line = reader.readLine();
                if (line.equals("Maze: " + (level > 60 ? level%60 : level))){
                    while(!reader.readLine().equals("")) {}

                    while(!(line = reader.readLine()).equals("") ){
                        char[] chars = line.toCharArray();

                        for (int i = 0; i < chars.length; i++) {
                            int x = cellSize/2 + i*cellSize;
                            int y = cellSize/2 + currentLine*cellSize;
                            char object = chars[i];

                            switch (object){
                                case '@': player = new Player(x, y);
                                    break;
                                case 'X': walls.add(new Wall(x, y));
                                    break;
                                case '*': boxes.add(new Box(x, y));
                                    break;
                                case '.': homes.add(new Home(x, y));
                                    break;
                                case '&': boxes.add(new Box(x, y));
                                    homes.add(new Home(x, y));
                                    break;
                            }
                        }
                        currentLine++;
                    }
                    break;
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }
}
