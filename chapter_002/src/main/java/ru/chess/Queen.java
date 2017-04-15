package ru.chess;

/**
 * Created by nik on 3/30/2017.
 */
public class Queen extends Figure {
    /**
     * Constructor.
     * @param position - position of queen.
     */
    public Queen(Cell position) {
        super(position);
    }

    /**
     * Way of figure.
     * @param dist - position to move.
     * @return array of cells for way.
     * @throws ImposibleMoveException - imposible to move.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        return super.way(dist);
    }
    /**
     * copy of figure.
     * @param dest - new position.
     * @return new figure.
     */
    public Figure clone(Cell dest) {
        return new Queen(dest);
    }
}
