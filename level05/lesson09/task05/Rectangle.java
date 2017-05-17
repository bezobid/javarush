package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle {
    private String rect = null;

    int l;
    int t;
    int w;
    int h = w;


    public Rectangle(int l, int t, int w, int h) {
        this.l = l;
        this.t = t;
        this.w = w;
        this.h = h;
    }

    public Rectangle(int l, int t) {
        this.l = l;
        this.t = t;
    }

    public Rectangle(int l, int t, int w) {
        this.l = l;
        this.t = t;
        this.w = w;
    }

    public Rectangle(Rectangle myrect, int l, int t, int w, int h) {
        this.l = l;
        this.t = t;
        this.w = w;
        this.h = h;
    }
}



