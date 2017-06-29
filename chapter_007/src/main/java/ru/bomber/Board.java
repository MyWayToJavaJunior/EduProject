package ru.bomber;

import java.util.Random;

/**
 * Created by nik on 6/22/2017.
 */
public class Board {

    private Cell[][] cells;
    private int boardSize;
    private int blocks;

    public Board(int boardSize, int blocks) {
        this.boardSize = boardSize;
        this.blocks = blocks;
        this.cells = new Cell[this.boardSize][this.boardSize];
        init();
    }

    private void init() {
        // init cells
        for(int i = 0; i < this.boardSize; i++) {
            for(int j = 0; j < this.boardSize; j++) {
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

    public int getBoardSize() {
        return boardSize;
    }

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    public boolean checkCell(Cell cell) {
        return this.cells[cell.getX()][ cell.getY()].isEmpty();
    }

    public void busy(Cell cell) {
        if (this.cells[cell.getX()][ cell.getY()].isEmpty()) {
            this.cells[cell.getX()][ cell.getY()].busy();
        }
    }

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

