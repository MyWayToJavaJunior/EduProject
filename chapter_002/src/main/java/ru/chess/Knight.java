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
        return new Bishop(dest);
    }
    /**
     * Way of Knight.
     * @param dist - position to move.
     * @return array of cells for way.
     */
    public Cell[] way(Cell dist) {
        Cell[] result = null;
        if (this.getPosition().getX() + 1 == dist.getX() && this.getPosition().getY() + 2 == dist.getY()) {
            result = fillArray(1, 1, dist);
        } else if (this.getPosition().getX() - 1 == dist.getX() && this.getPosition().getY() + 2 == dist.getY()) {
            result = fillArray(1, -1, dist);
        } else if (this.getPosition().getX() + 1 == dist.getX() && this.getPosition().getY() - 2 == dist.getY()) {
            result = fillArray(-1, 1, dist);
        } else if (this.getPosition().getX() - 1 == dist.getX() && this.getPosition().getY() - 2 == dist.getY()) {
            result = fillArray(-1, -1, dist);
        } else if (this.getPosition().getX() + 2 == dist.getX() && this.getPosition().getY() + 1 == dist.getY()) {
            result = fillArray(1, 1, dist);
        } else if (this.getPosition().getX() + 2 == dist.getX() && this.getPosition().getY() - 1 == dist.getY()) {
            result = fillArray(1, -1, dist);
        } else if (this.getPosition().getX() - 2 == dist.getX() && this.getPosition().getY() + 1 == dist.getY()) {
            result = fillArray(-1, 1, dist);
        } else if (this.getPosition().getX() - 2 == dist.getX() && this.getPosition().getY() - 1 == dist.getY()) {
            result = fillArray(-1, -1, dist);
        } else {
            throw new ImposibleMoveException("Imposible to move.");
        }
        return result;
    }
    /**
     * Fill way array.
     * @param x - sing of x coordinate.
     * @param y - sing of y coordinate.
     * @param dist - position to move.
     * @return array of cells for way.
     */
    private Cell[] fillArray(int x, int y, Cell dist) {
        Cell[] result = new Cell[3];
        if (Math.abs(this.getPosition().getY() - dist.getY()) == 2) {
            result[0] = new Cell(this.getPosition().getX(), this.getPosition().getY() + 1 * (x));
            result[1] = new Cell(this.getPosition().getX(), this.getPosition().getY() + 2 * (x));
            result[2] = new Cell(this.getPosition().getX() + 1 * (y), this.getPosition().getY() + 2 * (x));
        } else {
            result[0] = new Cell(this.getPosition().getX() + 1 * (x), this.getPosition().getY());
            result[1] = new Cell(this.getPosition().getX() + 2 * (x), this.getPosition().getY());
            result[2] = new Cell(this.getPosition().getX() + 2 * (x), this.getPosition().getY() + 1 * (y));
        }
        return result;
    }
}
