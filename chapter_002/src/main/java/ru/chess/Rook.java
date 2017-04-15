package ru.chess;

/**
 * Created by nik on 3/26/2017.
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
        if (this.getPosition().getX() != dist.getX() && this.getPosition().getY() != dist.getY()) {
            throw new ImposibleMoveException("Imposible to move.");
        }
        return super.way(dist);
    }
}
