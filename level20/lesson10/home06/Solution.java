package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {

    public static void main(String[] args) throws IOException {
        SubSolution ss = new SubSolution();
        ObjectOutputStream oos = new ObjectOutputStream(new ByteArrayOutputStream());
        oos.writeObject(ss);
    }

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream s) throws NotSerializableException
        {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream s) throws NotSerializableException
        {
            throw new NotSerializableException();
        }
    }
}
