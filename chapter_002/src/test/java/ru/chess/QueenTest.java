package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/30/2017.
 */
public class QueenTest {
    /**
     * Test Queen go to cell.
     */
    @Test
    public void whenQueenCanGoThenOk() {
        Cell position = new Cell(3, 2);
        Figure f = new Queen(position);
        Cell dist = new Cell(5, 4);
        Cell[] result = f.way(dist);
        Cell[] testData = new Cell[] {new Cell(4, 3), new Cell(5, 4)};
        assertThat(testData, is(result));
    }

    /**
     * Test queen can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenQueenCantGoThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new Queen(position);
        Cell dist = new Cell(7, 5);
        Cell[] result = f.way(dist);
    }

    /**
     * Test queen can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenQueenGoLikeKnightThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new Queen(position);
        Cell dist = new Cell(4, 5);
        Cell[] result = f.way(dist);
    }
}
