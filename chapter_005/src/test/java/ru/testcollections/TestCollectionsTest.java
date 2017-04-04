package ru.testcollections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by nik on 4/4/2017.
 */
public class TestCollectionsTest {
    /**
     * Test collections speed.
     */
    @Test
    public void whenCollectionsSpeedTestThenResult() {
        TestCollections test = new TestCollections();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println("Add operation: ");
        System.out.println("LinkedList = " + test.add(linkedList, "Hello world!", 3000000) + " msec.");
        System.out.println("ArrayList = " + test.add(arrayList, "Hello world!", 3000000) + " msec.");
        System.out.println("TreeSet = " + test.add(treeSet, "Hello world!", 3000000) + " msec.\n");

        System.out.println("Delete operation: ");
        System.out.println("ArrayList = " + test.delete(arrayList, 200) + " msec.");
        System.out.println("LinkedList = " + test.delete(linkedList, 2000000) + " msec.");
        System.out.println("TreeSet = " + test.delete(treeSet, 2000000) + " msec.");
    }
}
