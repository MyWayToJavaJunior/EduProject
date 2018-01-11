package ru.eventcounter;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nikolay on 11/01/18.
 */
public class CounterTest {

    Counter counter = new Counter();

    Runnable r1 = () -> {
        for (int i = 0; i < 100; i++) {
            counter.addEvent("event");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    Runnable r2 = () -> {
        for (int i = 0; i < 1000; i++) {
            counter.addEvent("event");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    Runnable r3 = () -> {
        for (int i = 0; i < 12; i++) {
            counter.addEvent("event");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    @Test
    public void testCounter1() throws Exception {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Assert.assertThat(counter.getCount(TUnit.MIN), Is.is(118L));
        Assert.assertThat(counter.getCount(TUnit.HOUR), Is.is(200L));
        Assert.assertThat(counter.getCount(TUnit.DAY), Is.is(200L));
    }

    @Test
    public void testCounter2() throws Exception {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Assert.assertThat(counter.getCount(TUnit.MIN), Is.is(3L));
        Assert.assertThat(counter.getCount(TUnit.HOUR), Is.is(1112L));
        Assert.assertThat(counter.getCount(TUnit.DAY), Is.is(1112L));
    }

}
