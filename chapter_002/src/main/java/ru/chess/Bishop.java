package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public class Bishop extends Figure {
    /**
     * Constructor of bishop.
     * @param position - position of bishop.
     */
    public Bishop(Cell position) {
        super(position);
    }
    /**
     * Get copy of bishop.
     * @param dest - position of bishop.
     * @return - new bishop.
     */
    public Figure clone(Cell dest) {
        return new Bishop(dest);
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

        int count = 0;
        int sign = -1;

        if (this.getPosition().getX() == dist.getX()) {
            count = dist.getY() - this.getPosition().getY();
        } else {
            count = dist.getX() - this.getPosition().getX();
        }

        if (count > 0) {
            sign *= -1;
        }

        Cell[] result = new Cell[Math.abs(count)];

        for (int i = 0; i < Math.abs(count); i++) {
            if (this.getPosition().getX() == dist.getX()) {
                result[i] = new Cell(this.getPosition().getX(), (sign * (i + 1)) + this.getPosition().getY());
            } else {
                result[i] = new Cell((sign * (i + 1)) + this.getPosition().getX(), this.getPosition().getY());
            }
        }

        return result;
    }
}
