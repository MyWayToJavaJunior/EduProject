package ru.chess;

/**
 * Created by nik on 3/30/2017.
 */
public class Rook extends Figure {
    /**
     * Constructor of Rook.
     * @param position - position of Rook.
     */
    public Rook(Cell position) {
        super(position);
    }
    /**
     * Get copy of Rook.
     * @param dest - position of Rook.
     * @return - new Rook.
     */
    public Figure clone(Cell dest) {
        return new Rook(dest);
    }
    /**
     * Way of Rook.
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
