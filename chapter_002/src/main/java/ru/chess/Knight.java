package ru.chess;

/**
 * Created by nik on 3/30/2017.
 */
public class Knight extends Figure {
    /**
     * Constructor of Knight.
     * @param position - position of bishop.
     */
    public Knight(Cell position) {
        super(position);
    }
    /**
     * Get copy of Knight.
     * @param dest - position of Knight.
     * @return - new Knight.
     */
    public Figure clone(Cell dest) {
        return new Rook(dest);
    }
    /**
     * Way of Knight.
     * @param dist - position to move.
     * @return array of cells for way.
     */
    public Cell[] way(Cell dist) {
        Cell[] result = null;
        if ((Math.abs(this.getPosition().getX() - dist.getX()) == 2 && Math.abs(this.getPosition().getY() - dist.getY()) == 1)
            || (Math.abs(this.getPosition().getX() - dist.getX()) == 1 && Math.abs(this.getPosition().getY() - dist.getY()) == 2)) {
            result = new Cell[] {new Cell(dist.getX(), dist.getY())};
        } else {
            throw new ImposibleMoveException("Imposible to move.");
        }
        return result;
    }
}
