package ru.nonblockingalgo;

/**
 * Created by nik on 6/7/2017.
 */
public class OplimisticException extends RuntimeException {
    /**
     * Constructor.
     * @param message - message.
     */
    public OplimisticException(String message) {
        super(message);
    }
}
