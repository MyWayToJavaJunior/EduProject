package ru.waysearcher;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 5/22/2017.
 */
public class BoardTest {
    /**
     * Test.
     */
    @Test
    public void whenSomeBlocksThenFindTheWay() {
        Cell[] b = {new Cell(0, 4), new Cell(1, 2), new Cell(1, 4), new Cell(2, 3), new Cell(3, 1), new Cell(3, 3)};
        Board board = new Board(Arrays.asList(b), 5, new Cell(0, 0), new Cell(4, 4));
        List<Cell> result = board.go();
        Cell[] data = {new Cell(0, 0), new Cell(0, 1), new Cell(1, 1), new Cell(2, 1), new Cell(2, 2), new Cell(3, 2),
                        new Cell(4, 2), new Cell(4, 3)};
        List<Cell> testData = Arrays.asList(data);
        assertThat(result, is(testData));
    }
}
