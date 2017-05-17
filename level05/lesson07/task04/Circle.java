package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private String circle = null;

    public void initialize(String centerX, String centerY, String radius){
        circle = centerX + centerY + radius;
    }

    public void initialize(String centerX, String centerY, String radius, String width){
        circle = centerX + centerY + radius + width;
    }

    public void initialize(String centerX, String centerY, String radius, String width, String color){
        circle = centerX + centerY + radius + width + color;
    }
}
