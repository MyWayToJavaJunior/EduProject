package ru.map;

import java.util.Iterator;

/**
 * Created by nik on 4/26/2017.
 * @param <T> - type of key.
 * @param <V> - type of value.
 */
public class Directory<T, V> implements IDirectory<T, V> {
    /**
     * Node of direction.
     * @param <T> - type of key.
     * @param <V> - type of value.
     */
    class Node<T, V> {
        /**
         * Key.
         */
        private T key;
        /**
         * Value.
         */
        private V value;
        /**
         * Constructor.
         * @param key - key.
         * @param value - value.
         */
        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    /**
     * length of array.
     */
    private int length = 10000;
    /**
     * Array of nodes.
     */
    private Node[] array = new Node[this.length];

    @Override
    public boolean insert(T key, V value) {
        int index = key.hashCode() % array.length;
        if (array[index] == null) {
            array[index] = new Node(key, value);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public V get(T key) {
        int index = key.hashCode() % array.length;
        if (array[index] != null) {
            return (V) array[index].value;
        }
        return null;

    }

    @Override
    public boolean delete(T key) {
        int index = key.hashCode() % array.length;
        if (array[index] != null) {
            array[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            /**
             * counter.
             */
            private int counter = 0;

            @Override
            public boolean hasNext() {
                for (; counter < length; counter++) {
                    if (array[counter] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public V next() {
                int tmp = counter;
                for (; counter < length; counter++) {
                    if (array[counter] != null) {
                        break;
                    }
                }
                return (V) array[tmp];
            }
        };
    }
}
