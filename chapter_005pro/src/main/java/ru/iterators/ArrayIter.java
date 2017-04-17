package ru.iterators;

import java.util.Iterator;

/**
 * Created by nik on 4/17/2017.
 */
public class ArrayIter implements Iterator {
    /**
     * Array for iteration.
     */
    private final int[] array;
    /**
     * Index of current array element.
     */
    private int index = 0;
    /**
     * Constructor.
     * @param array - array for iteration.
     */
    public ArrayIter(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public Object next() {
        return array[index++];
    }
}
