package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        String stringFile = "c:/string";
        String objectFile = "c:/object";

        Solution s1 = new Solution(stringFile);                                                 // 1

        s1.writeObject("First string");                                                         // 2
        System.out.println("String1 written");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
        oos.writeObject(s1);                                                                    // 3
        oos.close();
        System.out.println("Object serialized");


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));
        Solution s2 = (Solution)ois.readObject();                                               // 4
        ois.close();
        System.out.println("Object deserialized");
        System.out.println(s2.fileName);

        s2.writeObject("Second string");                                                        // 5
        System.out.println("String2 written");

    }

    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream((this.fileName));

        while(fis.available() > 0)
            sb.append((char)fis.read());

        String s = sb.toString();
        System.out.println(s);
        this.stream = new FileOutputStream(this.fileName);
        this.stream.write(s.getBytes());
        fis.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}