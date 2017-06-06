package ru.waitnotify;

/**
 * Created by nik on 6/6/2017.
 */
public class SimpleLock {
    /**
     * is lockeg flag.
     */
    private boolean isLocked = false;
    /**
     * lock object.
     * @throws InterruptedException - .
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }
    /**
     * unlock object.
     */
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
    /**
     * Test method.
     * @param args - .
     */
    public static void main(String[] args) {
        Increment in = new Increment();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    in.inc();
                }
            }.start();
        }
    }
}
