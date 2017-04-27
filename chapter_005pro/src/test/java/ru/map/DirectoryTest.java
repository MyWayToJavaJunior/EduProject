package ru.map;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/27/2017.
 */
public class DirectoryTest {
    /**
     * Test directory.
     */
    @Test
    public void whenInsertTwoItemsThenOk() {
        Directory<Integer, String> dir = new Directory<>();
        dir.insert(5, "five");
        dir.insert(4, "four");
        dir.insert(6, "six");
        String result = dir.get(4);
        String testData = "four";
        assertThat(result, is(testData));
    }

    /**
     * Test directory.
     */
    @Test
    public void whenDeleteItemThenReturnNull() {
        Directory<Integer, String> dir = new Directory<>();
        dir.insert(5, "five");
        dir.insert(4, "four");
        dir.insert(6, "six");
        dir.delete(4);
        String result = dir.get(4);
        String testData = null;
        assertThat(result, is(testData));
    }
}
