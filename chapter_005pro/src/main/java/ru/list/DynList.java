package ru.list;

import ru.generic.SimpleArray;

import java.util.Iterator;

/**
 * Created by nik on 4/19/2017.
 */
public class DynList<T> implements SimpleContainer {

    private Object[] container;
    private int length = 10;
    private int position = 0;

    public DynList() {
        container = new Object[this.length];
    }

    public DynList(int length) {
        this.length = length;
        container = new Object[this.length];
    }

    @Override
    public void add(Object value) {
        container[position++] = value;
    }

    @Override
    public T get(int index) {
        return (T) container[index];
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
