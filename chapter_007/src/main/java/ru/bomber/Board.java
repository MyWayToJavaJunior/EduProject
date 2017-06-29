package ru.bomber;

import java.util.Random;

/**
 * Created by nik on 6/22/2017.
 */
public class Board {
    /**
     * Array of cells.
     */
    private Cell[][] cells;
    /**
     * Board size.
     */
    private int boardSize;
    /**
     * Number of blocks.
     */
    private int blocks;
    /**
     * Constructor.
     * @param blocks - number of blocks.
     * @param boardSize - board size.
     */
    public Board(int boardSize, int blocks) {
        this.boardSize = boardSize;
        this.blocks = blocks;
        this.cells = new Cell[this.boardSize][this.boardSize];
        init();
    }
    /**
     * Initialize board.
     */
    private void init() {
        // init cells
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }

        // init blocks
        for (int i = 0; i < this.blocks; i++) {
            Cell cell = cellGenerator();
            this.cells[cell.getX()][cell.getY()].busy();
            System.out.println("Block on " + cell.toString());
        }
    }
    /**
     * Getter board size.
     * @return - size.
     */
    public int getBoardSize() {
        return boardSize;
    }
    /**
     * Getter cell.
     * @param x - x.
     * @param y - y.
     * @return - cell.
     */
    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }
    /**
     * Is cell empty?
     * @param cell - cell.
     * @return - answer.
     */
    public boolean checkCell(Cell cell) {
        return this.cells[cell.getX()][ cell.getY()].isEmpty();
    }
    /**
     * make cell busy.
     * @param cell - cell.
     */
    public void busy(Cell cell) {
        if (this.cells[cell.getX()][ cell.getY()].isEmpty()) {
            this.cells[cell.getX()][ cell.getY()].busy();
        }
    }
    /**
     * make cell free.
     * @param cell - cell.
     */
    public void free(Cell cell) {
        if (!this.cells[cell.getX()][ cell.getY()].isEmpty()) {
            this.cells[cell.getX()][ cell.getY()].empty();
        }
    }

    /**
     * Random cell generator.
     * @return cell.
     */
    private Cell cellGenerator() {
        Random random = new Random();
        Cell cell = null;
        do {
            cell = new Cell(random.nextInt(this.boardSize), random.nextInt(this.boardSize));
            if (this.cells[cell.getX()][cell.getY()].isEmpty()) {
                return cell;
            }
        } while (true);
    }
}

