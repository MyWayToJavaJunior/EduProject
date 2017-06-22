package ru.bomber2;

/**
 * Created by nik on 6/22/2017.
 */
public abstract class Figure {
    private Cell position;
    private Board board;

    public Figure(Cell position, Board board) {
        this.position = position;
        this.board = board;
        this.board.busy(this.position);
    }

    public Cell getPosition() {
        return this.position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Board getBoard() {
        return board;
    }

}
