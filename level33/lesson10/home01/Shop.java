package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bezobid on 04.07.2016.
 */

@XmlType(name="shop")
@XmlRootElement
public class Shop {

    public Shop() {
    }

    @XmlElementWrapper(name="goods", nillable = true)
    List<String> names;

    @XmlElement(name = "count")
    int count = 12;

    @XmlElement(name = "profit")
    double profit = 123.4;


    @XmlElement(name = "secretData")
    List<String> secretData;

    {
        names = new ArrayList<>();
        secretData = new ArrayList<>();
        secretData.add("String1");
        secretData.add("String2");
        secretData.add("String3");
        secretData.add("String4");
        secretData.add("String5");
        names.add("S1");
        names.add("S2");
    }



}
