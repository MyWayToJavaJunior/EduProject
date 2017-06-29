package ru.bomber;

/**
 * Created by nik on 6/22/2017.
 */
public class Hero extends Figure implements Runnable {
    /**
     * constructor.
     * @param position - position.
     * @param board - board.
     */
    public Hero(Cell position, Board board) {
        super(position, board);
    }

    @Override
    public void run() {

    }
}
