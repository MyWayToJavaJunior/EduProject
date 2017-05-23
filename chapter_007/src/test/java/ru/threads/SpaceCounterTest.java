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
        new Thread(new SpaceCounter.Space(s)).start();
        new Thread(new SpaceCounter.Word(s)).start();
    }
}
