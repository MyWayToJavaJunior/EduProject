package ru.bomber2;

import java.util.Random;

/**
 * Created by nik on 6/22/2017.
 */
public class Monster extends Figure implements Runnable{
    public Monster(Cell position, Board board) {
        super(position, board);
    }

    @Override
    public void run() {
        synchronized (this.getPosition()) {
            while (true) {
                Random random = new Random();
                int direct;
                Cell newPosition = null;

                while (newPosition == null) {
                    direct = random.nextInt(4);
                    switch (direct) {
                        case 0:
                            newPosition = nextCell(Direction.UP);
                            break;
                        case 1:
                            newPosition = nextCell(Direction.RIGHT);
                            break;
                        case 2:
                            newPosition = nextCell(Direction.DOWN);
                            break;
                        case 3:
                            newPosition = nextCell(Direction.LEFT);
                    }
                }
                this.getBoard().busy(newPosition);

                synchronized (newPosition) {
                    this.setPosition(this.getBoard().getCell(newPosition.getX(), newPosition.getY()));
                    this.getBoard().free(newPosition);
                    newPosition = null;
                    System.out.println(Thread.currentThread().getName() + " " + this.getPosition().getX() + ", " + this.getPosition().getY());
                }
            }
        }
    }

    public Cell nextCell(Direction direction) {

        switch (direction) {
            case DOWN: {
                if (this.getPosition().getY() > 0 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX(), this.getPosition().getY() - 1);
                }
            }
            case UP: {
                if (this.getPosition().getY() < this.getBoard().getBoardSize() - 1 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX(), this.getPosition().getY() + 1);
                }
            }
            case LEFT: {
                if (this.getPosition().getX() > 0 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX() - 1, this.getPosition().getY());
                }
            }
            case RIGHT: {
                if (this.getPosition().getX() < this.getBoard().getBoardSize() - 1 && this.getPosition().isEmpty()) {
                    return this.getBoard().getCell(this.getPosition().getX() + 1, this.getPosition().getY());
                }
            }
        }
        return null;
    }
}
