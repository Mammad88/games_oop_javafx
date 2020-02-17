package ru.job4j.Chess.logic;

import org.junit.Test;
import ru.job4j.Chess.Exception.FigureNotFoundException;
import ru.job4j.Chess.Exception.ImpossibleMoveException;
import ru.job4j.Chess.Exception.OccupiedWayException;
import ru.job4j.Chess.Logic;
import ru.job4j.Chess.firuges.Cell;
import ru.job4j.Chess.firuges.black.BishopBlack;
import ru.job4j.Chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем логику шахмат.
 *
 * @author Bruki Mammad (bruki_mammad@mail.ru)
 * @version 2.0
 * @since 15.02.2020
 */
public class LogicTest {

    /**
     * Тестирую ход фигуры.
     */
    @Test
    public void whenCurrentMoveFigureThenMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        assertThat(logic.move(Cell.C8, Cell.G4), is(true));
    }

    /**
     * Тестирую неверный ход фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenNotCurrentMoveFigureThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        assertThat(logic.move(Cell.C8, Cell.G8), is(true));
    }

    /**
     * Тестирую перекрытый путь для фигуры.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedWayThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.D7));
        assertThat(logic.move(Cell.C8, Cell.G4), is(true));
    }

    /**
     * Фигура не найдена.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C8, Cell.G4), is(true));
    }
}
