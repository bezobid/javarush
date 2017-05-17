package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {

        V v = cache.get(key);
        if (v != null) return v;

        Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
        v = constructor.newInstance(key);
        cache.put(key, v);

        return cache.get(key);
    }

    public boolean put(V obj) {
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            K key = (K) getKey.invoke(obj);
            cache.put(key, obj);
            return true;

        } catch (Exception e) {
        }

        return false;
    }

    public int size() {
        return cache.size();
    }
}
