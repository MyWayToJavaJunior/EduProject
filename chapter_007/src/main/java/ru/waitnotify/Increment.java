package ru.waitnotify;

/**
 * Created by nik on 6/6/2017.
 */
public class Increment {
    /**
     * value.
     */
    private int value = 0;
    /**
     * Locker.
     */
    private SimpleLock lock = new SimpleLock();
    /**
     * increment method.
     */
    public void inc() {
        try {
            lock.lock();
            System.out.println(++value);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
