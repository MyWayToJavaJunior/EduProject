package ru.iterators;

import java.util.Iterator;

/**
 * Created by nik on 4/17/2017.
 */
public class EvenNumsIter implements Iterator {
    /**
     * Array of nums.
     */
    private final int[] array;
    /**
     * Index of array.
     */
    private int index = 0;

    /**
     * Construnctor.
     * @param array - array of nums.
     */
    public EvenNumsIter(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public Object next() {
        int result = -1;
        for (; index < array.length; index++) {
            if (array[index] % 2 == 0) {
                result = array[index];
                break;
            }
        }
        return result;
    }
}
