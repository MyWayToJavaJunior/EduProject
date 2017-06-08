package ru.bomberman;

import java.util.Random;

/**
 * Created by nik on 6/8/2017.
 */
public class Monster extends Figure {
    /**
     * Size of the board.
     */
    private int boardSize;
    /**
     * Constructor.
     * @param position - position.
     * @param boardSize - board size.
     */
    public Monster(Cell position, int boardSize) {
        super(position);
        this.boardSize = boardSize;
    }
    /**
     * Move to cell.
     * @return cell.
     */
    public Cell move() {
        Random rand = new Random();
        Cell cell = this.getPosition();
        int sing = rand.nextInt(2);
        int direct = rand.nextInt(2);
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        if (sing == 0 && direct == 0 && x + 1 < this.boardSize - 1) {
            cell = new Cell(x + 1, y);
        } else if (sing == 1 && direct == 0 && x - 1 > 0) {
            cell = new Cell(x - 1, y);
        } else if (sing == 0 && direct == 1 && y + 1 < this.boardSize - 1) {
            cell = new Cell(x, y + 1);
        } else if (sing == 1 && direct == 1 && y - 1 > 0) {
            cell = new Cell(x, y - 1);
        }
        System.out.println(Thread.currentThread().getName() + " move to = " + this.getPosition());
        return cell;
    }
}
