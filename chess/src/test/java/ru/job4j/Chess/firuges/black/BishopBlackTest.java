package ru.job4j.Chess.firuges.black;

import org.junit.Test;
import ru.job4j.Chess.firuges.Cell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenBlackBishopTakesTheRightPositionAndCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.position();
        bishopBlack.copy(Cell.C1);
    }

    @Test
    public void whenBlackBishopRightWayWhenWayContainsDest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(steps[steps.length - 1], is(Cell.G5));
        assertThat(steps.length, is(4));
    }
}
