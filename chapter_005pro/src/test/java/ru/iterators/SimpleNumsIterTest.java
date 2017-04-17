package ru.iterators;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/17/2017.
 */
public class SimpleNumsIterTest {
    /**
     * Test simple nums.
     */
    @Test
    public void whenGetSimpleNumberThenReturnNumber() {
        SimpleNumsIter it = new SimpleNumsIter(new int[] {1, 5, 6, 3, 8});
        int testData = 3;

        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(testData));
    }
}
