package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("D:\\Java\\JavaRushHomeWork\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
        if (pathToAnimals == null) return animals;
        File dir = new File(pathToAnimals);
        if (!dir.isDirectory()) return animals;

        try {
            URL path = dir.toURI().toURL();
            URL[] urls = new URL[]{path};
            ClassLoader classLoader = new URLClassLoader(urls);
            for (File file : dir.listFiles()){
                String fileName = file.getName();
                if (fileName.endsWith(".class")){
                    fileName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                    Class cls = classLoader.loadClass(fileName);
                    if (Animal.class.isAssignableFrom(cls)){
                            try{
                                animals.add((Animal)cls.newInstance());
                            } catch (InstantiationException e){

                            }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return animals;
    }
}
