package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        public void writeExternal(ObjectOutput oo)
        {
            try {
                oo.writeObject(address);
                oo.writeInt(year);
            } catch (IOException e){}
        }

        public void readExternal(ObjectInput oi)
        {
            try {
                address = (String) oi.readObject();
                year = oi.readInt();
            } catch (Exception e){}
        }

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }
}
