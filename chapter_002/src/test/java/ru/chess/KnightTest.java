package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/31/2017.
 */
public class KnightTest {
    /**
     * Test Knight go to cell.
     */
    @Test
    public void whenKingCanGoThenOk() {
        Cell position = new Cell(3, 3);
        Figure f = new Knight(position);
        Cell dist = new Cell(1, 4);
        Cell[] result = f.way(dist);
        Cell[] testData = new Cell[] {new Cell(1, 4)};
        assertThat(testData, is(result));
    }

    /**
     * Test Knight can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenKingCantGoThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new Knight(position);
        Cell dist = new Cell(4, 4);
        Cell[] result = f.way(dist);
    }
}
