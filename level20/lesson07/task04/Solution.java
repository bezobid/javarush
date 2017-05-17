package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    public static void main(String[] args){
        //System.out.println(new Solution(4));
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/file"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/file"));

            Solution savedObject = new Solution(100);
            out.writeObject(savedObject);
            out.close();
            System.out.println(savedObject);

            Solution loadedObject = (Solution) in.readObject();
            in.close();
            System.out.println(loadedObject);

            if (savedObject.string.equals(loadedObject.string))
                System.out.println("strings are equal");
            else
                System.out.println("strings are NOT equal");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }

        catch (IOException e)
        {
            System.out.println("IO Exception");
            e.printStackTrace();
        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found");
            e.printStackTrace();
        }

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
