package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public class ImposibleMoveException extends RuntimeException {
    /**
     * Constructor.
     * @param msg - message.
     */
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}
