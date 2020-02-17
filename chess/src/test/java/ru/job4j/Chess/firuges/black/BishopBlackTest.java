package ru.job4j.Chess.firuges.black;

import org.junit.Test;
import ru.job4j.Chess.Exception.ImpossibleMoveException;
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

    /**
     * Проверяю верное перемещение фигуры.
     */
    @Test
    public void whenCurrentWayThenWay() {
        Cell start = Cell.C1;
        Cell end = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(start);
        Cell[] steps = bishopBlack.way(start, end);
        assertThat(steps[steps.length - 1], is(end));
        assertThat(steps.length, is(4));
    }

    /**
     * Проверяю неверное перемещение фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentWayThenNotWay() {
        Cell start = Cell.C6;
        Cell end = Cell.C7;
        BishopBlack figure = new BishopBlack(start);
        assertThat(figure.way(start, end), is(new Cell[]{end}));
    }
}

