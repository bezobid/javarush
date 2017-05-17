package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by bezobid on 04.07.2016.
 */
public class Test {
    public static void main(String[] args) throws JAXBException {
        Shop shop = new Shop();

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(shop, writer);

        System.out.println(writer.toString());
    }
}
