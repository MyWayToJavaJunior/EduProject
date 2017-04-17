package ru.iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/17/2017.
 */
public class ConverterItersTest {
    /**
     * Convert iterator of iterators.
     */
    @Test
    public void whenSetIteratorOfIteratorsThenIterator() {
        Iterator<Integer> it1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> it2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> it3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2, it3).iterator();
        Iterator<Integer> testData = Arrays.asList(4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();

        ConverterIters iter = new ConverterIters();
        Iterator<Integer> result = iter.convert(it);

        while (result.hasNext()) {
            assertThat(result.next(), is(testData.next()));
        }
    }
}
