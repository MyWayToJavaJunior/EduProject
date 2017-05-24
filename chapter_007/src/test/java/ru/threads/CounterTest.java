package ru.threads;

import org.junit.Test;

/**
 * Created by nik on 5/23/2017.
 */
public class CounterTest {
    /**
     * Test space counter.
     */
    @Test
    public void whenThreadsAreJoinThenPrintByOrder() {
        String s = "Hello  my friend!   ";
        System.out.println("Begin!");
        Thread t1 = new Thread(new Counter.Space(s));
        Thread t2 = new Thread(new Counter.Word(s));
        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End!");
    }

    /**
     * Test space counter.
     */
    @Test
    public void whenThreadisInterruptThenReturnMinusOne() {
        String s = "Hello  my friend!   ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(s);
        }
        Thread t2 = new Thread(new Counter.Word(sb.toString()));
        t2.start();
        Thread.currentThread().interrupt();
    }
}
