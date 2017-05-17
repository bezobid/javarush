package com.javarush.test.mytests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bezobid on 05.07.2016.
 */
public class Idea {
    public static void main(String[] args) throws IOException {

        Pet cat = new Cat("Murzik", 5, true);
        Pet dog = new Dog("Sharik", 4, false);

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        House house = new House();
        house.pets = pets;

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        System.out.println(writer.toString());

        StringReader reader = new StringReader(writer.toString());
        House restoredHouse = mapper.readValue(reader, House.class);

        List<Pet> list = restoredHouse.pets;
        for (Pet pet : list) {
            System.out.printf("%s is %d and he is ", pet.name, pet.age);

            if (pet instanceof Cat) {
                Cat pet1 = (Cat) pet;
                System.out.println(pet1.cute ? "cute" : "not so cute");
            }
            else if (pet instanceof Dog) {
                Dog pet1 = (Dog) pet;
                System.out.println(pet1.evil ? "evil" : "adorable");
            }
        }
     }

    @JsonAutoDetect
    static class House{
        public List<Pet> pets = new ArrayList<>();
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value=Cat.class, name="cat"),
            @JsonSubTypes.Type(value=Dog.class, name="dog")
    })
    static class Pet{
        public Pet() {
        }

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String name;
        public int age;
    }

    static class Cat extends Pet{
        public Cat() {
        }

        public Cat(String name, int age, boolean cute) {
            super(name, age);
            this.cute = cute;
        }

        public boolean cute;
    }

    static class Dog extends Pet{
        public Dog() {
        }

        public Dog(String name, int age, boolean evil) {
            super(name, age);
            this.evil = evil;
        }

        public boolean evil;
    }
}
