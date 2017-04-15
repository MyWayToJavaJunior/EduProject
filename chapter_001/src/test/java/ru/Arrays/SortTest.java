package ru.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Sort Array.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class SortTest {
    /**
     * Test sort array.
     */
    @Test
    public void whenArrayLengthIsThreeThenSort() {
		int[] expect = new int[] {1, 2, 3, 4, 5, 6};
		int[] result = new int[] {3, 2, 1, 6, 5, 4};
		Sort s = new Sort();
		s.bubbleSort(result);
		assertThat(result, is(expect));
    }
}