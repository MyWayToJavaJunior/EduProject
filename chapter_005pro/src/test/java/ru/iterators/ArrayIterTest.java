package ru.iterators;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/17/2017.
 */
public class ArrayIterTest {
    /**
     * Test next.
     */
    @Test
    public void whenGetNextThenPointerForward() {
        ArrayIter it = new ArrayIter(new int[][] {{1, 5}, {6, 7}});
        int testData = 5;

        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(testData));
    }

    /**
     * Test hasNext.
     */
    @Test
    public void whenChaeckHasNextThenReturnResult() {
        ArrayIter it = new ArrayIter(new int[][] {{1}});
        boolean testData = false;

        it.next();
        it.hasNext();
        boolean result = it.hasNext();

        assertThat(result, is(testData));
    }
}
