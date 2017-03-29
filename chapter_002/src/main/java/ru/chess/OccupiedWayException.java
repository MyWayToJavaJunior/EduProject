package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Constructor.
     * @param msg - message.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
