package ru.chess;

/**
 * Created by nik on 3/30/2017.
 */
public class Pawn extends Figure {
    /**
     * Constructor.
     * @param position - position of pawn.
     */
    public Pawn(Cell position) {
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
        if (cell.length != 2 || cell[1].getX() != dist.getX() || (this.getPosition().getY() + 2) != dist.getY()) {
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
        return new Pawn(dest);
    }
}
