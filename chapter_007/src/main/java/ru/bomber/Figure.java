package ru.bomber;

/**
 * Created by nik on 6/22/2017.
 */
public abstract class Figure {
    /**
     * Position of figure.
     */
    private Cell position;
    /**
     * board.
     */
    private Board board;
    /**
     * constructor.
     * @param position - position.
     * @param board - board.
     */
    public Figure(Cell position, Board board) {
        this.position = position;
        this.board = board;
        this.board.busy(this.position);
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
     * @param position - position.
     */
    public void setPosition(Cell position) {
        this.position = position;
    }
    /**
     * Getter for board.
     * @return - board.
     */
    public Board getBoard() {
        return board;
    }

}
