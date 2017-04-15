package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/30/2017.
 */
public class KingTest {
    /**
     * Test king go to cell.
     */
    @Test
    public void whenKingCanGoThenOk() {
        Cell position = new Cell(3, 3);
        Figure f = new King(position);
        Cell dist = new Cell(4, 4);
        Cell[] result = f.way(dist);
        Cell[] testData = new Cell[] {new Cell(4, 4)};
        assertThat(testData, is(result));
    }

    /**
     * Test king can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenKingCantGoThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new King(position);
        Cell dist = new Cell(5, 3);
        Cell[] result = f.way(dist);
    }
}
