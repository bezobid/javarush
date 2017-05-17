package com.javarush.test.level26.lesson08.task03;

/* Распределение элементов по корзинам с собственным локом.
В синхронизированных блоках используйте нужный лок.
*/
public class Solution1 {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] nodes;
    private final Object[] objects;

    private static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution1(int numberBuckets) {
        nodes = new Node[numberBuckets];
        objects = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            objects[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % nodes.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (this) {
            for (Node m = nodes[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < nodes.length; i++) {
            synchronized (this) {
                nodes[i] = null;
            }
        }
    }
}
