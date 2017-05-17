package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bezobid on 19.05.2016.
 */
public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (manipulators.containsKey(currencyCode)){
            return manipulators.get(currencyCode);
        }

        CurrencyManipulator newManipulator = new CurrencyManipulator(currencyCode);
        manipulators.put(currencyCode, newManipulator);
        return newManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        ArrayList<CurrencyManipulator> list = new ArrayList<>();
        for (CurrencyManipulator m : manipulators.values()){
            list.add(m);
        }
        return list;
    }


}
