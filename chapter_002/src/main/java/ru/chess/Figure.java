package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public abstract class Figure {
    /**
     * Position of figure.
     */
    private final Cell position;
    /**
     * getter position.
     * @return position of figure.
     */
    public Cell getPosition() {
        return this.position;
    }
    /**
     * Constructor of figure.
     * @param position - position of figure.
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Way of figure.
     * @param dist - position to move.
     * @return array of cells for way.
     * @throws ImposibleMoveException - imposible to move.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        if ((this.getPosition().getX() != dist.getX() && this.getPosition().getY() != dist.getY())
                && (Math.abs(this.getPosition().getY() - dist.getY()) != Math.abs(this.getPosition().getX() - dist.getX()))) {
            throw new ImposibleMoveException("Imposible to move.");
        }

        int count = 0;
        int sign = -1;
        int xSub = dist.getX() - this.getPosition().getX();
        int ySub = dist.getY() - this.getPosition().getY();

        if (this.getPosition().getX() == dist.getX()
                || (Math.abs(xSub) - Math.abs(ySub)) == 0) {
            count = dist.getY() - this.getPosition().getY();
        } else {
            count = dist.getX() - this.getPosition().getX();
        }

        if (count > 0) {
            sign *= -1;
        }

        Cell[] result = new Cell[Math.abs(count)];

        if ((Math.abs(xSub) - Math.abs(ySub)) == 0) {
            for (int i = 0; i < Math.abs(count); i++) {
                if (xSub > 0 && ySub > 0) {
                    result[i] = new Cell(this.getPosition().getX() + (i + 1), this.getPosition().getY() + (i + 1));
                } else if (xSub > 0 && ySub < 0) {
                    result[i] = new Cell(this.getPosition().getX() + (i + 1), this.getPosition().getY() - (i + 1));
                } else if (xSub < 0 && ySub > 0) {
                    result[i] = new Cell(this.getPosition().getX() - (i + 1), this.getPosition().getY() + (i + 1));
                } else if (xSub < 0 && ySub < 0) {
                    result[i] = new Cell(this.getPosition().getX() - (i + 1), this.getPosition().getY() - (i + 1));
                }

            }
        } else {
            for (int i = 0; i < Math.abs(count); i++) {
                if (this.getPosition().getX() == dist.getX()) {
                    result[i] = new Cell(this.getPosition().getX(), (sign * (i + 1)) + this.getPosition().getY());
                } else {
                    result[i] = new Cell((sign * (i + 1)) + this.getPosition().getX(), this.getPosition().getY());
                }
            }
        }
        return result;
    }
    /**
     * copy of figure.
     * @param dest - new position.
     * @return new figure.
     */
    abstract Figure clone(Cell dest);
}
