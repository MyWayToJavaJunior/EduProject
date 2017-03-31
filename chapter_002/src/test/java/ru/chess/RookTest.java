package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/26/2017.
 */
public class RookTest {
    /**
     * Test Rook go to cell.
     */
    @Test
    public void whenRookCanGoThenOk() {
        Cell position = new Cell(3, 3);
        Rook b = new Rook(position);
        Cell dist = new Cell(3, 1);
        Cell[] result = b.way(dist);
        Cell[] testData = new Cell[] {new Cell(3, 2), new Cell(3, 1)};
        assertThat(testData, is(result));
    }

    /**
     * Test rook can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenRookGoLikeBishopThenException() {
        Cell position = new Cell(3, 3);
        Rook b = new Rook(position);
        Cell dist = new Cell(1, 1);
        Cell[] result = b.way(dist);
    }

    /**
     * Test rook can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenRookGoLikeKnightThenException() {
        Cell position = new Cell(3, 3);
        Rook b = new Rook(position);
        Cell dist = new Cell(4, 5);
        Cell[] result = b.way(dist);
    }
}
