package ru.set;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/22/2017.
 */
public class SimpleSetTest {
    /**
     * Test Linked List.
     */
    @Test
    public void whenAddSameItemsThenAddedOnlyDifferent() {
        SimpleSet<String> ss = new SimpleSet<>();
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
