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
     * Getter for text.
     * @return - text.
     */
    public char[] getText() {
        return text;
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
     */
    abstract int counter();
}
