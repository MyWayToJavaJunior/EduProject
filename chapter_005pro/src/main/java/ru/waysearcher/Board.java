package ru.waysearcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nik on 5/22/2017.
 */
public class Board {
    /**
     * Array of blocks.
     */
    private List<Cell> blocks;
    /**
     * Size of array.
     */
    private int size;
    /**
     * Start cell.
     */
    private Cell src;
    /**
     * Finish cell.
     */
    private Cell dest;
    /**
     * Cells who have 2 ways.
     */
    private Stack<Cell> cross;
    /**
     * REsult way.
     */
    private List<Cell> way;
    /**
     * Constructor.
     * @param blocks -
     * @param dest -
     * @param size -
     * @param src -
     */
    public Board(List<Cell> blocks, int size, Cell src, Cell dest) {
        this.blocks = blocks;
        this.size = size;
        this.src = src;
        this.dest = dest;
    }
    /**
     * Can i go to this cell?.
     * @param c - cell for test.
     * @return - result.
     */
    private boolean canIGo(Cell c) {
        if (c.getX() >= this.size || c.getY() >= this.size || blocks.contains(c)) {
            return false;
        }
        return true;
    }
    /**
     * Logic method.
     * @return array of way.
     */
    public List<Cell> go() {
        cross = new Stack<>();
        way = new ArrayList<>();
        Cell tmp;
        while (!this.src.equals(this.dest)) {
            if (canIGo(new Cell(this.src.getX(), this.src.getY() + 1)) && canIGo(new Cell(this.src.getX() + 1, this.src.getY()))) {
                tmp = new Cell(this.src.getX(), this.src.getY());
                cross.push(tmp);
                way.add(tmp);
                this.src.setY(this.src.getY() + 1);
            } else if (canIGo(new Cell(this.src.getX() + 1, this.src.getY()))) {
                tmp = new Cell(this.src.getX(), this.src.getY());
                way.add(tmp);
                this.src.setX(this.src.getX() + 1);
            } else if (canIGo(new Cell(this.src.getX(), this.src.getY() + 1))) {
                tmp = new Cell(this.src.getX(), this.src.getY());
                way.add(tmp);
                this.src.setY(this.src.getY() + 1);
            } else if (cross.size() != 0) {
                this.src = cross.peek();
                int index = this.way.indexOf(this.src);
                this.way = this.way.subList(0, index + 1);
                this.src = new Cell(this.src.getX() + 1, this.src.getY());
            } else {
                break;
            }
        }

        return way;
    }
}
