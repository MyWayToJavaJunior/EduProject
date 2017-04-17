package ru.iterators;

import java.util.Iterator;

/**
 * Created by nik on 4/17/2017.
 */
public interface ConvertIterators {
    /**
     * Convert Iterator of Iterators.
     * @param it  - Iterator of Iterators.
     * @return - Iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
