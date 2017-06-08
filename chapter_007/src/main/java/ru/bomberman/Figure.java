package ru.bomberman;

/**
 * Created by nik on 6/8/2017.
 */
public abstract class Figure {
    /**
     * Figure`s position.
     */
    private Cell position;
    /**
     * Constructor.
     * @param position - position.
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Getter for position.
     * @return - position.
     */
    public Cell getPosition() {
        return this.position;
    }
    /**
     * Setter for position.
     * @param cell - position.
     */
    public void setPosition(Cell cell) {
        this.position = cell;
    }
}
