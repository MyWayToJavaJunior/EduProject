package ru.threads;

import org.junit.Test;

/**
 * Created by nik on 5/23/2017.
 */
public class SpaceCounterTest {
    /**
     * Test space counter.
     */
    @Test
    public void whenSomeBlocksThenFindTheWay() {
        String s = "Hello  my friend!   ";
        System.out.println("Begin!");
        Thread t1 = new Thread(new SpaceCounter.Space(s));
        Thread t2 = new Thread(new SpaceCounter.Word(s));
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
}
