package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public class Rook extends Figure {
    /**
     * Constructor of bishop.
     * @param position - position of bishop.
     */
    public Rook(Cell position) {
        super(position);
    }
    /**
     * Get copy of bishop.
     * @param dest - position of bishop.
     * @return - new bishop.
     */
    public Figure clone(Cell dest) {
        return new Rook(dest);
    }
    /**
     * Way of bishop.
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
