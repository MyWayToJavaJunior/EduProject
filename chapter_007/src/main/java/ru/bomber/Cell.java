package ru.bomber;

/**
 * Created by nik on 6/22/2017.
 */
public class Cell {
    /**
     * x coordinate.
     */
    private final int x;
    /**
     * y coordinate.
     */
    private final int y;
    /**
     * is cell empty.
     */
    private boolean empty;
    /**
     * constructor.
     * @param x - x.
     * @param y - y.
     */
    public Cell(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.empty = true;
    }
    /**
     * is empty.
     * @return - result.
     */
    public boolean isEmpty() {
        return this.empty;
    }
    /**
     * empty cell.
     */
    public void empty() {
        this.empty = true;
    }
    /**
     * busy cell.
     */
    public void busy() {
        this.empty = false;
    }
    /**
     * Getter for x.
     * @return - x.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Getter for y.
     * @return - y.
     */
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
