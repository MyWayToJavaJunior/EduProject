package ru.mergearrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by nik on 6/12/2017.
 */
public class MergeTest {
    /**
     * Test merge 2 lists.
     */
    @Test
    public void whenMerge2ListsThenArrayList() {
        List<Integer> l = Arrays.asList(1, 2, 4, 5, 7);
        List<Integer> list = new ArrayList<>();
        list.addAll(l);
        Merge m = new Merge(list);
        m.merge(Arrays.asList(8, 3, 15, 2));
        List<Integer> result = m.getResult();
        List<Integer> testData = Arrays.asList(1, 2, 2, 3, 4, 5, 7, 8, 15);
        assertThat(testData, is(result));
    }
}
