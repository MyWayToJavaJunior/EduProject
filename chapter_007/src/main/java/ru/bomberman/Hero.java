package ru.bomberman;

/**
 * Created by nik on 6/8/2017.
 */
public class Hero extends Figure {
    /**
     * Constructor.
     * @param position - position.
     */
    public Hero(Cell position) {
        super(position);
    }
    /**
     * Go to up.
     * @return cell.
     */
    public Cell goUp() {
        return new Cell(this.getPosition().getX() + 1, this.getPosition().getY());
    }
    /**
     * Go to down.
     * @return cell.
     */
    public Cell goDown() {
        return new Cell(this.getPosition().getX() - 1, this.getPosition().getY());
    }
    /**
     * Go to left.
     * @return cell.
     */
    public Cell goLeft() {
        return new Cell(this.getPosition().getX(), this.getPosition().getY() - 1);
    }
    /**
     * Go to right.
     * @return cell.
     */
    public Cell goRight() {
        return new Cell(this.getPosition().getX(), this.getPosition().getY() + 1);
    }
}
