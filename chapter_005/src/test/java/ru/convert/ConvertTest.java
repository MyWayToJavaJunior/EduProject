package ru.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/5/2017.
 */
public class ConvertTest {
    /**
     * Test convert array to arrayList.
     */
    @Test
    public void whenArrayThenArrayList() {
        Convert conv = new Convert();
        List<Integer> testData = new ArrayList<>();
        testData.add(1); testData.add(2); testData.add(3); testData.add(4); testData.add(5); testData.add(6);
        int[][] mas = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> result = conv.toList(mas);
        assertThat(testData, is(result));
    }

    /**
     * Test convert arrayList to array.
     */
    @Test
    public void whenArrayListThenArray() {
        Convert conv = new Convert();
        int[][] testData = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6); list.add(7);
        int[][] result = conv.toArray(list, 3);
        assertThat(testData, is(result));
    }
}
