package ru.list;

import java.util.Iterator;

/**
 * Created by nik on 4/19/2017.
 * @param <T> - type.
 */
public class DynList<T> implements SimpleContainer {
    /**
     * Array of items.
     */
    private Object[] container;
    /**
     * Length of array.
     */
    private int length = 10;
    /**
     * Position of current item.
     */
    private int position = 0;

    /**
     * Constructor without parameters.
     */
    public DynList() {
        container = new Object[this.length];
    }

    /**
     * Constructor.
     * @param length - length of new list.
     */
    public DynList(int length) {
        this.length = length;
        container = new Object[this.length];
    }

    /**
     * Make expand if need.
     */
    private void makeExpand() {
        this.length *= 2;
        Object[] tmpArray = new Object[this.length];
        System.arraycopy(this.container, 0, tmpArray, 0, container.length);
        container = tmpArray;
        tmpArray = null;
    }

    @Override
    public void add(Object value) {
        if (this.position == this.length - 1) {
            makeExpand();
        }
        container[position++] = value;
    }

    @Override
    public T get(int index) {
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return this.position < length;
            }

            @Override
            public T next() {
                return (T) container[this.position++];
            }
        };
    }
}
