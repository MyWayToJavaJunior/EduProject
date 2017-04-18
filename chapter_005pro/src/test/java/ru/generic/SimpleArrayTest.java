package ru.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/18/2017.
 */
public class SimpleArrayTest {
    /**
     * Test SimpleArray.
     */
    @Test
    public void whenAddToArrayThenGetResult() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(2);
        int testData = 2;
        int result = sa.get(0);

        assertThat(result, is(testData));
    }

    /**
     * Test SimpleArray.
     */
    @Test
    public void whenUpdateItemInArrayThenGetResult() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(2);
        sa.add(4);
        int testData = 10;
        sa.update(0, 10);
        int result = sa.get(0);

        assertThat(result, is(testData));
    }

    /**
     * Test SimpleArray.
     */
    @Test
    public void whenDeleteItemInArrayThenGetResult() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(2);
        sa.add(4);
        int testData = 4;
        sa.delete(2);
        int result = sa.get(0);

        assertThat(result, is(testData));
    }
}
