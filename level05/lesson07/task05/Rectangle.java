package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private String rect = null;

    String left = null;
    String top = null;
    String width = "0";
    String height = width;


    public void initialize(String left, String top, String width, String height){
        rect = left + top + width + height;
    }

    public void initialize(String left, String top){
        rect = left + top + width + height;
    }

    public void initialize(String left, String top, String width){
        rect = left + top + width + height;
    }

    public void initialize(Rectangle myrect, String left, String top, String width){
        rect = myrect + left + top + width + height;
    }
}
