package ru.chess;

/**
 * Created by nik on 3/30/2017.
 */
public class King extends Figure {
    /**
     * Constructor.
     * @param position - position of king.
     */
    public King(Cell position) {
        super(position);
    }

    /**
     * Way of figure.
     * @param dist - position to move.
     * @return array of cells for way.
     * @throws ImposibleMoveException - imposible to move.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] cell = super.way(dist);
        if (cell.length > 1) {
            throw new ImposibleMoveException("Imposible to move.");
        }
        return cell;
    }
    /**
     * copy of figure.
     * @param dest - new position.
     * @return new figure.
     */
    public Figure clone(Cell dest) {
        return new King(dest);
    }
}
