package ru.testcollections;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by nik on 4/4/2017.
 */
public class TestCollectionsTest {

    private TestCollections test = new TestCollections();
    private ArrayList<String> arrayList = new ArrayList<>();
    private LinkedList<String> linkedList = new LinkedList<>();
    private TreeSet<String> treeSet = new TreeSet<>();

    /**
     * Test collections speed.
     */
    @Test
    public void whenCollectionsSpeedTestThenResult() {

        System.out.println("Add operation: ");
        System.out.println("LinkedList = " + test.add(linkedList, 300000) + " msec.");
        System.out.println("ArrayList = " + test.add(arrayList, 300000) + " msec.");
        System.out.println("TreeSet = " + test.add(treeSet, 300000) + " msec.\n");

//        System.out.println("Delete operation: ");
//        System.out.println("LinkedList = " + controller.delete(linkedList, 2000000) + " msec.");
//        System.out.println("TreeSet = " + controller.delete(treeSet, 2000000) + " msec.");
//        System.out.println("ArrayList = " + controller.delete(arrayList, 2000000) + " msec.");
    }
}
