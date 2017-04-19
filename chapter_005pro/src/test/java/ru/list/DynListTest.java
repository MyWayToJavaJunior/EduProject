package ru.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/19/2017.
 */
public class DynListTest {
    /**
     * Test Dyn List.
     */
    @Test
    public void whenAddItemAndGetThenReturnItem() {
        DynList<String> dl = new DynList<>();
        dl.add("Hello");
        dl.add("World");
        String testData = "Hello";

        String result = dl.get(0);
        assertThat(result, is(testData));
    }
}
