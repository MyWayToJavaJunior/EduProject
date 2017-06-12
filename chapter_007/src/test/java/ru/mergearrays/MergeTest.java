package ru.mergearrays;

import org.junit.Test;
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
        Merge merge = new Merge();
        List<Integer> ar1 = Arrays.asList(1, 5, 9, 5, 3);
        List<Integer> ar2 = Arrays.asList(4, 7, 2, 6, 8, 10, 12, 14);
        List<Integer> result = merge.merge(ar1, ar2);
        List<Integer> testData = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14);
        assertThat(testData, is(result));
    }
}
