package ru.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/20/2017.
 */
public class LinkListTest {
    /**
     * Test Linked List.
     */
    @Test
    public void whenAddItemAndGetThenReturnItem() {
        LinkList<String> dl = new LinkList<>();
        dl.add("Hello");
        dl.add("World");
        String testData = "Hello";
        String result = dl.get(0);
        assertThat(result, is(testData));
    }
}