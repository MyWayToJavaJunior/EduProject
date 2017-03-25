package ru.tracker;

/**
 * Created by nik on 3/24/2017.
 */
public class MenuOutException extends RuntimeException {
    /**
     * Constructor.
     * @param msg - message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
