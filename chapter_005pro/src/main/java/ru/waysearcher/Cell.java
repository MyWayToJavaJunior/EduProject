package ru.waysearcher;

/**
 * Created by nik on 5/22/2017.
 */
public class Cell {
    /**
     * Coordinate x.
     */
    private int x;
    /**
     * Coordinate y.
     */
    private int y;
    /**
     * Constructor.
     * @param x -
     * @param y -
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * x getter.
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * x setter.
     * @param x -
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * y getter.
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * y setter.
     * @param y -
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Cell o = (Cell) obj;

        if (this.x == o.x && this.y == o.y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Cell " + "x = " + x + ", y = " + y;
    }
}
