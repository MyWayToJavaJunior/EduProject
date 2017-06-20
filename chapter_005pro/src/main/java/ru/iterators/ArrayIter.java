package ru.iterators;

import java.util.Iterator;

/**
 * Created by nik on 4/17/2017.
 */
public class ArrayIter implements Iterator {
    /**
     * Array for iteration.
     */
    private final int[][] array;
    /**
     * Y index of current array element.
     */
    private int index1 = 0;
    /**
     * X index of current array element.
     */
    private int index2 = 0;
    /**
     * Constructor.
     * @param array - array for iteration.
     */
    public ArrayIter(final int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length * array[0].length >= (index1 + 1) * (index2 + 1);
    }

    @Override
    public Object next() {
        if (index2 == array[0].length) {
            index1++;
            index2 = 0;
        }
        int result = array[index1][index2++];
        return result;
    }
}
