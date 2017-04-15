package ru.chess;

/**
 * Created by nik on 3/30/2017.
 */
public class Bishop extends Figure {
    /**
     * Constructor of Bishop.
     * @param position - position of Bishop.
     */
    public Bishop(Cell position) {
        super(position);
    }
    /**
     * Get copy of Bishop.
     * @param dest - position of Bishop.
     * @return - new Bishop.
     */
    public Figure clone(Cell dest) {
        return new Bishop(dest);
    }
    /**
     * Way of Bishop.
     * @param dist - position to move.
     * @return array of cells for way.
     */
    public Cell[] way(Cell dist) {
        if ((Math.abs(this.getPosition().getY() - dist.getY()) != Math.abs(this.getPosition().getX() - dist.getX()))) {
            throw new ImposibleMoveException("Imposible to move.");
        }
        return super.way(dist);
    }
}
