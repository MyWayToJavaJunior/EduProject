package ru.bomber2;

/**
 * Created by nik on 6/22/2017.
 */
public class Cell {
    private final int x;
    private final int y;
    private boolean empty;

    public Cell(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.empty = true;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public void empty() {
        this.empty = true;
    }

    public void busy() {
        this.empty = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "x=" + x +", y=" + y;
    }
}
