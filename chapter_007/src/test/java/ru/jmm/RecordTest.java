package ru.jmm;

import org.junit.Test;

/**
 * Created by nik on 5/24/2017.
 */
public class RecordTest {
    /**
     * Test problems with threads.
     */
    @Test
    public void whenThreadsAreNotSyncThenProblems() {
        Record r = new Record();

        Runnable rnb = () -> {
            r.writer();
        };

// UNcomment for controller.
//        for (int i = 0; i < 500; i++) {
//            new Thread(rnb).start();
//            new Thread(rnb).start();
//            new Thread(rnb).start();
//            new Thread(rnb).start();
//            new Thread(rnb).start();
//            new Thread(rnb).start();
//        }

    }
}
