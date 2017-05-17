package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by bezobid on 07.09.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable{

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet clone(){
        AmigoSet<E> set;
        try{
            super.clone();
            set = new AmigoSet<>();
            set.map = new HashMap<>(map);
        }catch (Exception e){
            throw new InternalError();
        }
        return set;
    }

    public AmigoSet(Collection<? extends E> collection){
        map = new HashMap<>((int)Math.max(16,collection.size()/.75f));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return (map.keySet().remove(o));
    }

    @Override
    public void clear() {
        map.keySet().clear();
    }

    private void writeObject(ObjectOutputStream oos){

        try {
            oos.defaultWriteObject();
            oos.writeObject(new HashSet<>(map.keySet()));
            oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
            oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){

        try {
            ois.defaultReadObject();
            Set<E> keys = (Set)ois.readObject();
            int capacity = (int)ois.readObject();
            float loadFactor = (float)ois.readObject();

            map = new HashMap<>(capacity, loadFactor);

            for (E key : keys ){
                map.put(key, PRESENT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
