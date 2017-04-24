package ru.set;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/24/2017.
 */
public class SimpleSetQuickTest {
    /**
     * Test quick set with linked list.
     */
    @Test
    public void whenAddSameItemsThenAddedOnlyDifferent() {
        SimpleSetQuick<String> ss = new SimpleSetQuick<>();
        ss.add("first");
        ss.add("second");
        ss.add("first");
        ss.add("first");
        ss.add("second");

        int result = ss.getCount();
        int testData = 2;

        assertThat(result, is(testData));
    }
}
