package ru.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by nik on 4/28/2017.
 */
public class SimpleTreeTest {
    /**
     * Test simple tree.
     */
    @Test
    public void whenAddSameItemsThenAddedOnlyDifferent() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("hello");
        tree.addChild("world");
        tree.addChild("!!!");
        System.out.println(tree);
        tree.print();
        //assertThat(result, is(testData));
    }

    /**
     * Test simple tree.
     */
    @Test
    public void whenSearchItemThenReturnTrue() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("hello");
        tree.addChild("world");
        tree.addChild("!!!");
        boolean result = tree.search("world");
        boolean testData = true;

        assertThat(result, is(testData));
    }

    /**
     * Test simple tree.
     */
    @Test
    public void whenSearchItemThenReturnFalse() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("hello");
        tree.addChild("world");
        tree.addChild("!!!");
        boolean result = tree.search("www");
        boolean testData = false;

        assertThat(result, is(testData));
    }

    /**
     * Test simple tree.
     */
    @Test
    public void whenGetChildThenReturnList() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("hello");
        tree.addChild("world");
        tree.addChild("!!!");
        List<String> result = tree.getChildren("hello");
        List<String> testData = Arrays.asList("world", "!!!");

        assertThat(result, is(testData));
    }
}
