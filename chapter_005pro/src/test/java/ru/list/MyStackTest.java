package ru.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/21/2017.
 */
public class MyStackTest {
    /**
     * Test my Stack.
     */
    @Test
    public void whenAddItemAndGetThenReturnItem() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        Integer result = stack.pop();
        Integer testData = 2;
        assertThat(result, is(testData));
    }

    /**
     * Test my Stack.
     */
    @Test
    public void whenAddItemAndGetThenReturnNull() {
        MyStack<Integer> stack = new MyStack<>();
        Integer result = stack.pop();
        Integer testData = null;
        assertThat(result, is(testData));
    }

    /**
     * Test my Stack.
     */
    @Test
    public void whenAddItemAndGetThenReturnNull1() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.push(4);
        Integer result = stack.pop();
        Integer testData = 4;
        assertThat(result, is(testData));
    }
}
