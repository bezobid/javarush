package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static class Human {
        //напишите тут ваши переменные и конструкторы
        boolean sex;
        int age;
        int height;
        int weight;
        String country;
        String religion;
        boolean family;
        String hairColor;
        boolean brain;

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(boolean sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Human(boolean sex, int weight, int height) {
            this.sex = sex;
            this.height = height;
            }
        public Human(boolean sex, int weight, int height, String country) {
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.country = country;
            }

        public Human(boolean sex, int height, String country) {
            this.sex = sex;
            this.height = height;
            this.country = country;
        }

        public Human(boolean sex, String country) {
            this.sex = sex;
            this.country = country;
        }

        public Human(boolean sex, String country, int age) {
            this.sex = sex;
            this.age = age;
            this.country = country;
        }

        public Human(boolean sex, String country, String hairColor) {
            this.sex = sex;
            this.hairColor = hairColor;
            this.country = country;
        }

        public Human(String country, String hairColor) {
            this.hairColor = hairColor;
            this.country = country;
        }

        public Human(String country, String hairColor, int age) {
            this.hairColor = hairColor;
            this.country = country;
            this.age = age;
        }
    }
}
