package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/27/2017.
 */
public class BoardTest {
    /**
     * Test Figure can go.
     */
    @Test
    public void whenFigureCanGoThenOk() {
        Cell rookStart = new Cell(1, 1);
        Rook rook = new Rook(rookStart);

        Figure[] figures = new Figure[] {rook};

        Board board = new Board(figures);

        Cell sell01 = new Cell(1, 1);
        Cell sell02 = new Cell(1, 6);

        board.move(sell01, sell02);

        Cell result = new Cell(1,  6);

        assertThat(figures[0].getPosition(), is(result));
    }

    /**
     * Test Figure can go.
     */
    @Test
    public void whenKnightCanJumpThenOk() {
        Cell rookStart = new Cell(1, 1);
        Cell breaker = new Cell(1, 2);
        Figure k = new Knight(rookStart);
        Figure b = new Pawn(breaker);

        Figure[] figures = new Figure[] {k, b};

        Board board = new Board(figures);

        Cell sell01 = new Cell(1, 1);
        Cell sell02 = new Cell(2, 3);

        board.move(sell01, sell02);

        Cell result = new Cell(2,  3);

        assertThat(figures[0].getPosition(), is(result));
    }

    /**
     * Test Figure way is occupied.
     */
    @Test (expected = OccupiedWayException.class)
    public void whenWayOfFigureIsOccupiedThenEx() {
        Cell bishopStart = new Cell(1, 1);
        Cell other = new Cell(4, 1);
        Rook rook = new Rook(bishopStart);
        Rook rook1 = new Rook(other);
        Figure[] figures = new Figure[] {rook, rook1};
        Board board = new Board(figures);
        Cell sell01 = new Cell(1, 1);
        Cell sell02 = new Cell(6, 1);
        board.move(sell01, sell02);
    }

    /**
     * Test Figure not found.
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenFigureNotFoundThenEx() {
        Cell bishopStart = new Cell(1, 1);
        Cell other = new Cell(4, 1);
        Rook rook = new Rook(bishopStart);
        Rook rook1 = new Rook(other);
        Figure[] figures = new Figure[] {rook, rook1};
        Board board = new Board(figures);
        Cell sell01 = new Cell(2, 2);
        Cell sell02 = new Cell(6, 1);
        board.move(sell01, sell02);
    }

    /**
     * Test Figure imposible to move.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenFigureImposibleToMoveThenEx() {
        Cell bishopStart = new Cell(1, 1);
        Cell other = new Cell(4, 1);
        Rook rook = new Rook(bishopStart);
        Rook rook1 = new Rook(other);
        Figure[] figures = new Figure[] {rook, rook1};
        Board board = new Board(figures);
        Cell sell01 = new Cell(1, 1);
        Cell sell02 = new Cell(10, 10);
        board.move(sell01, sell02);
    }

}
