package ru.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/21/2017.
 */
public class DetectListCycleTest {
    /**
     * Test detection of cycle in linked list.
     */
    @Test
    public void whenListHaveCycleThenReturnTrue() {
        DetectListCycle list = new DetectListCycle();

        DetectListCycle.Node first = new DetectListCycle.Node(1);
        DetectListCycle.Node two = new DetectListCycle.Node(2);
        DetectListCycle.Node third = new DetectListCycle.Node(3);
        DetectListCycle.Node four = new DetectListCycle.Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        boolean result = list.hasCycle(first);
        boolean testData = true;
        assertThat(result, is(testData));
    }

    /**
     * Test detection of cycle in linked list.
     */
    @Test
    public void whenListHaveNotCycleThenReturnTrue() {
        DetectListCycle list = new DetectListCycle();

        DetectListCycle.Node first = new DetectListCycle.Node(1);
        DetectListCycle.Node two = new DetectListCycle.Node(2);
        DetectListCycle.Node third = new DetectListCycle.Node(3);
        DetectListCycle.Node four = new DetectListCycle.Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        //four.setNext(first);

        boolean result = list.hasCycle(first);
        boolean testData = false;
        assertThat(result, is(testData));
    }
}
