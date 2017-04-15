package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/30/2017.
 */
public class BishopTest {
    /**
     * Test Bishop go to cell.
     */
    @Test
    public void whenBishopCanGoThenOk() {
        Cell position = new Cell(3, 3);
        Figure f = new Bishop(position);
        Cell dist = new Cell(5, 5);
        Cell[] result = f.way(dist);
        Cell[] testData = new Cell[] {new Cell(4, 4), new Cell(5, 5)};
        assertThat(testData, is(result));
    }

    /**
     * Test Bishop can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenBishopGoLikeRookThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new Bishop(position);
        Cell dist = new Cell(5, 3);
        Cell[] result = f.way(dist);
    }

    /**
     * Test Bishop can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenBishopGoLikeKnightThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new Bishop(position);
        Cell dist = new Cell(4, 5);
        Cell[] result = f.way(dist);
    }
}
