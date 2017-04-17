package ru.iterators;

import java.util.Iterator;

/**
 * Created by nik on 4/17/2017.
 */
public class SimpleNumsIter implements Iterator {
    /**
     * Array of nums.
     */
    private final int[] array;
    /**
     * Index of array.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param array - array of nums.
     */
    public SimpleNumsIter(int[] array) {
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
            if (simpleNumTest(array[index])) {
                result = array[index++];
                break;
            }
        }
        return result;
    }

    /**
     * Test for number to simple.
     * @param num - number to check.
     * @return - is number simple.
     */
    private boolean simpleNumTest(int num) {
        if (num < 2) {
            return false;
        }

        boolean result = true;

        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0 && num != 2) {
                result = false;
                break;
            }
        }

        return result;
    }
}
