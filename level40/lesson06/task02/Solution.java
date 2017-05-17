package com.javarush.test.level40.lesson06.task02;

/* Принадлежность точки многоугольнику
Дан многоугольник, заданный координатами своих вершин.
Ребра многоугольника не пересекаются.
Необходимо реализовать метод isPointInPolygon(Point point, List<Point> polygon), который проверит,
принадлежит ли переданная точка многоугольнику.
*/

import java.util.ArrayList;
import java.util.List;

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код

        int minX = polygon.get(0).x;
        int minY = polygon.get(0).y;

        int maxX = 0;
        int maxY = 0;

        for (Point point1 : polygon) {
            if (point1.x < minX) minX = point1.x;
            if (point1.x > maxX) maxX = point1.x;
            if (point1.y < minY) minY = point1.y;
            if (point1.y > maxY) maxY = point1.y;
        }

        return point.x > minX && point.x < maxX && point.y > minY && point.y < maxY;
    }

}
