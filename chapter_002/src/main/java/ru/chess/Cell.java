package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */
public class Cell {
    /**
     * x coordinate.
     */
    private int x;
    /**
     * y coordinate.
     */
    private int y;
    /**
     * Constructor of cell.
     * @param x - x coordinate.
     * @param y - y coordinate.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * x getter.
     * @return x.
     */
    public int getX() {
        return this.x;
    }
    /**
     * y getter.
     * @return y.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Equals of 2 cell.
     * @param obj - cell to equals.
     * @return is equals?.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        Cell cell = (Cell) obj;
        if (this.getX() == cell.getX() && this.getY() == cell.getY()) {
            result = true;
        }
        return result;
    }
    /**
     * Hashcode.
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
