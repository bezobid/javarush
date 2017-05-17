package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by bezobid on 02.09.2016.
 */
public class FactoryProducer {
    public enum HumanFactoryType{
        FEMALE,
        MALE
    }

    public static AbstractFactory getFactory (HumanFactoryType t){
        if (t == HumanFactoryType.FEMALE) return new FemaleFactory();
        return new MaleFactory();
    }
}
