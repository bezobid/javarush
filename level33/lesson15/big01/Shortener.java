package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by bezobid on 07.07.2016.
 */
public class Shortener {

    private Long lastId = Long.valueOf(0);
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){

        if (storageStrategy.containsValue(string)){
            return storageStrategy.getKey(string);
        }
        else{
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }
    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }

}
