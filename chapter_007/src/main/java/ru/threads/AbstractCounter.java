package ru.threads;

/**
 * Created by nik on 5/23/2017.
 */
public abstract class AbstractCounter implements Runnable {
    /**
     * Text array.
     */
    private char[] text;
    /**
     * Current time.
     */
    private long curTime = System.currentTimeMillis();
    /**
     * Getter for text.
     * @return - text.
     */
    public char[] getText() {
        return text;
    }
    /**
     * Getter for time.
     * @return - time.
     */
    public long getCurTime() {
        return curTime;
    }

    /**
     * Constructor.
     * @param text - text for count.
     */
    public AbstractCounter(String text) {
        this.text = text.toCharArray();
    }
    /**
     * Counter.
     * @return - number of spaces.
     * @throws InterruptedException - .
     */
    abstract int counter() throws InterruptedException;
}
