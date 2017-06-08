package ru.bomberman;

/**
 * Created by nik on 6/8/2017.
 */
public class Cell {
    /**
     * X.
     */
    private final int x;
    /**
     * Y.
     */
    private final int y;
    /**
     * Constructor.
     * @param x - x.
     * @param y - y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * getter for x.
     * @return x.
     */
    public int getX() {
        return x;
    }
    /**
     * getter for y.
     * @return y.
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;

        if (x != cell.x) {
            return false;
        }
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
