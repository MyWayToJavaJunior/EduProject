package ru.directory;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/12/2017.
 */
public class DirectoryTest {
    /**
     * Test asc sort.
     */
    @Test
    public void whenListThenAscSortedList() {
        List<String> testData = new ArrayList<>();
        testData.add("K1"); testData.add("K1\\SK1"); testData.add("K1\\SK1\\SSK1"); testData.add("K1\\SK1\\SSK2"); testData.add("K1\\SK2");
        testData.add("K2"); testData.add("K2\\SK1"); testData.add("K2\\SK1\\SSK1"); testData.add("K2\\SK1\\SSK2");
        List<String> list = new ArrayList<>();
        list.add("K2"); list.add("K1\\SK2"); list.add("K1\\SK1"); list.add("K1\\SK1\\SSK1"); list.add("K1\\SK1\\SSK2");
        list.add("K2\\SK1\\SSK1"); list.add("K2\\SK1\\SSK2");
        Directory d = new Directory(list);
        d.sortAsc();
        List<String> result = d.getList();
        assertThat(testData, is(result));
    }

    /**
     * Test desc sort.
     */
    @Test
    public void whenListThenDescSortedList() {
        List<String> testData = new ArrayList<>();
        testData.add("K2"); testData.add("K2\\SK1"); testData.add("K2\\SK1\\SSK2"); testData.add("K2\\SK1\\SSK1");
        testData.add("K1"); testData.add("K1\\SK2"); testData.add("K1\\SK1"); testData.add("K1\\SK1\\SSK2"); testData.add("K1\\SK1\\SSK1");
        List<String> list = new ArrayList<>();
        list.add("K2"); list.add("K1\\SK2"); list.add("K1\\SK1"); list.add("K1\\SK1\\SSK1"); list.add("K1\\SK1\\SSK2");
        list.add("K2\\SK1\\SSK1"); list.add("K2\\SK1\\SSK2");
        Directory d = new Directory(list);
        d.sortDesc();
        List<String> result = d.getList();
        assertThat(testData, is(result));
    }
}
