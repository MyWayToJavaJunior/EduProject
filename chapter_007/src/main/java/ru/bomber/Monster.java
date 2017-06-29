package ru.bomber;

import java.util.Random;

/**
 * Created by nik on 6/22/2017.
 */
public class Monster extends Figure implements Runnable {
    /**
     * constructor.
     * @param position - position.
     * @param board - board.
     */
    public Monster(Cell position, Board board) {
        super(position, board);
    }
    /**
     * lock.
     */
    private static final Object LOCK_1 = new Object();
    /**
     * lock.
     */
    private static final Object LOCK_2 = new Object();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Cell newPosition = null;
            while (newPosition == null) {
                newPosition = nextCell(nextDirection());
            }

            if (this.getPosition().getY() > newPosition.getY()) {
                synchronized (newPosition) {
                    synchronized (this.getPosition()) {
                        doStep(newPosition);
                    }
                }
            } else if (this.getPosition().getY() < newPosition.getY()) {
                synchronized (this.getPosition()) {
                    synchronized (newPosition) {
                        doStep(newPosition);
                    }
                }
            } else if (this.getPosition().getY() == newPosition.getY() && this.getPosition().getX() > newPosition.getX()) {
                synchronized (LOCK_1) {
                    synchronized (newPosition) {
                        synchronized (this.getPosition()) {
                            doStep(newPosition);
                        }
                    }
                }
            } else {
                synchronized (LOCK_2) {
                    synchronized (this.getPosition()) {
                        synchronized (newPosition) {
                            doStep(newPosition);
                        }
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    /**
     * do step.
     * @param newPosition - new position.
     */
    private void doStep(Cell newPosition) {
        this.getBoard().busy(newPosition);
        this.setPosition(this.getBoard().getCell(newPosition.getX(), newPosition.getY()));
        this.getBoard().free(newPosition);
        newPosition = null;
        System.out.println(Thread.currentThread().getName() + " " + this.getPosition().getX() + ", " + this.getPosition().getY());
    }
    /**
     * get next direction.
     * @return - next direction.
     */
    private Direction nextDirection() {
        Random random = new Random();
        int direct = random.nextInt(4);
        Direction result;
        switch (direct) {
            case 0:
                result = Direction.UP;
                break;
            case 1:
                result = Direction.RIGHT;
                break;
            case 2:
                result = Direction.DOWN;
                break;
            case 3:
                result = Direction.LEFT;
                break;
            default: result = Direction.DOWN;
        }
        return result;
    }
    /**
     * get next cell.
     * @param direction - direction.
     * @return - next cell.
     */
    private Cell nextCell(Direction direction) {
        switch (direction) {
            case DOWN:
                if (this.getPosition().getY() > 0 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX(), this.getPosition().getY() - 1);
                }
            case UP:
                if (this.getPosition().getY() < this.getBoard().getBoardSize() - 1 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX(), this.getPosition().getY() + 1);
                }
            case LEFT:
                if (this.getPosition().getX() > 0 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX() - 1, this.getPosition().getY());
                }
            case RIGHT:
                if (this.getPosition().getX() < this.getBoard().getBoardSize() - 1 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX() + 1, this.getPosition().getY());
                }
            default:
                return null;
        }
    }
}
