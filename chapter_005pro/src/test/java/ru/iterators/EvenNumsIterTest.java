package ru.iterators;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/17/2017.
 */
public class EvenNumsIterTest {
    /**
     * Test even nums return.
     */
    @Test
    public void whenGetEvenNumsThenReturnNums() {
        EvenNumsIter it = new EvenNumsIter(new int[] {1, 5, 6, 3, 8});
        int testData = 6;

        int result = (Integer) it.next();

        assertThat(result, is(testData));
    }
    /**
     * Test no even nums return.
     */
    @Test
    public void whenGetEvenNumsThenReturnNoRuslt() {
        EvenNumsIter it = new EvenNumsIter(new int[] {1, 5, 7, 3, 9});
        int testData = -1;

        int result = (Integer) it.next();

        assertThat(result, is(testData));
    }
}

