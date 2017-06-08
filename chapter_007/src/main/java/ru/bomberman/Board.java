package ru.bomberman;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by nik on 6/8/2017.
 */
public class Board {
    /**
     * List of blocks.
     */
    private List<Figure> board = new LinkedList<>();
    /**
     * number of mosters.
     */
    private int nMosters;
    /**
     * number of blocks.
     */
    private int nBlocks;
    /**
     * board size.
     */
    private int boardSize;
    /**
     * end game flag.
     */
    private boolean endGame;
    /**
     * Hero.
     */
    private Hero hero;
    /**
     * Constructor.
     * @param board - board.
     * @param fieldSize - fieldsize.
     * @param nBlocks - number of blocks.
     * @param nMonsters - number of monsters.
     */
    public Board(List<Figure> board, int fieldSize, int nMonsters, int nBlocks) {
        this.board = board;
        this.nMosters = nMonsters;
        this.nBlocks = nBlocks;
        this.boardSize = fieldSize;
        this.endGame = false;
        hero = new Hero(cellGenerator());
        init();
    }
    /**
     * board initialization.
     */
    private void init() {
        System.out.println("Hero on " + hero.getPosition().toString());

        for (int i = 0; i < this.nBlocks; i++) {
            Cell cell = cellGenerator();
            this.board.add(new Block(cell));
            System.out.println("Block on " + cell.toString());
        }

        for (int i = 0; i < this.nMosters; i++) {
            Runnable r = () -> {
                Monster m = new Monster(cellGenerator(), boardSize);
                while (true) {
                    if (this.endGame) {
                        Thread.currentThread().interrupt();
                        return;
                    } else {
                        if (m.getPosition().equals(this.hero.getPosition())) {
                            this.endGame = true;
                            System.out.println("GAME OVER");
                            Thread.currentThread().interrupt();
                        }
                        Cell c = m.move();
                        if (canIGo(c) && !m.getPosition().equals(c)) {
                            m.setPosition(c);
                        }
                        if (!Thread.currentThread().isInterrupted()) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            };
            Thread tr = new Thread(r);
            tr.start();
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
        } while (!canIGo(cell));
        return cell;
    }
    /**
     * Check for empty cell.
     * @param cell - cell.
     * @return - .
     */
    private boolean canIGo(Cell cell) {
        if (cell.getX() < 0 && cell.getY() < 0
                && cell.getX() > this.boardSize - 1 && cell.getY() > this.boardSize - 1) {
            return false;
        }
        for (Figure f : board) {
            if (f.getPosition().equals(cell)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Test main method.
     * @param args - .
     */
    public static void main(String[] args) {
        List<Figure> fig = new LinkedList<>();
        Board board = new Board(fig, 10, 7, 4);
    }
}
