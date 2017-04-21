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

    /**
     * Test Linked List.
     */
    @Test
    public void whenAddItemAndRemoveThenReturnItem() {
        LinkList<String> dl = new LinkList<>();
        dl.add("1");
        dl.add("2");
        dl.get(1);
        dl.remove(1);
        dl.add("3");
        dl.get(1);
        dl.remove(1);
        dl.get(0);
        dl.remove(0);
        dl.add("4");
        dl.add("5");
        String testData = "4";
        String result = dl.get(0);
        assertThat(result, is(testData));
    }

    /**
     * Test Linked List.
     */
    @Test
    public void whenAddItemAndRemoveThenReturnItem1() {
        LinkList<String> dl = new LinkList<>();
        dl.add("1");
        dl.add("2");
        dl.remove(0);
        String testData = "2";
        String result = dl.get(0);
        assertThat(result, is(testData));
    }
}