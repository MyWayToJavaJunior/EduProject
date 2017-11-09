package ru.set;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/24/2017.
 */
public class SimpleSetQuickTest {
    /**
     * Test quick set with linked list.
     */
    @Test
    public void whenAddSameItemsThenAddedOnlyDifferent() {
        SimpleSetQuick<String> ss = new SimpleSetQuick<>();
        ss.add("first");
        ss.add("second");
        ss.add("first");
        ss.add("first");
        ss.add("second");

        int result = ss.getCount();
        int testData = 2;

        assertThat(result, is(testData));
    }

    /**
     * Test quick set vs set with linked list.
     */
    @Test
    public void whenAddManyItemsThenSpeedIs() {
        SimpleSetQuick<String> ss = new SimpleSetQuick<>();
        SimpleSetWithLinkedList<String> ssll = new SimpleSetWithLinkedList<>();
        SimpleSetWithArrayList<String> ssal = new SimpleSetWithArrayList<>();

        Date start = new Date();
        final Random random = new Random();
        int length = 1000;

        // Quick set fill controller.
        for (int i = 0; i < length; i++) {
            ss.add(Integer.toString(random.nextInt(1000000)));
        }
        Date finish = new Date();
        long resultTimeSs = finish.getTime() - start.getTime();
        System.out.println("Quick set = " + resultTimeSs);

        // Set with linked list fill controller.
        Date start1 = new Date();
        for (int i = 0; i < length; i++) {
            ssll.add(Integer.toString(random.nextInt(1000000)));
        }
        Date finish1 = new Date();
        long resultTimeSsll = finish1.getTime() - start1.getTime();
        System.out.println("Set with LinkedList = " + resultTimeSsll);

        // Set with array list fill controller.
        Date start2 = new Date();
        for (int i = 0; i < length; i++) {
            ssal.add(Integer.toString(random.nextInt(1000000)));
        }
        Date finish2 = new Date();
        long resultTimeSsal = finish2.getTime() - start2.getTime();
        System.out.println("Set with ArrayList = " + resultTimeSsal);
    }
}
