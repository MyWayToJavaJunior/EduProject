package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Constructor.
     * @param msg - message.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
