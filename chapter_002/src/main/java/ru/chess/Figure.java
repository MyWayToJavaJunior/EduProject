package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public abstract class Figure {
    /**
     * Position of figure.
     */
    private final Cell position;
    /**
     * getter position.
     * @return position of figure.
     */
    public Cell getPosition() {
        return this.position;
    }
    /**
     * Constructor of figure.
     * @param position - position of figure.
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Way of figure.
     * @param dist - position to move.
     * @return array of cells for way.
     * @throws ImposibleMoveException - imposible to move.
     */
    abstract Cell[] way(Cell dist) throws ImposibleMoveException;
    /**
     * copy of figure.
     * @param dest - new position.
     * @return new figure.
     */
    public abstract Figure clone(Cell dest);
}
