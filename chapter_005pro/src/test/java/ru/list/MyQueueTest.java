package ru.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/21/2017.
 */
public class MyQueueTest {
    /**
     * Test my Queue.
     */
    @Test
    public void whenAddItemAndGetThenReturnItem() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.poll();
        Integer testData = 2;
        Integer result = queue.poll();
        assertThat(result, is(testData));
    }
}
